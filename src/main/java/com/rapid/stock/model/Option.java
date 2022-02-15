package com.rapid.stock.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class Option {

    @Min(value = 0, message = "id can't be equal to 0")
    private int id;
    @NotEmpty(message = "name can't be blank")
    private String name;
    @Min(value = 0, message = "price can't be less or equal to 0")
    private Double price;
}
