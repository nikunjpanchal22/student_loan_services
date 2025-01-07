package com.sd.sls.notification.bs;
/*
 * @Author: Ranatosh Sarkar
 */
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.sls.notification.bl.NotificationBL;
import com.sd.sls.observer.dp.Observer;

@Service
public class AdminNotificationService implements Observer {
	
	@Autowired
	private NotificationBL notificationBL;

	@Override
	public void update(Map<String, Object> values) {
		notificationBL.update(values);
	}

}
