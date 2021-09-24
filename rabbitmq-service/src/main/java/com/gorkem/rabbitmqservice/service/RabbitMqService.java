package com.gorkem.rabbitmqservice.service;

import com.gorkem.rabbitmqservice.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMqService {

    private final DirectExchange exchange;

    @Value("sample.routingKey")
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
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 750; i++) {
            template.convertAndSend(exchange.getName(), user);
        }
        long stop = System.currentTimeMillis();
        log.info("THREAD NAME : {} TIME TAKEN FOR 750 MESSAGES IN RABBITMQ : {} MILLISECONDS", Thread.currentThread().getName(), stop - start);
    }
}
