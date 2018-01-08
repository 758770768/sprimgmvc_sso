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
 * @author Administrator websocket������
 */
@Component
public class MyFirstHandler extends TextWebSocketHandler {

	/**
	 * Ⱥ����Ϣ����session
	 */
	private static final List<WebSocketSession> users = new ArrayList<>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.socket.handler.AbstractWebSocketHandler#
	 * afterConnectionClosed(org.springframework.web.socket.WebSocketSession,
	 * org.springframework.web.socket.CloseStatus) ���ӹر�֮��
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println(session.getLocalAddress() + ":���ӹر�");
		users.remove(session);
		super.afterConnectionClosed(session, status);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.socket.handler.AbstractWebSocketHandler#
	 * afterConnectionEstablished(org.springframework.web.socket.
	 * WebSocketSession) ���ӽ���֮��
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println(session.getLocalAddress() + ":���ӽ���");
		users.add(session);
		super.afterConnectionEstablished(session);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.socket.handler.AbstractWebSocketHandler#
	 * handleTextMessage(org.springframework.web.socket.WebSocketSession,
	 * org.springframework.web.socket.TextMessage) ������Ϣ
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println(session.getLocalAddress() + ":��Ϣ����:" + message.getPayload());
		sendMessageToAllUsers(message);
		super.handleTextMessage(session, message);
		// new TextMessage("helllo owrld!".getBytes());
	}

	/**
	 * �Զ��巽������������Ϣ�������û�
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
	 *             �Զ��巽��������Ϣ��ָ���ͻ�
	 */
	private void sendMessageToUser(TextMessage mess, WebSocketSession ws) throws IOException {
		ws.sendMessage(mess);
		System.out.println("������������Ϣ:" + ws.getRemoteAddress());
	}

}
