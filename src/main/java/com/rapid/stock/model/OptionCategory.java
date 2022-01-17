package com.rapid.stock.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document
@Data
public class OptionCategory {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    @Field(name = "description")
    private String descrip;
    private List<Option> options;

    public OptionCategory(String id, String name, String descrip, List<Option> options) {
        this.id = id;
        this.name = name;
        this.descrip = descrip;
        this.options = options;
    }
}
