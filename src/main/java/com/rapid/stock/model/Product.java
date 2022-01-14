package com.rapid.stock.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Product {

    @Id
    private String id;
    @Indexed(unique = true)
    private String productId;
    private String productName;
    private String productDescription;
    private Double price;
    private Integer quantityAvailable;
    private ProductType productType;
    private boolean isAvailable;
    private LocalDateTime createdAt;
    private List<Subproduct> subProducts;

    public Product(String productId, String productName, String productDescription, Double price, Integer quantityAvailable, ProductType productType, boolean isAvailable, LocalDateTime createdAt, List<Subproduct> subProducts) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
        this.productType = productType;
        this.isAvailable = isAvailable;
        this.createdAt = createdAt;
        this.subProducts = subProducts;
    }
}
