package com.spring.production.tools;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class ToolUtility {
  
  /**
   * isEmpty
   * 
   * Test to see whether input string is empty.
   * 
   * @param str
   * @return True if it is empty; false if it is not.
   */
  public static boolean isEmpty(String str){
    return(str == null || str.length() == 0 || str.trim().equals("") );
  }
  
  /**
   * isEmpty
   * 
   * Test to see whether input string buffer is empty.
   * 
   * @param stringBuffer
   * @return True if it is empty; false if it is not.
   */
  public static boolean isEmpty(StringBuffer stringBuffer){
    return(stringBuffer == null || stringBuffer.length() == 0 || stringBuffer.toString().trim().equals("") );
  }
  
  public static boolean isEmpty(Object[] array) {
    return (array == null || array.length == 0);
  } 
  
  public static boolean isEmpty(Object val) {
    return (val == null);
  }
  
  public static boolean isEmpty(java.util.List<? extends Object> list) {
    return (list == null || list.size() == 0);
  }

  public static Date getCurrentDate() {
    java.util.Calendar tmp = java.util.Calendar.getInstance();
    return (new Date(tmp.getTime().getTime()));
  }
  
  public static Date getStartTime(Date timestamp) {
    if(isEmpty(timestamp)) {
      timestamp = getCurrentDate();
    }
    Calendar todayStart = Calendar.getInstance();
    todayStart.setTime(timestamp);
    todayStart.set(Calendar.HOUR_OF_DAY, 0);
    todayStart.set(Calendar.MINUTE, 0);
    todayStart.set(Calendar.SECOND, 0);
    todayStart.set(Calendar.MILLISECOND, 0);
    return new Timestamp(todayStart.getTime().getTime());
  }

  public static Date getEndTime(Date timestamp) {
    if(isEmpty(timestamp)) {
      timestamp = getCurrentDate();
    }
    Calendar todayEnd = Calendar.getInstance();
    todayEnd.setTime(timestamp);
    todayEnd.set(Calendar.HOUR_OF_DAY, 23);
    todayEnd.set(Calendar.MINUTE, 59);
    todayEnd.set(Calendar.SECOND, 59);
    todayEnd.set(Calendar.MILLISECOND, 999);
    return new Date(todayEnd.getTime().getTime());
  }
  
  public static int calculate(String sigore) {
    int l = sigore.charAt(4);
    int h = sigore.charAt(7);
    return (h - l + 1) * 20;
  }
}
