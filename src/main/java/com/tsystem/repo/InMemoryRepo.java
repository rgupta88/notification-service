package com.tsystem.repo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tsystem.models.Client;
import com.tsystem.models.SubscriptionTypeLimitPerDay;

@Repository
public class InMemoryRepo {

	private Map<String, Client> clientMap = new HashMap<String, Client>();
	private Map<String, Map<String, SubscriptionTypeLimitPerDay>> notificationMap = new HashMap<String, Map<String, SubscriptionTypeLimitPerDay>>();
	public Map<String, Client> getClientMap() {
		return clientMap;
	}
	public void setClientMap(Map<String, Client> clientMap) {
		this.clientMap = clientMap;
	}
	public Map<String, Map<String, SubscriptionTypeLimitPerDay>> getNotificationMap() {
		return notificationMap;
	}
	public void setNotificationMap(Map<String, Map<String, SubscriptionTypeLimitPerDay>> notificationMap) {
		this.notificationMap = notificationMap;
	}
	

}
