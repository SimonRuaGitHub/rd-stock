package com.rapid.stock.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class ProductVersion {

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
    private List<Subproduct> subProducts;
}
