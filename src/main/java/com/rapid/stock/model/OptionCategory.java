package com.rapid.stock.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Document
@Data
public class OptionCategory {
    @Id
    private String id;
    @NotBlank(message = "name can't  be blank")
    private String name;
    @Field(name = "description")
    @NotBlank
    @NotBlank(message = "description can't  be blank")
    private String descrip;
    @NotBlank
    @NotBlank(message = "label can't  be blank")
    private String label;
    @NotEmpty
    private List<Option> options;

    @Builder
    public OptionCategory(String name, String descrip, String label ,List<Option> options) {
        this.name = name;
        this.descrip = descrip;
        this.label = label;
        this.options = options;
    }
}
