package com.tsystem.dto;

public class NotificationResponseDto {

	public String msg;
	public Status status;
	public Boolean validSubscription;

	public Boolean getValidSubscription() {
		return validSubscription;
	}

	public void setValidSubscription(Boolean validSubscription) {
		this.validSubscription = validSubscription;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public enum Status {
		SUCCESS, FAILED;
	}

}
