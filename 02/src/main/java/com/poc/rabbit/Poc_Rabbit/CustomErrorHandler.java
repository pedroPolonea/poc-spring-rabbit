package com.poc.rabbit.Poc_Rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.stereotype.Component;

@Component
public class CustomErrorHandler {
    private static final Logger log = LoggerFactory.getLogger(CustomErrorHandler.class);

    @ServiceActivator(inputChannel = "errorChannel") // Canal de erros do binding
    public void handleError(Message<?> errorMessage) throws Throwable {
        Throwable exception = ((ErrorMessage) errorMessage).getPayload();

        if (exception.getCause() instanceof BusinessException) {
            log.error("Erro de negócio detectado. Enviando diretamente para DLQ={} ", exception.getCause().getMessage());
            throw exception.getCause(); // Envia para DLQ imediatamente
        }

        log.warn("Erro normal, será retentado= {}", exception.getCause().getMessage());
    }
}
