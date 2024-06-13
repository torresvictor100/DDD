package com.ddd.learn.domain.shared.customer.handle;

import com.ddd.learn.domain.shared.customer.CustomerCreatedEvent;
import com.ddd.learn.domain.shared.event.EventHandlerInterface;

public class SendEmailWhenCustomerIsCreatedHandler implements EventHandlerInterface<CustomerCreatedEvent> {
    @Override
    public void handle(CustomerCreatedEvent event) {
        System.out.println(event.getDateTimeOccurred() +" Customer Create Sending email to .......");
    }
}
