package com.spring.production.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.production.ProductionConstant;
import com.spring.production.entity.OrderPlan;
import com.spring.production.service.OrderPlanService;
import com.spring.production.socketio.EventListennter;
import com.spring.production.tools.ToolUtility;
import com.spring.production.tools.TodayOrderCache;

@Controller
@RequestMapping("/server")
public class SocketController {

  @Autowired
  private EventListennter eventListennter;
  @Autowired
  protected TodayOrderCache todayOrderCache;
  @Autowired
  protected OrderPlanService orderPlanService;

  @RequestMapping(path = "send/{count}", method = RequestMethod.GET)
  public void sendMsg(@PathVariable("count") String count) {
    System.err.println("send Msg....");
    String line = "0";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String str = simpleDateFormat.format(new Date());
    List<OrderPlan> orderPlanlist = todayOrderCache.getTodayOrderList(str);
    OrderPlan orderPlan = new OrderPlan();
    if (!ToolUtility.isEmpty(orderPlanlist)) {
      OrderPlan tmPlan = null;
      for (int i = 1; i < orderPlanlist.size() + 1; i++) {
        tmPlan = orderPlanlist.get(i - 1);
        if (!ProductionConstant.PRODUCTION_STATUS_COMPLETE.equals(tmPlan.getProStatus())) {
          line = i + "";
          orderPlan.setId(tmPlan.getId());
          if(!ToolUtility.isEmpty(tmPlan.getActualCount())) {
            orderPlan.setActualCount(tmPlan.getActualCount() + Integer.valueOf(count));
            tmPlan.setActualCount(tmPlan.getActualCount() + Integer.valueOf(count));
          }else {
            orderPlan.setActualCount(Integer.valueOf(count));
            tmPlan.setActualCount(Integer.valueOf(count));
          }
          orderPlanService.updateByPrimaryKeySelective(orderPlan);
          break;
        }
      }
    }

    eventListennter.pushMsg(line, orderPlan.getActualCount() + "");
  }

}
