package com.gorkem.kafkaservice.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {
    public static long generalCount = 1;
    public static long consumerOneCount = 1;
    public static long consumerTwoCount = 1;
    public static long consumerThreeCount = 1;
    public static long consumerFourCount = 1;

    //1 TOPIC 1 PARTITION 1 CONSUMER SCENARIO -> {1 TO 1 CONNECTION}
    /*@KafkaListener(autoStartup = "true", topics = "sync-one-topic-one-partition", groupId = "scenario-1")
    public void recievedMessage(String message) {
        try {
            log.info("GENERAL COUNT : {} CONSUMER NAME : {} RECEIVED MESSAGE FROM STREAM : {}", generalCount, "C1", message);
            generalCount++;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }*/

    //1 TOPIC 4 PARTITION 4 CONSUMER SCENARIO -> {1 TO 1 CONNECTION}
    /*@KafkaListener(autoStartup = "true", topics = "sync-one-topic-four-partition", groupId = "scenario-2")
    public void recievedMessageFromMultiplePartitionListener1(String message) {
        try {
            log.info("GENERAL COUNT : {} PERSONAL COUNT : {} CONSUMER NAME : {} RECEIVED MESSAGE FROM STREAM : {}", generalCount, consumerOneCount, "C1", message);
            consumerOneCount++;
            generalCount++;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @KafkaListener(autoStartup = "true", topics = "sync-one-topic-four-partition", groupId = "scenario-2")
    public void recievedMessageFromMultiplePartitionListener2(String message) {
        try {
            log.info("GENERAL COUNT : {} PERSONAL COUNT : {} CONSUMER NAME : {} RECEIVED MESSAGE FROM STREAM : {}", generalCount, consumerTwoCount, "C2", message);
            consumerTwoCount++;
            generalCount++;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @KafkaListener(autoStartup = "true", topics = "sync-one-topic-four-partition", groupId = "scenario-2")
    public void recievedMessageFromMultiplePartitionListener3(String message) {
        try {
            log.info("GENERAL COUNT : {} PERSONAL COUNT : {} CONSUMER NAME : {} RECEIVED MESSAGE FROM STREAM : {}", generalCount, consumerThreeCount, "C3", message);
            consumerThreeCount++;
            generalCount++;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @KafkaListener(autoStartup = "true", topics = "sync-one-topic-four-partition", groupId = "scenario-2")
    public void recievedMessageFromMultiplePartitionListener4(String message) {
        try {
            log.info("GENERAL COUNT : {} PERSONAL COUNT : {} CONSUMER NAME : {} RECEIVED MESSAGE FROM STREAM : {}"", generalCount, consumerFourCount, "C4", message);
            consumerFourCount++;
            generalCount++;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }*/

    //SYNC 1 TOPIC 3 PARTITION 3 CONSUMER SCENARIO -> {1 TO 1 CONNECTION}
    @KafkaListener(autoStartup = "true", topics = "sync-one-topic-three-partition", groupId = "scenario-3")
    public void recievedMessageFromMultiplePartitionListener1(String message) {
        try {
            log.info("GENERAL COUNT : {} PERSONAL COUNT : {} CONSUMER NAME : {} RECEIVED MESSAGE FROM STREAM : {}", generalCount, consumerOneCount, "C1", message);
            consumerOneCount++;
            generalCount++;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @KafkaListener(autoStartup = "true", topics = "sync-one-topic-three-partition", groupId = "scenario-3")
    public void recievedMessageFromMultiplePartitionListener2(String message) {
        try {
            log.info("GENERAL COUNT : {} PERSONAL COUNT : {} CONSUMER NAME : {} RECEIVED MESSAGE FROM STREAM : {}", generalCount, consumerTwoCount, "C2", message);
            consumerTwoCount++;
            generalCount++;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @KafkaListener(autoStartup = "true", topics = "sync-one-topic-three-partition", groupId = "scenario-3")
    public void recievedMessageFromMultiplePartitionListener3(String message) {
        try {
            log.info("GENERAL COUNT : {} PERSONAL COUNT : {} CONSUMER NAME : {} RECEIVED MESSAGE FROM STREAM : {}", generalCount, consumerThreeCount, "C3", message);
            consumerThreeCount++;
            generalCount++;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
