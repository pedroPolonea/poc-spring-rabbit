package com.poc.rabbit.Poc_Rabbit;

import org.springframework.stereotype.Component;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.MessageChannel;

import java.util.Map;

@Component
public class DebugChannels {

    public DebugChannels(ApplicationContext applicationContext) {
        Map<String, MessageChannel> channels = applicationContext.getBeansOfType(MessageChannel.class);
        System.out.println("📌 Canais disponíveis no contexto do Spring:");
        channels.forEach((name, channel) -> System.out.println("➡️ " + name));
    }
}
