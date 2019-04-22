package com.erm.spring.reactordemo;

import com.erm.spring.reactordemo.service.NotificationConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.bus.EventBus;

import static reactor.bus.selector.Selectors.$;

@SpringBootApplication
public class ReactorDemoApp implements CommandLineRunner {

    @Autowired
    private EventBus eventBus;
    @Autowired
    private NotificationConsumer notificationConsumer;

    public static void main(String[] args){
        SpringApplication.run(ReactorDemoApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        eventBus.on($("notificationConsumer"), notificationConsumer);
    }
}
