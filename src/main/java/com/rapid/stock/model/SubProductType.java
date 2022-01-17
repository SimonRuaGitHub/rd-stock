package com.rapid.stock.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document
@Data
public class SubProductType{
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    @Field(name = "description")
    private String descrip;
    private List<Subproduct> subproducts;

    public SubProductType(String id, String name, String descrip, List<Subproduct> subproducts) {
        this.id = id;
        this.name = name;
        this.descrip = descrip;
        this.subproducts = subproducts;
    }
}
