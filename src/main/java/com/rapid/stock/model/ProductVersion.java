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
public class ProductVersion{

    @Id
    private String id;
    @Indexed(unique = true)
    private String versionId;
    private String name;
    private String description;
    private ProductType productType;
    private Double price;
    private Integer quantityAvailable;
    private boolean isAvailable;
    private LocalDateTime createdAt;
    @DocumentReference
    private List<OptionCategory> optionCategories;

    public ProductVersion(String id, String versionId, String name, String description, ProductType productType, Double price, Integer quantityAvailable, boolean isAvailable, LocalDateTime createdAt, List<OptionCategory> optionCategories) {
        this.id = id;
        this.versionId = versionId;
        this.name = name;
        this.description = description;
        this.productType = productType;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
        this.isAvailable = isAvailable;
        this.createdAt = createdAt;
        this.optionCategories = optionCategories;
    }
}
