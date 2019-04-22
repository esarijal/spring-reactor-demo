package com.erm.spring.reactordemo.service;

import com.erm.spring.reactordemo.model.NotificationData;

public interface NotificationService {
    void initiateNotification(NotificationData notificationData)
        throws InterruptedException;
}
