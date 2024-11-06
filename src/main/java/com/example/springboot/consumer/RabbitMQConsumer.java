package com.example.springboot.consumer;

import com.example.springboot.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consume(String message) {
        LOGGER.info("String message is received -> {}", message);
    }

    @RabbitListener(queues = "${rabbitmq.queue.json.name}")
    public void consumeJson(User user){
        LOGGER.info("Json message is received -> {}", user.toString());
    }
}
