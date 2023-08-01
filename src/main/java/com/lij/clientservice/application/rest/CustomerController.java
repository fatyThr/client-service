package com.lij.clientservice.application.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api( "API for Custmer")
@RequiredArgsConstructor
@RestController
public class CustomerController {

    @ApiOperation(value = "get all Customers")
    @GetMapping("/Customers")
    public void getCustomers() {
        System.out.println("hi Custmer!");
    }
}
