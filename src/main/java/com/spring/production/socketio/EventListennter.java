package com.spring.production.socketio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.spring.production.tools.ToolUtility;

@Component
public class EventListennter {
  // 维护每个客户端的SocketIOClient
  private static final Logger logger = LoggerFactory.getLogger(EventListennter.class);
  private static Map<String, List<SocketIOClient>> clients = new ConcurrentHashMap<>();
  private static Map<String, String> sessionMap = new ConcurrentHashMap<>();

  @OnConnect
  public void onConnect(SocketIOClient client) {
    logger.debug("remove client:"+client.getRemoteAddress()+" create connection.........");
  }

  @OnEvent("token")
  public void onToken(SocketIOClient client, SocketIOMessage message) {
    logger.debug("client sessionID is " + client.getSessionId().toString());
    List<SocketIOClient> socketList = clients.get(message.getToken());
    if (ToolUtility.isEmpty(socketList)) {
      socketList = new ArrayList<>();
      clients.put(message.getToken(), socketList);
    }
    if (!socketList.contains(client)) {
      socketList.add(client);
      sessionMap.put(client.getSessionId().toString(), message.getToken());
      logger.debug(" " + client.getRemoteAddress() + "||" + message.getToken());
    }
    logger.debug("get token Message is " + client.getRemoteAddress() + "||" + message.getToken());
  }

  /**
   * 新事务
   * 
   * @param client 客户端
   * @param message 消息
   */
  @OnEvent("newAlert")
  public void onAlert(SocketIOClient client, SocketIOMessage message) {
    // send to all users
    Collection<List<SocketIOClient>> clientsList = clients.values();
    for (List<SocketIOClient> list : clientsList) {
      for (SocketIOClient socketIOClient : list) {
        socketIOClient.sendEvent("newAlert", message);
      }
    }
  }

  public void pushMsg(String line, String count) {
    Set<Entry<String, List<SocketIOClient>>> entrySet = clients.entrySet();
    for (Entry<String, List<SocketIOClient>> entry : entrySet) {
      String token = entry.getKey();
      List<SocketIOClient> value = entry.getValue();
      for (SocketIOClient socketIOClient : value) {
        SocketIOMessage message = new SocketIOMessage();
        message.setMessage(count);
        message.setToken(token);
        message.setLine(line);
        socketIOClient.sendEvent("newAlert", message);
      }
    }
  }

  @OnDisconnect
  public void onDisconnect(SocketIOClient client) {
    logger.debug("********************WebClose******************");
  }
}
