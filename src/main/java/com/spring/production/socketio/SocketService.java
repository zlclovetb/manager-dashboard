package com.spring.production.socketio;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;

@Service
public class SocketService implements InitializingBean {
  static boolean firstInit = false;
  @Autowired
  private EventListennter listeners;

  public void startServer() {
    Configuration config = new Configuration();
    config.setHostname("localhost");
    config.setPort(8089);

    SocketIOServer server = new SocketIOServer(config);
    server.addConnectListener(new ConnectListener() {// 添加客户端连接监听器
      @Override
      public void onConnect(SocketIOClient client) {
        System.err.println(client.getRemoteAddress() + " web客户端接入");
      }
    });

    server.addListeners(listeners);
    server.start();

  }

  @Override
  public void afterPropertiesSet() throws Exception {
    if (firstInit) // for not singleton , then method will be called twice.
    {
      System.out.println(" init already called");
      return;
    } else {
      firstInit = true;
      System.out.println("start socket");
      this.startServer();
    }
  }
}
