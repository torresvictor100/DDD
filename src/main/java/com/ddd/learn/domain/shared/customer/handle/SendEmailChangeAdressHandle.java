package com.ddd.learn.domain.shared.customer.handle;

import com.ddd.learn.domain.shared.customer.AdressChangeEvent;
import com.ddd.learn.domain.shared.event.EventHandlerInterface;

public class SendEmailChangeAdressHandle implements EventHandlerInterface<AdressChangeEvent> {
    @Override
    public void handle(AdressChangeEvent event) {
        System.out.println("Endeço do cliente"+ event.getIdCustomer() +","
                +event.getNameCustome() + "alterado para :" + event.getEndereco());
    }
}
