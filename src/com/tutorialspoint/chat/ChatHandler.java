package com.tutorialspoint.chat;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/WSSchat")
public class ChatHandler {

	Map<Session, String> userUsernameMap = new HashMap<Session, String>();

	
	@javax.websocket.OnOpen
	public void OnOpen(Session session){
		userUsernameMap.put(session, "Hallo!");
		System.out.println("Session "+session.toString()+ " hat sich angemeldet!");
		 try {
			session.getBasicRemote().sendText("onOpen");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@javax.websocket.OnClose
	public void OnClose(Session session){
		userUsernameMap.remove(session);
		System.out.println("Session "+session.toString()+ " wurde entfernt!");
	}
	
	@OnMessage
	public void handleMessage(Session session, String msg){
        if (session.isOpen()) {
            try {
				session.getBasicRemote().sendText(userUsernameMap.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
	
    @OnMessage
    public void echoBinaryMessage(Session session, ByteBuffer bb,
            boolean last) {
        try {
            if (session.isOpen()) {
                session.getBasicRemote().sendBinary(bb, last);
            }
        } catch (IOException e) {
            try {
                session.close();
            } catch (IOException e1) {
                // Ignore
            }
        }
    }
}
