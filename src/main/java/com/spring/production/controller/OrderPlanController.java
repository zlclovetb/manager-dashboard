package com.spring.production.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.spring.production.ProductionConstant;
import com.spring.production.entity.OrderPlan;
import com.spring.production.entity.OrderPlanExample;
import com.spring.production.entity.OrderPlanExample.Criteria;
import com.spring.production.service.OrderPlanService;
import com.spring.production.tools.TodayOrderCache;
import com.spring.production.tools.ToolUtility;

@Controller
@RequestMapping("/orderPlan")
public class OrderPlanController {
  @Autowired
  protected OrderPlanService orderPlanService;
  @Autowired
  protected TodayOrderCache todayOrderCache;
  
  @RequestMapping(path="toInsert", method=RequestMethod.GET)
  public String toInsert(Model model) {
    return "orderPlan";
  }
  
  /*@RequestMapping(path="insert", method=RequestMethod.POST)
  public String insert(Model model, OrderPlan orderPlan) {
    orderPlanService.insert(orderPlan);
    return "redirect:/orderPlan/toList"; 
  }*/
  
  @RequestMapping(path="insert", method=RequestMethod.POST)
  public @ResponseBody Map<String,Object> addOrder(OrderPlan orderPlan) {
    orderPlanService.insert(orderPlan);
    todayOrderCache.fireCache();
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("state", "success");
    return map;
  }
  
  @RequestMapping(path="update", method=RequestMethod.POST)
  public @ResponseBody Map<String,Object> updOrder(OrderPlan orderPlan) {
    orderPlanService.updateByPrimaryKey(orderPlan);
    todayOrderCache.fireCache();
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("state", "success");
    return map;
  }
  
  @RequestMapping(path="toList", method=RequestMethod.GET)
  public String toList(Model model, OrderPlan orderPlan) {
    OrderPlanExample example = new OrderPlanExample();
    List<OrderPlan> orderPlanlist = orderPlanService.selectByExample(example);
    model.addAttribute("dataList", orderPlanlist);
    return "orderList"; 
  }
  
  @SuppressWarnings("rawtypes")
  @RequestMapping(path="getPageInfo", method=RequestMethod.GET)
  public @ResponseBody Map<String,Object> toTableList(Model model, String orderName, String proName, String proDate, int limit,int offset) {
    OrderPlanExample example = new OrderPlanExample();
    Criteria criteria = example.createCriteria();
    if(orderName != null) {
      criteria.andOrderNameLike("%" + orderName + "%");
    }
    if(proName != null) {
      criteria.andProNameLike("%" + proName + "%");
    }
    if(proDate != null) {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      try {
        Date date = simpleDateFormat.parse(proDate);
        criteria.andProDateEqualTo(date);
      } catch (ParseException e) {
      }
    }
    
    PageHelper.offsetPage(offset, limit);
    List<OrderPlan> orderPlanlist = orderPlanService.selectByExample(example);
    model.addAttribute("dataList", orderPlanlist);
    
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("total", ((Page)orderPlanlist).getTotal());
    map.put("data", orderPlanlist);
    return map;
  }
  
  @RequestMapping(path="toList", method=RequestMethod.POST)
  public String searchList(Model model, String orderName, String proName, String proDate) {
    OrderPlanExample example = new OrderPlanExample();
    Criteria criteria = example.createCriteria();
    if(orderName != null) {
      criteria.andOrderNameLike("%" + orderName + "%");
    }
    if(proName != null) {
      criteria.andProNameLike("%" + proName + "%");
    }
    if(proDate != null) {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      try {
        Date date = simpleDateFormat.parse(proDate);
        criteria.andProDateEqualTo(date);
      } catch (ParseException e) {
      }
    }
    List<OrderPlan> orderPlanlist = orderPlanService.selectByExample(example);
    model.addAttribute("dataList", orderPlanlist);
    model.addAttribute("orderName", orderName);
    model.addAttribute("proName", proName);
    model.addAttribute("proDate", proDate);
    return "orderList"; 
  }
  
  @SuppressWarnings("rawtypes")
  @RequestMapping(path="getPageInfo", method=RequestMethod.POST)
  public @ResponseBody Map<String,Object> searchFilterList(Model model, String orderName, String proName, String proDate , int limit,int offset) {
    OrderPlanExample example = new OrderPlanExample();
    Criteria criteria = example.createCriteria();
    if(orderName != null) {
      criteria.andOrderNameLike("%" + orderName + "%");
    }
    if(proName != null) {
      criteria.andProNameLike("%" + proName + "%");
    }
    if(proDate != null) {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      try {
        Date date = simpleDateFormat.parse(proDate);
        criteria.andProDateEqualTo(date);
      } catch (ParseException e) {
      }
    }
    PageHelper.startPage(offset, limit);
    List<OrderPlan> orderPlanlist = orderPlanService.selectByExample(example);
    
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("total", ((Page)orderPlanlist).getTotal());
    map.put("data", orderPlanlist);
    
    model.addAttribute("dataList", orderPlanlist);
    model.addAttribute("orderName", orderName);
    model.addAttribute("proName", proName);
    model.addAttribute("proDate", proDate);
    return map; 
  }
  
  @RequestMapping("/delete")
  public @ResponseBody Map<String,Object> deleteOrder(HttpServletRequest request) {
    String[] list = request.getParameterValues("ids");
    for (int i = 0; i < list.length; i++) {
      String id = list[i];
      Integer orderID = Integer.valueOf(id);
      orderPlanService.deleteByPrimaryKey(orderID);
    }
    todayOrderCache.fireCache();
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("state", "success");
    return map;
  }
  
  @RequestMapping("/complete")
  public @ResponseBody Map<String,Object> completeOrder(HttpServletRequest request) {
    String[] list = request.getParameterValues("ids");
    for (int i = 0; i < list.length; i++) {
      String id = list[i];
      Integer orderID = Integer.valueOf(id);
      OrderPlan orderPlan = new OrderPlan();
      orderPlan.setId(orderID);
      orderPlan.setProStatus(ProductionConstant.PRODUCTION_STATUS_COMPLETE);
      orderPlanService.updateByPrimaryKeySelective(orderPlan);
    }
    todayOrderCache.fireCache();
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("state", "success");
    return map;
  }
  
  @RequestMapping(path="toDashboard", method=RequestMethod.GET)
  public String searchDashBoardList(Model model) {
    OrderPlanExample example = new OrderPlanExample();
    example.setOrderByClause("'PRO_DATE' ASC");
    Criteria criteria = example.createCriteria();
    Date startTime = ToolUtility.getStartTime(null);
    Date endTime = ToolUtility.getEndTime(null);
    criteria.andProDateBetween(startTime, endTime);
    List<OrderPlan> orderPlanlist = orderPlanService.selectByExample(example);
    
    Calendar cal=Calendar.getInstance();
    cal.add(Calendar.DATE, 1);
    Date sDate=cal.getTime();
    OrderPlanExample sExample = new OrderPlanExample();
    sExample.setOrderByClause("'PRO_DATE' ASC");
    Criteria sCriteria = sExample.createCriteria();
    Date startTime1 = ToolUtility.getStartTime(sDate);
    Date endTime1 = ToolUtility.getEndTime(sDate);
    sCriteria.andProDateBetween(startTime1, endTime1);
    List<OrderPlan> sOrderPlanlist = orderPlanService.selectByExample(sExample);

    model.addAttribute("tDataList", orderPlanlist);
    model.addAttribute("sDataList", sOrderPlanlist);
    return "index"; 
  }
  
  @InitBinder
  protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    simpleDateFormat.setLenient(false);
    CustomDateEditor dateEditor = new CustomDateEditor(simpleDateFormat, true);
    binder.registerCustomEditor(Date.class, dateEditor);
  }
}
