package com.rapid.stock.dto;

import com.rapid.stock.model.ProductType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductVersionSaveRequest {
    private String name;
    private String description;
    private ProductType productType;
    private Double price;
    private Integer quantityAvailable;
    private boolean isAvailable;
}
