package com.erm.spring.reactordemo.service;

import com.erm.spring.reactordemo.model.NotificationData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.bus.Event;
import reactor.fn.Consumer;


@Service
public class NotificationConsumer implements Consumer<Event<NotificationData>> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private final NotificationService notificationService;

    public NotificationConsumer(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void accept(Event<NotificationData> notificationDataEvent) {
        NotificationData data = notificationDataEvent.getData();

        try{
            notificationService.initiateNotification(data);
        } catch (InterruptedException e) {
            logger.info(e.getMessage());
        }
    }
}
