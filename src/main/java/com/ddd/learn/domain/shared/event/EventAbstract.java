package com.ddd.learn.domain.shared.event;

import java.time.LocalDateTime;

public abstract class EventAbstract<T> {
    protected LocalDateTime dateTimeOccurred;
    protected T eventData;

    public EventAbstract(LocalDateTime dateTimeOccurred, T eventData) {
        this.dateTimeOccurred = dateTimeOccurred;
        this.eventData = eventData;
    }

    public LocalDateTime getDateTimeOccurred() {
        return dateTimeOccurred;
    }
}
