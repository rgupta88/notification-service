package com.tsystem.models;

import java.util.List;

public class Notification {

	String clientId;
	String notificationId;
	Message message;
	Channels notificationChannel;
	List<Recipient> recipientList;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public Channels getNotificationChannel() {
		return notificationChannel;
	}

	public void setNotificationChannel(Channels notificationChannel) {
		this.notificationChannel = notificationChannel;
	}

	public List<Recipient> getRecipientList() {
		return recipientList;
	}

	public void setRecipientList(List<Recipient> recipientList) {
		this.recipientList = recipientList;
	}

	public String getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}
