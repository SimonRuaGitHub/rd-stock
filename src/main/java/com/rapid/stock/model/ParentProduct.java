package com.rapid.stock.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class ParentProduct {

    @Id
    private String id;
    @Indexed(unique = true)
    private String productId;
    private String productName;
    private String productDescription;
    private LocalDateTime createdAt;
    @DocumentReference
    private List<ProductVersion> productVersions;

}
