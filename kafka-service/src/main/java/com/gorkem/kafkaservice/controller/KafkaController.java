package com.gorkem.kafkaservice.controller;

import com.gorkem.kafkaservice.model.User;
import com.gorkem.kafkaservice.service.KafkaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/kafka")
public class KafkaController {

    private final KafkaService kafkaService;

    public KafkaController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add-to-line")
    public void addToStream(@RequestBody User user) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 8; i++) {
            this.kafkaService.writeToKafkaStream(user);
        }
        long stop = System.currentTimeMillis();
        log.info("TOTAL TIME OF WRITE MESSAGES TO STREAM : {} MILLISECONDS", stop - start);
    }
}
