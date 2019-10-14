package com.tsystem.service.impl;

import java.util.List;

import com.tsystem.models.Notification;
import com.tsystem.models.Recipient;
import com.tsystem.repo.InMemoryRepo;

public class PushServiceImpl extends NotificationRepoUpdateService {


	public PushServiceImpl(InMemoryRepo repo) {
		setRepo(repo);
	}

	@Override
	public void notify(Notification notification) {
		sendPushNotification(notification.getRecipientList());
		updateNotificationRepo(notification);
	}

	private void sendPushNotification(List<Recipient> recipientList) {
		for (Recipient recipient : recipientList) {
			System.out.println("Push notification to user : " + recipient.getUserId());
		}

	}

}
