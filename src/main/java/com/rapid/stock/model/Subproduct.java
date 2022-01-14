package com.rapid.stock.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Data
@AllArgsConstructor
public class Subproduct {

    private int id;
    private String name;
    private Double price;
    @DocumentReference
    private SubProductType subProductType;
}
