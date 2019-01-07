package com.spring.production.listener;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReceiveJob extends Thread {
  private Logger logger = LoggerFactory.getLogger(ReceiveJob.class);
  Socket socket = null;

  public ReceiveJob(Socket socket) {
    this.socket = socket;
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
        logger.info("I am tep server, client say: " + info);
      }
      socket.shutdownInput();
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
    } finally {
      // 关闭资源
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
