package com.sd.sls.notification.status;
/*
 * @Author: Ranatosh Sarkar
 */
public enum NotificationStatus {
	SENT("S"),
	READ("R");
	
	private final String status;

	NotificationStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
