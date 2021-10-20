package com.psr.rm.mensageria;

import com.psr.rm.dto.ClientDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
public class ClientListener {

    @Bean
    public Consumer<ClientDTO> clientEmailConsumer(){
        return  clientDTO -> log.info("M=clientEmailConsumer, clientDTO={}", clientDTO);
    }

    @Bean
    public Consumer<ClientDTO> clientSMSConsumer(){
        return  clientDTO -> log.info("M=clientSMSConsumer, clientDTO={}", clientDTO);
    }
}
