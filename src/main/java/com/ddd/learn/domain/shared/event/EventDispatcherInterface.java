package com.ddd.learn.domain.shared.event;

public interface EventDispatcherInterface {
    void notify(EventAbstract event);
    void register(String eventName, EventHandlerInterface eventHandler);
    void unregister(String eventName,EventHandlerInterface eventHandler);
    void unregisterAll();
}
