package com.ddd.learn.domain.product.event.handle;

import com.ddd.learn.domain.shared.event.EventHandlerInterface;
import com.ddd.learn.domain.product.event.ProductCreatedEvent;

public class SendEmailWhenProductIsCreatedHandler implements EventHandlerInterface<ProductCreatedEvent> {
    @Override
    public void handle(ProductCreatedEvent event) {
        System.out.println(event.getDateTimeOccurred() +" Product Create Sending email to .......");
    }
}
