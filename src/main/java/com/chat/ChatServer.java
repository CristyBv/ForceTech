package com.chat;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;

@ServerEndpoint("/chatserver")
public class ChatServer {
    static Set<Session> chatUsers = Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void handleOpen(Session userSession){
        chatUsers.add(userSession);
    }

    @OnMessage
    public void handleMessage(String message, Session userSession) throws IOException {
        String username = (String) userSession.getUserProperties().get("username");
        if(username == null){
            userSession.getUserProperties().put("username",message);
            userSession.getBasicRemote().sendText("You are now connected as "+message);
        }
        else{
            Iterator<Session> iterator = chatUsers.iterator();
            while(iterator.hasNext()){
                iterator.next().getBasicRemote().sendText(username + " : " + message);
            }
        }
    }

    @OnClose
    public void handleClose(Session userSession){
        chatUsers.remove(userSession);
    }
}
