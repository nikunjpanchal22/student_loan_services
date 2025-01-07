package com.sd.sls.notification.dao;
/*
 * @Author: Ranatosh Sarkar
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sd.sls.constants.ISQLStatements;
import com.sd.sls.notification.model.Notification;

@Repository
public class NotificationDAO implements INotificationDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void update(Notification notification) {
		jdbcTemplate.update(ISQLStatements.SEND_NOTIFICATION, new Object[] {notification.getUser().getUserId(), notification.getMessage(), notification.getTimeStamp(), notification.getNotificationStatus(), notification.getSenderId(), notification.getSenderType()});
	}
	
	@Override
	public List<Notification> checkNotifications() {
		List<Notification> notificationList = jdbcTemplate.query(ISQLStatements.READ_NOTIFICATION, new BeanPropertyRowMapper<>(Notification.class));
		return notificationList;
	}
}
