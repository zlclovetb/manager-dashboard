package com.spring.production.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SocketListener implements ServletContextListener {
  private Thread thread;
  
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    ServletContext sctx = sce.getServletContext();
    String portPara = sctx.getInitParameter("socketPort");
    int prot = Integer.valueOf(portPara);
    if (thread == null) {
      ReceiveJob job = new ReceiveJob(prot);
      thread = new Thread(job);
      thread.setDaemon(true);
      thread.start();
    }
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    if (thread != null && thread.isInterrupted()) {
      thread.interrupt();
    }
  }

}
