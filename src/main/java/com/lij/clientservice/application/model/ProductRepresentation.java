package com.lij.clientservice.application.model;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class ProductRepresentation {

    private String id;
    private String name;
    private BigDecimal price;
    private BigDecimal purchase;
}
