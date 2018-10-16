package com.huang.security.init;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.huang.security.handler.Receiver;

import static reactor.bus.selector.Selectors.$;

import reactor.bus.EventBus;

@Component
@Order(1)
public class ReactorLauncher implements CommandLineRunner
{
    @Resource
    private EventBus eventBus;
    
    @Resource
    private Receiver receiver;
    
    @Override
    public void run(String... args) throws Exception
    {
        eventBus.on($("number"), receiver);
    }
    
}
