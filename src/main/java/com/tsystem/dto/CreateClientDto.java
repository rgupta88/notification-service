package com.tsystem.dto;

import org.springframework.stereotype.Component;

import com.tsystem.models.Subscription;

@Component
public class CreateClientDto {

	String clientId;
	Subscription subscriptionType;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public Subscription getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(Subscription subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

}
