package com.rapid.stock.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProductVersion{

    @Id
    private String id;
    @Indexed(unique = true, sparse = true)
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

    @Builder
    public ProductVersion(String versionId, String name, String description, ProductType productType, Double price, Integer quantityAvailable, boolean isAvailable, LocalDateTime createdAt, List<OptionCategory> optionCategories) {
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
