package com.tsystem.models;

import org.springframework.stereotype.Component;

@Component
public class Recipient {

	String userId;

	String emailAddress;

	String phoneNumber;
	String pushId;
	
	public Recipient(){
		
	}

	public Recipient(String userId, String emailAddress, String phoneNumber, String pushId) {
		this.emailAddress = emailAddress;
		this.pushId = pushId;
		this.userId = userId;
		this.phoneNumber = phoneNumber;

	}

	public Recipient(String userId) {
		this.userId = userId;
	}

	public String getPushId() {
		return pushId;
	}

	public void setPushId(String pushId) {
		this.pushId = pushId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
