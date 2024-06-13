package com.ddd.learn.domain.shared.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventDispatcher implements EventDispatcherInterface {

    private Map<String, List<EventHandlerInterface>> eventHandlers = new HashMap<>();

    @Override
    public void notify(EventAbstract event) {

        String eventName = event.getClass().getName();

        if(this.eventHandlers.containsKey(eventName)){
            this.eventHandlers.get(eventName).forEach(handler -> handler.handle(event));
        }

    }

    @Override
    public void register(String eventName, EventHandlerInterface eventHandler) {
        this.eventHandlers.computeIfAbsent(eventName, k -> new ArrayList<>()).add(eventHandler);
    }

    @Override
    public void unregister(String eventName, EventHandlerInterface eventHandler) {
        if(this.eventHandlers.containsKey(eventName)){
            List<EventHandlerInterface> handlers = this.eventHandlers.get(eventName);
            handlers.remove(eventHandler);
        }
    }

    @Override
    public void unregisterAll() {
        this.eventHandlers.clear();
    }

    public List<EventHandlerInterface> eventHandler(String eventName){
        return eventHandlers.get(eventName);
    }
}
