package com.gorkem.kafkaservice.service;

import com.gorkem.kafkaservice.model.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    private String[] topicNames = {"sync-one-topic-one-partition", "sync-one-topic-four-partition", "sync-one-topic-three-partition"};
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Async
    public void writeToKafkaStream(User user) {
        for (int i = 0 ; i < 750 ; i++) {
            kafkaTemplate.send(topicNames[2], user.toString());
        }
    }
}
