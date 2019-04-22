package com.erm.spring.reactordemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.Environment;
import reactor.bus.EventBus;

@Configuration
public class AppConfig {
    @Bean
    public Environment env(){
        return Environment.initializeIfEmpty().assignErrorJournal();
    }

    @Bean
    public EventBus createEventBus(Environment environment){
        return EventBus.create(environment, Environment.THREAD_POOL);
    }
}
