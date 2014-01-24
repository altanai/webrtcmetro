package com.tcs.dao;

import java.util.ArrayList;

import com.tcs.bean.Notification;

public interface NotificationDao_interface {
	public ArrayList<Notification> getNotificationData(String userId);
	public boolean updateNotificationStatus(String userId);
	
}
