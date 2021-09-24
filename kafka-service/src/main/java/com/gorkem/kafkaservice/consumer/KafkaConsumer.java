package com.gorkem.kafkaservice.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {
    public static long generalCount = 1;

    //1 TOPIC 1 PARTITION 1 CONSUMER SCENARIO -> {1 TO 1 CONNECTION}
    @KafkaListener(autoStartup = "true", topics = "sync-one-topic-one-partition", groupId = "scenario-1")
    public void recievedMessage(String message) {
        try {
            log.info("General Count : {}. CONSUMER : {}. Received Message From Stream: {}.", generalCount, "C1", message);
            generalCount++;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
