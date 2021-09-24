package com.gorkem.kafkaservice.service;

import com.gorkem.kafkaservice.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaService {

    private String[] topicNames = {"sync-one-topic-one-partition", "sync-one-topic-four-partition", "sync-one-topic-three-partition"};
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Async
    public void writeToKafkaStream(User user) {
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 750; i++) {
            kafkaTemplate.send(topicNames[2], user.toString());
        }
        long stop = System.currentTimeMillis();
        log.info("THREAD NAME : {} TIME TAKEN FOR 750 MESSAGES IN KAFKA : {} MILLISECONDS", Thread.currentThread().getName(), stop - start);
    }
}
