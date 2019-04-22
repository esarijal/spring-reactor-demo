package com.erm.spring.reactordemo.controller;

import com.erm.spring.reactordemo.model.NotificationData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.bus.Event;
import reactor.bus.EventBus;

@Controller
public class NotificationController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private final EventBus eventBus;

    public NotificationController(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @GetMapping("/startNotification/{param}")
    public void startNotification(@PathVariable Integer param){
        for(int i=0; i<param; i++){
            NotificationData data = new NotificationData();
            data.setId(i);

            eventBus.notify("notificationConsumer", Event.wrap(data));

            logger.info("Notification {} submitted successfully", i);
        }
    }
}
