package com.tsystem.models;

public class Client {

	String clientId;
	Subscription subscriptionType;
	String subscriptionStartDate;
	String subscriptionEndDate;

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

	public String getSubscriptionStartDate() {
		return subscriptionStartDate;
	}

	public void setSubscriptionStartDate(String subscriptionStartDate) {
		this.subscriptionStartDate = subscriptionStartDate;
	}

	public String getSubscriptionEndDate() {
		return subscriptionEndDate;
	}

	public void setSubscriptionEndDate(String subscriptionEndDate) {
		this.subscriptionEndDate = subscriptionEndDate;
	}

	@Override
	public String toString() {
		return "[" + this.clientId + " , " + this.subscriptionType + "]";
	}

}
