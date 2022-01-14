package com.rapid.stock.service;


import com.rapid.stock.exception.SaveException;
import com.rapid.stock.model.ParentProduct;
import com.rapid.stock.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImp implements ProductService {

    private ProductRepository productRepository;

    @Override
    public void save(ParentProduct parentProduct) throws SaveException {
           productRepository.insert(parentProduct);
    }
}
