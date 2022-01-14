package com.rapid.stock.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document
@Data
public class SubProductType {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    @Field(name = "description")
    private String descrip;
    private List<Integer> subProductIds;
}