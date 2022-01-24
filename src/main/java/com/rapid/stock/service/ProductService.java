package com.rapid.stock.service;

import com.rapid.stock.dto.ParentProductSaveRequest;
import com.rapid.stock.exception.SaveException;

public interface ProductService {
    public void save(ParentProductSaveRequest parentProductDto) throws SaveException;
}
