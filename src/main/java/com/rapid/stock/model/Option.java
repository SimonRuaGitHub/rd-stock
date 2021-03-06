package com.rapid.stock.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Option {

    private int id;
    private String name;
    private Double price;
}
