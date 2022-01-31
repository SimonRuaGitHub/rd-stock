package com.rapid.stock.service;

import com.rapid.stock.dto.ParentProductSaveRequest;
import com.rapid.stock.exception.SaveException;
import com.rapid.stock.mapper.ParentProductMapper;
import com.rapid.stock.model.ParentProduct;
import com.rapid.stock.repository.ParentProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintDeclarationException;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImp implements ProductService {

    private final ParentProductRepository productRepository;
    private final ParentProductMapper parentProductMapper;
    private final Validator validator;

    @Override
    public void save(ParentProductSaveRequest parentProductDto) throws SaveException {

         ParentProduct parentProduct = parentProductMapper.mapSaveRequest(parentProductDto);

        Set<ConstraintViolation<ParentProduct>> violations = validator.validate(parentProduct);

        if(!violations.isEmpty()) {
            String violationsStr = violations.stream().map(violation -> violation.getMessage()).collect(Collectors.joining("|"));
            throw new SaveException("Some of the fields have invalid have invalid data or no data at all: "+violationsStr);
        }

          try{
               productRepository.insert(parentProduct);
           }catch(Exception ex){
               ex.printStackTrace();
               throw new SaveException("Failed to save following product with id: "+parentProduct.getProductId());
           }
    }
}
