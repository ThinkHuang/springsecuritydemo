package com.huang.security.handler;

import org.springframework.stereotype.Service;

import reactor.bus.Event;
import reactor.fn.Consumer;

@Service
public class Receiver implements Consumer<Event<Integer>>
{

    @Override
    public void accept(Event<Integer> ev)
    {
        System.out.println("Process number:" + ev.getData());
    }
    
}
