package com.amiaka.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(@SuppressWarnings("null") WebSocketHandlerRegistry registry) {
		registry.addHandler(new SignalingWebSocketHandler(), "/video-call/{sessionId}").setAllowedOrigins("*");

	}

}
