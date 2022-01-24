package com.rapid.stock.service;

import com.rapid.stock.dto.ParentProductSaveRequest;
import com.rapid.stock.exception.SaveException;
import com.rapid.stock.mapper.ParentProductMapper;
import com.rapid.stock.model.ParentProduct;
import com.rapid.stock.repository.ParentProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImp implements ProductService {

    private final ParentProductRepository productRepository;
    private final ParentProductMapper parentProductMapper;

    @Override
    public void save(ParentProductSaveRequest parentProductDto) throws SaveException {
           ParentProduct parentProduct = parentProductMapper.mapSaveRequest(parentProductDto);
           productRepository.insert(parentProduct);
    }
}
