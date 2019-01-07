package com.spring.production.listener;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring.production.tools.HttpUtils;
import com.spring.production.tools.ToolUtility;

public class ReceiveJob extends Thread {
  private Logger logger = LoggerFactory.getLogger(ReceiveJob.class);
  private Socket socket = null;
  private int size;

  public ReceiveJob(Socket socket, int size) {
    this.socket = socket;
    this.size = size;
  }

  public void run() {
    InputStream is = null;
    try {
      is = socket.getInputStream();
      String info = null;
      byte[] bytes = new byte[1024];
      int len;
      while ((len = is.read(bytes)) != -1) {
        info = new String(bytes, 0, len);
        if(info.length() == 8) {
          int size = ToolUtility.calculate(info);
          if(size > this.size) {
            HttpUtils.sendCountPlusOne();
          }
        }
        logger.info("I am tep server, client say: " + info);
      }
      socket.shutdownInput();
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
    } finally {
      try {
        if (is != null)
          is.close();
        if (socket != null)
          socket.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
