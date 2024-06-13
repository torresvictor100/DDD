package com.ddd.learn.domain.shared.event;

//legal essa parte
public interface EventHandlerInterface<T extends EventAbstract> {
    void handle(T event);
}
