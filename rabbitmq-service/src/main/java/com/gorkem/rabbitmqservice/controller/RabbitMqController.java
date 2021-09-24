package com.gorkem.rabbitmqservice.controller;

import com.gorkem.rabbitmqservice.model.User;
import com.gorkem.rabbitmqservice.service.RabbitMqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/v1/rabbitmq")
public class RabbitMqController {

    private final RabbitMqService rabbitMqService;

    public RabbitMqController(RabbitMqService rabbitMqService) {
        this.rabbitMqService = rabbitMqService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add-to-line")
    public void addToQueue(@RequestBody User user) {
        long start = System.currentTimeMillis();
        for (int i = 0 ; i < 8 ; i++) {
            this.rabbitMqService.addToQueue(user);
        }
        long stop = System.currentTimeMillis();
        log.info("TOTAL TIME OF WRITE MESSAGES TO QUEUE : {} MILLISECONDS", stop - start);
    }
}
