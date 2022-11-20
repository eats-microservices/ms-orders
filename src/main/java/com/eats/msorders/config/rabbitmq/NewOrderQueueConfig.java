package com.eats.msorders.config.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NewOrderQueueConfig {

    /* New order queue */
    @Bean
    public Queue newOrderQueue() {
        return QueueBuilder
                .nonDurable("orders.new-order-event")
                .build();
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return ExchangeBuilder
                .fanoutExchange("orders.ex")
                .build();
    }

    @Bean
    public Binding bindQueueIntoExchange(FanoutExchange fanoutExchange) {
        return BindingBuilder
                .bind(newOrderQueue())
                .to(fanoutExchange());
    }

    /* Payment done queue */
    @Bean
    public Queue paymentDoneQueue() {
        return QueueBuilder
                .nonDurable("payments.payment-done")
                .build();
    }
}
