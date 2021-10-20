package com.psr.rm.controller;


import com.psr.rm.dto.ClientDTO;
import com.psr.rm.dto.ProductDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@Slf4j
@Api(
        tags = "rabbit",
        value="/v1"
)
@RestController
@RequestMapping(value = "rabbit", produces = MediaType.APPLICATION_JSON_VALUE, headers ="version=V1" )
public class RabbitController {

    @Autowired
    private StreamBridge streamBridge;

    @ApiOperation(
            value = "Send message to queue",
            response = ProductDTO.class)
    @PostMapping(value = "/product")
    public ResponseEntity<?> sendProduct(@Valid @RequestBody ProductDTO productDTO){
        log.info("M=sendProduct, I=Recebendo payload, productDTO={}", productDTO);
        boolean isSend = streamBridge.send("product", productDTO);

        log.info("M=sendProduct, I=Foi enviado, productDTO={}, isSend={}", productDTO, isSend);
        return new ResponseEntity<>(isSend, HttpStatus.OK);
    }

    @ApiOperation(
            value = "Send message to queue",
            response = ClientDTO.class)
    @PostMapping(value = "/client")
    public ResponseEntity<?> sendClient(@Valid @RequestBody ClientDTO clientDTO){
        log.info("M=sendClient, I=Recebendo payload, clientDTO={}", clientDTO);
        boolean isSend = streamBridge.send("client", clientDTO);

        log.info("M=sendClient, I=Foi enviado, clientDTO={}, isSend={}", clientDTO, isSend);
        return new ResponseEntity<>(isSend, HttpStatus.OK);
    }
}