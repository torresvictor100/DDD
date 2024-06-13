package com.ddd.learn.domain.shared.events;

import com.ddd.learn.domain.customer.valueobject.Address;
import com.ddd.learn.domain.product.entity.Product;
import com.ddd.learn.domain.shared.event.EventDispatcher;
import com.ddd.learn.domain.shared.customer.AdressChangeEvent;
import com.ddd.learn.domain.shared.customer.CustomerCreatedEvent;
import com.ddd.learn.domain.shared.customer.handle.SendEmailChangeAdressHandle;
import com.ddd.learn.domain.shared.customer.handle.SendEmailWhenCustomerIsCreatedHandler;
import com.ddd.learn.domain.shared.event.EventHandlerInterface;
import com.ddd.learn.domain.product.event.ProductCreatedEvent;
import com.ddd.learn.domain.product.event.handle.SendEmailWhenProductIsCreatedHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;

@DataJpaTest
@ActiveProfiles("test")
public class EventDispatcherTest {
    @Test
    void EventsTestRegisterProduct() {

        EventDispatcher eventDispatcher = new EventDispatcher();
        SendEmailWhenProductIsCreatedHandler eventHandler = new SendEmailWhenProductIsCreatedHandler();

        eventDispatcher.register("ProductCreatedEvent", eventHandler);

        List<EventHandlerInterface> eventDispatcherRegister =
                eventDispatcher.eventHandler("ProductCreatedEvent");

        Assertions.assertNotNull(eventDispatcherRegister);

        Assertions.assertNotNull(eventDispatcherRegister.get(0));

        Assertions.assertEquals(eventDispatcherRegister.size(), 1);

        Assertions.assertEquals(eventDispatcherRegister.get(0), eventHandler);


    }

    @Test
    void EventsTestUnregisterProduct() {

        EventDispatcher eventDispatcher = new EventDispatcher();
        SendEmailWhenProductIsCreatedHandler eventHandler = new SendEmailWhenProductIsCreatedHandler();

        eventDispatcher.register("ProductCreatedEvent", eventHandler);

        eventDispatcher.unregister("ProductCreatedEvent", eventHandler);

        List<EventHandlerInterface> eventDispatcherFounduUregister
                = eventDispatcher.eventHandler("ProductCreatedEvent");

        Assertions.assertNotNull(eventDispatcherFounduUregister);

        Assertions.assertEquals(eventDispatcherFounduUregister.size(), 0);

    }

    @Test
    void EventsTestNotifyProduct() {

        EventDispatcher eventDispatcher = new EventDispatcher();
        SendEmailWhenProductIsCreatedHandler eventHandler = new SendEmailWhenProductIsCreatedHandler();

        eventDispatcher.register("ProductCreatedEvent", eventHandler);
        eventDispatcher.register("ProductCreatedEvent", eventHandler);
        eventDispatcher.register("ProductCreatedEvent", eventHandler);

        List<EventHandlerInterface> eventDispatcherFound
                = eventDispatcher.eventHandler("ProductCreatedEvent");

        Assertions.assertEquals(eventDispatcherFound.size(), 3);

        Product product = new Product(UUID.randomUUID().toString(),  "product1", 2);

        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent(product);



        eventDispatcher.notify(productCreatedEvent);



    }

    @Test
    public void testNotifyProduct() {
        EventDispatcher dispatcher = new EventDispatcher();
        SendEmailWhenProductIsCreatedHandler handler = mock(SendEmailWhenProductIsCreatedHandler.class);
        ProductCreatedEvent event = mock(ProductCreatedEvent.class);

        String eventName = event.getClass().getName();
        dispatcher.register(eventName, handler);

        dispatcher.notify(event);

        verify(handler, times(1)).handle(event);
    }

    @Test
    public void testNotifyCustomer() {
        EventDispatcher dispatcher = new EventDispatcher();
        SendEmailWhenCustomerIsCreatedHandler handler1 = mock(SendEmailWhenCustomerIsCreatedHandler.class);
        SendEmailWhenCustomerIsCreatedHandler handler2 = mock(SendEmailWhenCustomerIsCreatedHandler.class);
        CustomerCreatedEvent event = mock(CustomerCreatedEvent.class);

        String eventName = event.getClass().getName();
        dispatcher.register(eventName, handler1);
        dispatcher.register(eventName, handler2);

        dispatcher.notify(event);

        verify(handler1, times(1)).handle(event);
        verify(handler2, times(1)).handle(event);
    }

    @Test
    public void testNotifyAdredd() {
        EventDispatcher dispatcher = new EventDispatcher();
        SendEmailChangeAdressHandle handler = mock(SendEmailChangeAdressHandle.class);
        Address address = new Address("Street", 87, "Zip", "City");
        AdressChangeEvent event = new AdressChangeEvent(address, "123", "Customer");

        String eventName = event.getClass().getName();
        dispatcher.register(eventName, handler);

        dispatcher.notify(event);

        verify(handler, times(1)).handle(event);
    }
}

