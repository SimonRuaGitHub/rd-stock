package com.rapid.stock.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class ParentProduct{

    @Id
    private String id;
    @Indexed(unique = true)
    private String productId;
    private String productName;
    private String productDescription;
    private LocalDateTime createdAt;
    private List<ProductVersion> productVersions;

    @Builder
    public ParentProduct(String productId, String productName, String productDescription, LocalDateTime createdAt, List<ProductVersion> productVersions) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.createdAt = createdAt;
        this.productVersions = productVersions;
    }
}
