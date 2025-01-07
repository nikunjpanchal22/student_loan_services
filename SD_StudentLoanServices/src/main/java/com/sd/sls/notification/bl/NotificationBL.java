package com.sd.sls.notification.bl;
/*
 * @Author: Ranatosh Sarkar
 */
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.sls.applicant.dao.ApplicantDAO;
import com.sd.sls.applicant.model.Applicant;
import com.sd.sls.notification.dao.INotificationDAO;
import com.sd.sls.notification.model.Notification;
import com.sd.sls.notification.status.NotificationStatus;
import com.sd.sls.user.dao.IUserDAO;

@Service
public class NotificationBL implements INotificationBL{
	
	@Autowired
	private INotificationDAO notificationDAO;
	
	@Autowired
	private IUserDAO userDao;
	
	@Autowired
	private ApplicantDAO applicantDAO;

	@Override
	public void update(Map<String, Object> values) {
		Notification notification = createNotification(values);
		notificationDAO.update(notification);
	}

	private Notification createNotification(Map<String, Object> values)
	{
		Notification notification = new Notification();
		notification.setUser(userDao.findUserByEmail(Objects.toString(values.get("email"))));
		notification.setMessage("Applicant Registered with Name :" + values.get("firstName") + " " + values.get("lastName"));
		notification.setTimeStamp(new Date(new java.util.Date().getTime()));
		notification.setNotificationStatus(NotificationStatus.SENT.getStatus());
		notification.setSenderId(((Applicant) applicantDAO.getApplicantDetailsByNameFromDraft(Objects.toString(values.get("firstName")), Objects.toString(values.get("lastName")))).getApplicantId());
		notification.setSenderType("A");
		return notification;
	}

	@Override
	public List<Notification> checkNotifications() {
		List<Notification> notificationList =  notificationDAO.checkNotifications();
		for (Notification notification : notificationList)
		{
			notification.setUser(userDao.findUserForNotification(notification.getMessage()));
		}
		return notificationList;
	}
}
