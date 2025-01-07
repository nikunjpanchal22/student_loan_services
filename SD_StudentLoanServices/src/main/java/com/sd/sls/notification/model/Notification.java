package com.sd.sls.notification.model;
/*
 * @Author: Ranatosh Sarkar
 */
import java.io.Serializable;
import java.sql.Date;

import com.sd.sls.user.model.User;

public class Notification implements Serializable
{
	private Long notificationId;
	
	private User user;
	
	private String message;
	
	private Date timeStamp;
	
	private String notificationStatus;
	
	private Object senderId;
	
	private String senderType;
	
	public Notification() {
		// TODO Auto-generated constructor stub
	}

	public Notification(Long notificationId, User user, String message, Date timeStamp, String notificationStatus,
			Object senderId, String senderType) {
		super();
		this.notificationId = notificationId;
		this.user = user;
		this.message = message;
		this.timeStamp = timeStamp;
		this.notificationStatus = notificationStatus;
		this.senderId = senderId;
		this.senderType = senderType;
	}

	public Long getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getNotificationStatus() {
		return notificationStatus;
	}

	public void setNotificationStatus(String notificationStatus) {
		this.notificationStatus = notificationStatus;
	}

	public Object getSenderId() {
		return senderId;
	}

	public void setSenderId(Object senderId) {
		this.senderId = senderId;
	}

	public String getSenderType() {
		return senderType;
	}

	public void setSenderType(String senderType) {
		this.senderType = senderType;
	}

	@Override
	public String toString() {
		return "Notification [notificationId=" + notificationId + ", user=" + user + ", message=" + message
				+ ", timeStamp=" + timeStamp + ", notificationStatus=" + notificationStatus + ", senderId=" + senderId
				+ ", senderType=" + senderType + "]";
	}
}
