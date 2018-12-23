package com.spring.production.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.spring.production.entity.OrderPlan;
import com.spring.production.entity.OrderPlanExample;
import com.spring.production.entity.OrderPlanExample.Criteria;
import com.spring.production.service.OrderPlanService;

@Controller
@RequestMapping("/orderPlan")
public class OrderPlanController {
  @Autowired
  protected OrderPlanService orderPlanService;
  
  @RequestMapping(path="toInsert", method=RequestMethod.GET)
  public String toInsert(Model model) {
    return "orderPlan";
  }
  
  @RequestMapping(path="insert", method=RequestMethod.POST)
  public String insert(Model model, OrderPlan orderPlan) {
    orderPlanService.insert(orderPlan);
    return "redirect:/orderPlan/toList"; 
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
  
  @RequestMapping("/deleteOrder")
  public @ResponseBody Map<String,Object> deleteOrder(HttpServletRequest request) {
    String[] list = request.getParameterValues("ids");
    for (int i = 0; i < list.length; i++) {
      String id = list[i];
      Integer orderID = Integer.valueOf(id);
      orderPlanService.deleteByPrimaryKey(orderID);
    }

    Map<String, Object> map = new HashMap<String, Object>();
    map.put("state", "success");
    return map;
  }
  
  @InitBinder
  protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    simpleDateFormat.setLenient(false);
    CustomDateEditor dateEditor = new CustomDateEditor(simpleDateFormat, true);
    binder.registerCustomEditor(Date.class, dateEditor);
  }
}
