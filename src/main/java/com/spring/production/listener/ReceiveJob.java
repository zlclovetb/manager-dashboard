package com.spring.production.listener;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReceiveJob implements Runnable {
  private Logger logger = LoggerFactory.getLogger(ReceiveJob.class);
  private int port = 0;

  public ReceiveJob(int port) {
    this.port = port;
  }

  public void run() {
    // 准备空包
    byte[] infos = new byte[1024];
    DatagramPacket packet = new DatagramPacket(infos, infos.length);
    // 准备socket
    DatagramSocket socket = null;
    try {
      socket = new DatagramSocket(port);
      String str = "";
      while (true) {
        // 接收数据包
        socket.receive(packet);
        str = new String(packet.getData(), 0, packet.getLength());
        // 输出
        System.out.println(str);
      }
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    } finally {
      socket.close();
    }
  }
}
