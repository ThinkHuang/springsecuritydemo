package com.huang.security.web.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.bus.Event;
import reactor.bus.EventBus;

@RestController
public class Publisher
{
    
    @Resource
    private EventBus eventBus;
    
    @RequestMapping("reactor/demo")
    @ResponseBody
    public void publish() throws InterruptedException {
 
        for (int i = 0; i < 10; i++) {
            eventBus.notify("number", Event.wrap(i));
        }
    }
}
