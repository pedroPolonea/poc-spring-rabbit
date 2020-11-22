package com.php.rm.resources;


import com.php.rm.dto.ProductDTO;
import com.php.rm.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@Api(
        tags = "products",
        value="/v1"
)
@RestController
@RequestMapping(value = "products", produces = MediaType.APPLICATION_JSON_VALUE, headers ="version=V1" )
public class ProductResources {

    @Autowired
    private ProductService productService;

    @ApiOperation(
            value = "Get all products.",
            response = ProductDTO.class)
    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.publish(productDTO), HttpStatus.OK);
    }
}
