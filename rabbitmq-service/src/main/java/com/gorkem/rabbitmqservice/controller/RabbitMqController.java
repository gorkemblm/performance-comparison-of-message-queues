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

    @RequestMapping(method = RequestMethod.POST, path = "/add-to-queue")
    public void addToQueue(@RequestBody User user) {
        for (int i = 0 ; i < 8 ; i++) {
            log.info(Thread.currentThread().getName());
            this.rabbitMqService.addToQueue(user);
        }
    }
}
