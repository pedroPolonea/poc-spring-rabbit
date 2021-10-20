package com.psr.rm.mensageria;

import com.psr.rm.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
public class ProductListener {
    @Bean
    public Consumer<ProductDTO> productConsumer(){
        return  productDTO -> log.info("M=productConsumer, productDTO={}", productDTO);
    }
}
