package com.amiaka.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.lang.NonNull;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class SignalingWebSocketHandler extends TextWebSocketHandler {

	private static final Map<String, List<WebSocketSession>> sessions = new HashMap<>();

	   @Override
	    public void afterConnectionEstablished(@NonNull WebSocketSession session) throws Exception {
	        String sessionId = getSessionId(session);  // Extract session ID from URL path
	        sessions.computeIfAbsent(sessionId, k -> new ArrayList<>()).add(session);
	    }
	   
	   @Override
	    public void handleTextMessage(@NonNull WebSocketSession session, @NonNull TextMessage message) throws Exception {
	        String sessionId = getSessionId(session);
	        List<WebSocketSession> sessionList = sessions.get(sessionId);
	        
	        for (WebSocketSession s : sessionList) {
	            if (!s.equals(session)) {
	                s.sendMessage(message);  // Forward the signaling message to the other participant
	            }
	        }
	    }

	private String getSessionId(WebSocketSession session) {
		 @SuppressWarnings("null")
		String uri = session.getUri().toString();
	        return uri.split("/video-call/")[1];  // Extract the sessionId from the URI
	  
	}

}
