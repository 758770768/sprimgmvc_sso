package org.test.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @author Administrator websocket处理器
 */
@Component
public class MyFirstHandler extends TextWebSocketHandler {

	/**
	 * 群发消息报存session
	 */
	private static final List<WebSocketSession> users = new ArrayList<>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.socket.handler.AbstractWebSocketHandler#
	 * afterConnectionClosed(org.springframework.web.socket.WebSocketSession,
	 * org.springframework.web.socket.CloseStatus) 链接关闭之后
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println(session.getLocalAddress() + ":连接关闭");
		users.remove(session);
		super.afterConnectionClosed(session, status);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.socket.handler.AbstractWebSocketHandler#
	 * afterConnectionEstablished(org.springframework.web.socket.
	 * WebSocketSession) 链接建立之后
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println(session.getLocalAddress() + ":连接建立");
		users.add(session);
		super.afterConnectionEstablished(session);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.socket.handler.AbstractWebSocketHandler#
	 * handleTextMessage(org.springframework.web.socket.WebSocketSession,
	 * org.springframework.web.socket.TextMessage) 处理消息
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println(session.getLocalAddress() + ":消息处理:" + message.getPayload());
		sendMessageToAllUsers(message);
		super.handleTextMessage(session, message);
		// new TextMessage("helllo owrld!".getBytes());
	}

	/**
	 * 自定义方法发送所有信息给所有用户
	 * 
	 * @throws IOException
	 */
	private void sendMessageToAllUsers(TextMessage mess) throws IOException {
		for (WebSocketSession e : users) {
			if (e.isOpen()) {
				e.sendMessage(mess);
				System.out.println("send to:" + e.getUri());
			}

		}
	}

	/**
	 * @param mess
	 * @param ws
	 * @throws IOException
	 *             自定义方法发送消息给指定客户
	 */
	private void sendMessageToUser(TextMessage mess, WebSocketSession ws) throws IOException {
		ws.sendMessage(mess);
		System.out.println("服务器发送消息:" + ws.getRemoteAddress());
	}

}
