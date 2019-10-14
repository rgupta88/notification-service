package com.tsystem.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import com.tsystem.models.Channels;
import com.tsystem.models.Message;
import com.tsystem.models.Recipient;

@Component
@XmlRootElement
public class NotificationDto {
	Channels notificationChannel;

	List<Recipient> recipientList;
	Message message;
	String clientId;

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

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}
