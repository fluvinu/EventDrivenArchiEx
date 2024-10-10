package com.kafkaEx.order.kafka;

import com.kafkaEx.domain.dto.OrderEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderProduser {
    private final NewTopic topic ;

    private static final Logger LOGGER= LoggerFactory.getLogger(OrderProduser.class);

    private final KafkaTemplate<String,OrderEvent> kafkaTemplate;

    public OrderProduser(NewTopic topic, KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(OrderEvent event){
        Message<OrderEvent> message= MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC,topic.name()).build();
        kafkaTemplate.send(message);

        LOGGER.info("order event -==> {}", event.toString());
    }


}
