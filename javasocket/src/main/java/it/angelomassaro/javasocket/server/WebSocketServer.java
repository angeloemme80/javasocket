package it.angelomassaro.javasocket.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

@ServerEndpoint(value = "/socket")
public class WebSocketServer extends AbstractWebSocketHandler {
	
	List<WebSocketSession> sessioni = new ArrayList<WebSocketSession>();
	
	
	/*
	 * Per ogni messaggio che il server riceva, manda una risposta al client e manda un messaggio a tutti i client connessi
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
	    System.out.println("New Text Message Received: " + message);
	    session.sendMessage(message);
	    
	    for (WebSocketSession sessioneConnessa : sessioni) {
	    	sessioneConnessa.sendMessage(new TextMessage("MESSAGGIO A tutti"));
		}
	    
	}
	 
	@Override
	protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws IOException {
	    System.out.println("New Binary Message Received");
	    session.sendMessage(message);
	}
	
	/*
	 * Dopo ogni connessione di un client si conserva la sessione im modo tale da poter mandare un messaggio a tutti
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		System.out.println("ID: " + session.getId());
		sessioni.add(session);
	}
	
	
}
