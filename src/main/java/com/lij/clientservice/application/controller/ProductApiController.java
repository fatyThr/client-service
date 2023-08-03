package com.lij.clientservice.application.controller;

import com.lij.clientservice.application.feign.ProductClient;
import com.lij.clientservice.application.model.ProductRepresentation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api( "Client for products api")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class ProductApiController {

    private final ProductClient productClient;

    @ApiOperation(value = "get all Products")
    @GetMapping("/products")
    public ResponseEntity<List<ProductRepresentation>> readProducts () {
        return ResponseEntity.ok(productClient.getProducts());
    }
}
