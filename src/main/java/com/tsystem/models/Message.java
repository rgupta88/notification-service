package com.tsystem.models;

import org.springframework.stereotype.Component;

@Component
public class Message {
	
	String payLoad;

	public String getPayLoad() {
		return payLoad;
	}

	public void setPayLoad(String payLoad) {
		this.payLoad = payLoad;
	}

}
