package com.rapid.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class RestFieldErrors {
    private String field;
    private String message;
}
