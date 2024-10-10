package com.kafkaEx.stock.kafka;

import com.kafkaEx.domain.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class OrderConsumer {

    public static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);




    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void receive(OrderEvent event) {
        try {
            LOGGER.info("Order received in stock => {}", event);
        } catch (Exception e) {
            LOGGER.error("Error consuming message: ", e);
        }
    }
}
