package com.tsystem.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.tsystem.models.Notification;
import com.tsystem.models.SubscriptionTypeLimitPerDay;
import com.tsystem.repo.InMemoryRepo;
import com.tsystem.services.NotificationService;

@Component
public abstract class NotificationRepoUpdateService implements NotificationService {

	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	private InMemoryRepo repo;

	public void setRepo(InMemoryRepo repo){
		this.repo = repo;
	}

	public void updateNotificationRepo(Notification notification) {
		Map<String, Map<String, SubscriptionTypeLimitPerDay>> completeNotificationData = repo.getNotificationMap();
		// per day subscription object having map for per channel user count
		Map<String, SubscriptionTypeLimitPerDay> notificationMapPerClient = completeNotificationData
				.get(notification.getClientId());
		Date currentDate = new Date();
		String today = dateFormat.format(currentDate);
		if (notificationMapPerClient == null) {
			notificationMapPerClient = new HashMap<String, SubscriptionTypeLimitPerDay>();
			SubscriptionTypeLimitPerDay subscriptionlimitPerDay = new SubscriptionTypeLimitPerDay();
			subscriptionlimitPerDay.addNotificationDetails(notification);
			notificationMapPerClient.put(today, subscriptionlimitPerDay);
			completeNotificationData.put(notification.getClientId(), notificationMapPerClient);
		} else {
			SubscriptionTypeLimitPerDay subscriptionlimitPerDay = notificationMapPerClient.get(today);
			if (subscriptionlimitPerDay == null) {
				subscriptionlimitPerDay = new SubscriptionTypeLimitPerDay();
			}
			subscriptionlimitPerDay.addNotificationDetails(notification);
			notificationMapPerClient.put(today, subscriptionlimitPerDay);
			completeNotificationData.put(notification.getClientId(), notificationMapPerClient);
		}

	}
}
