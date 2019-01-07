package com.spring.production.listener;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerJob implements Runnable {
  private Logger logger = LoggerFactory.getLogger(ServerJob.class);
  private int port = 0;
  private int size = 0;

  public ServerJob(int port, int size) {
    this.port = port;
    this.size = size;
  }

  public void run() {
    ServerSocket serverSocket = null;
    Socket socket = null;
    int count = 0;
    try {
      serverSocket = new ServerSocket(port);
      while (true) {
        socket = serverSocket.accept();

        ReceiveJob serverThread = new ReceiveJob(socket, size);
        serverThread.start();

        count++;
        logger.info("client count：" + count);
        InetAddress address = socket.getInetAddress();
        logger.info("current client IP：" + address.getHostAddress());
      }
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    }
  }
}
