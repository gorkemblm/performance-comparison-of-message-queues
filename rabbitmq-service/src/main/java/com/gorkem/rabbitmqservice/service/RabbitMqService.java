package com.gorkem.rabbitmqservice.service;

import com.gorkem.rabbitmqservice.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqService {

    private final DirectExchange exchange;

    @Value("sampleRoutingKey")
    String routingKey;

    @Value("sampleQueue")
    String queueName;

    private final AmqpTemplate template;

    public RabbitMqService(DirectExchange exchange, AmqpTemplate template) {
        this.exchange = exchange;
        this.template = template;
    }

    @Async
    public void addToQueue(User user) {
        for (int i = 1; i <= 750; i++) {
            template.convertAndSend(exchange.getName(), user);
        }
    }
}
