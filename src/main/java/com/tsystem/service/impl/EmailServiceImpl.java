package com.tsystem.service.impl;

import java.util.List;

import com.tsystem.models.Notification;
import com.tsystem.models.Recipient;
import com.tsystem.repo.InMemoryRepo;

public class EmailServiceImpl extends NotificationRepoUpdateService {

	public EmailServiceImpl(InMemoryRepo repo) {
		setRepo(repo);
	}

	@Override
	public void notify(Notification notification) {

		sendEmailNotification(notification.getRecipientList());
		updateNotificationRepo(notification);
	}

	private void sendEmailNotification(List<Recipient> recipientList) {
		for (Recipient recipient : recipientList) {
			System.out.println("Sending email to user : " + recipient.getUserId());
		}

	}
}
