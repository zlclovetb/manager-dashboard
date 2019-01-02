package com.spring.production.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.production.entity.OrderPlan;
import com.spring.production.entity.OrderPlanExample;
import com.spring.production.entity.OrderPlanExample.Criteria;
import com.spring.production.service.OrderPlanService;

@Component
public class TodayOrderCache implements InitializingBean {
  final Lock lock = new ReentrantLock();
  @Autowired
  protected OrderPlanService orderPlanService;
  
  private static Map<String, List<OrderPlan>> orderMap = null;
  
  public List<OrderPlan> getTodayOrderList(String today){
    lock.lock();
    List<OrderPlan> orderList = orderMap.get(today);
    lock.unlock();
    return orderList;
  }
  
  public void fireCache() {
    lock.lock();
    if(ToolUtility.isEmpty(orderMap)) {
      orderMap = new Hashtable<>();
    } else {
      orderMap.clear();
    }
    initCache();
    lock.unlock();
  }
  
  @Override
  public void afterPropertiesSet() throws Exception {
    if(ToolUtility.isEmpty(orderMap)) {
      orderMap = new Hashtable<>();
      initCache();
    }
    
  }
  
  private void initCache() {
    OrderPlanExample example = new OrderPlanExample();
    Criteria criteria = example.createCriteria();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    example.setOrderByClause("'PRO_DATE' ASC");
    String str = simpleDateFormat.format(new Date());
    Date startTime = ToolUtility.getStartTime(null);
    Date endTime = ToolUtility.getEndTime(null);
    criteria.andProDateBetween(startTime, endTime);
    List<OrderPlan> orderPlanlist = orderPlanService.selectByExample(example);
    orderMap.put(str, orderPlanlist);
  }
}
