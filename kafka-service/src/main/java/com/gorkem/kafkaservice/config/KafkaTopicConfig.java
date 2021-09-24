package com.gorkem.kafkaservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    //SCENARIO 2 -> SYNC 1 TOPIC 4 PARTITION 4 CONSUMER CONFIG
    /*@Bean
    public NewTopic topicOfScenario() {
        return TopicBuilder.name("sync-one-topic-four-partition")
                .partitions(4)
                .config(TopicConfig.COMPRESSION_TYPE_CONFIG, "zstd")
                .build();
    }*/

    //SCENARIO 3 -> SYNC 1 TOPIC 3 PARTITION 3 CONSUMER CONFIGS
    @Bean
    public NewTopic syncOneTopicThreePartition() {
        return TopicBuilder.name("sync-one-topic-three-partition")
                .partitions(3)
                .config(TopicConfig.COMPRESSION_TYPE_CONFIG, "zstd")
                .build();
    }
}
