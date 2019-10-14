package com.tsystem.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubscriptionTypeLimitPerDay {

	private Map<Channels, Integer> limitPerChannelType = new HashMap<Channels, Integer>();

	private List<Notification> notificationList = new ArrayList<Notification>();

	public void addNotificationDetails(Notification notification) {
		notificationList.add(notification);
		addLimitDetails(notification);

	}

	private void addLimitDetails(Notification notification) {
		if (limitPerChannelType.get(notification.getNotificationChannel()) == null) {
			limitPerChannelType.put(notification.getNotificationChannel(), notification.recipientList.size());
		} else {
			Integer count = limitPerChannelType.get(notification.getNotificationChannel());
			count = count + notification.recipientList.size();
			limitPerChannelType.put(notification.getNotificationChannel(), count);
		}

	}

	public Map<Channels, Integer> getLimitPerChannelType() {
		return limitPerChannelType;
	}

	public List<Notification> getNotificationList() {
		return notificationList;
	}

}
