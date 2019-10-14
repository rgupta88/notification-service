package com.tsystem.models;

public enum Subscription {
	SILVER(10), GOLD(100), PLATINUM(Integer.MAX_VALUE);
	private Integer limit;

	public Integer getLimit() {
		return limit;
	}

	private Subscription(Integer limit) {
		this.limit = limit;

	}
}
