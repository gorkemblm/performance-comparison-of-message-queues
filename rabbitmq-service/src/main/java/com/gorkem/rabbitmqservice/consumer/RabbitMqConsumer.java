package com.gorkem.rabbitmqservice.consumer;

import com.gorkem.rabbitmqservice.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMqConsumer {
    public static long count = 1;

    @Async
    @RabbitListener(queues = "sampleQueue", autoStartup = "true")
    public void recievedMessage(User user) {
        try {
            log.info("GENERAL COUNT : {} RECEIVER THREAD : {} Received Message From Queue : {}", count, Thread.currentThread().getName(), user);
            count++;
        } catch (Exception e) {
            log.error("ERROR : {}", e.getMessage());
        }
    }
}
