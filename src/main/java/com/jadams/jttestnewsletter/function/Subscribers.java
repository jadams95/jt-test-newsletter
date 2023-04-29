package com.jaddy.newsletterex.function;

import com.jaddy.newsletterex.domain.Subscriber;
import com.jaddy.newsletterex.service.SubscriberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Configuration
public class Subscribers {

    private final SubscriberService subscribers;
    public Subscribers(SubscriberService subscribers) {
        this.subscribers = subscribers;
    }

    @Bean
    public Supplier<List<Subscriber>> findAll(){
        return () -> subscribers.findAll();
    }
    @Bean
    public Consumer<String> create(){
        return (email) -> subscribers.create(email);
    }
}
