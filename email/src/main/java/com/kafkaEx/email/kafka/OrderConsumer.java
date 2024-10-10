package com.kafkaEx.email.kafka;

import com.kafkaEx.domain.dto.OrderEvent;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.logging.Logger;

@KafkaListener(topics ="${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
public class OrderConsumer {
    public static final Logger LOGGER = (Logger) LoggerFactory.getLogger(OrderConsumer.class);

    public void relived(OrderEvent event){
        LOGGER.info(String.format("oerder recverd in stock =>", event.toString()));

    }

}
