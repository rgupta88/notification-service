package com.tsystem.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tsystem.models.Notification;
import com.tsystem.models.Recipient;
import com.tsystem.repo.InMemoryRepo;

@Component
public class SMSServiceImpl extends NotificationRepoUpdateService {

	public SMSServiceImpl(InMemoryRepo repo) {
		setRepo(repo);
	}

	@Override
	public void notify(Notification notification) {
		sendSmsNotification(notification.getRecipientList());
		updateNotificationRepo(notification);
	}

	private void sendSmsNotification(List<Recipient> recipientList) {
		for (Recipient recipient : recipientList) {
			System.out.println("Send SMS notification to user : " + recipient.getUserId());
		}
	}

}
