package com.huang.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import reactor.Environment;
import reactor.bus.EventBus;

@Component
public class MyBeans
{
    
    @Bean
    Environment env()
    {
        return Environment.initializeIfEmpty().assignErrorJournal();
    }
    
    @Bean
    EventBus createEventBus(Environment env)
    {
        return EventBus.create(env, Environment.THREAD_POOL);
    }
}
