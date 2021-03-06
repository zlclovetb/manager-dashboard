package com.spring.production.tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

public class CustomDateEdtor implements WebBindingInitializer {

  @Override
  public void initBinder(WebDataBinder binder, WebRequest request) {
    //定义转换格式  
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
    //true代表允许输入值为空  
    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));  
  }

}
