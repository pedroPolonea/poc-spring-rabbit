package com.php.rm.service.impl;


import com.php.rm.dto.ProductDTO;
import com.php.rm.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {


    @Override
    public ProductDTO publish(ProductDTO productDTO) {
        log.info("M=publish, I=Begin, productDTO={}", productDTO);

        return null;
    }
}
