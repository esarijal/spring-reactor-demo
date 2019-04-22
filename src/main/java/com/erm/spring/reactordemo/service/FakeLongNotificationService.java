package com.erm.spring.reactordemo.service;

import com.erm.spring.reactordemo.model.NotificationData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FakeLongNotificationService implements NotificationService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    public void initiateNotification(NotificationData data) throws InterruptedException {
        logger.info("Notification service STARTED for Notification ID: {}",
                data.getId());

        Thread.sleep(7000);

        logger.info("Notification service ENDED for Notification ID: {}", data.getId());
    }
}
