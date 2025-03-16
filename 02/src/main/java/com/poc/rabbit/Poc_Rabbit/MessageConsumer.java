package com.poc.rabbit.Poc_Rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class MessageConsumer {

    private static final Logger log = LoggerFactory.getLogger(MessageConsumer.class);

    private final RabbitTemplate rabbitTemplate;

    public MessageConsumer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Bean
    public Consumer<String> processMessage() {

        return message -> {
            log.info("Recebido={} ", message);

            if (message.contains("ERRO_NEGOCIO")) {
                throw new BusinessException("Falha de negócio identificada!");
            } else {
                throw new RuntimeException("Falha genérica, vai para retry.");
            }
        };
    }

}
