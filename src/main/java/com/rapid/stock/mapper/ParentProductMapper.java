package com.rapid.stock.mapper;

import com.rapid.stock.dto.ParentProductSaveRequest;
import com.rapid.stock.model.ParentProduct;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ParentProductMapper {

       public ParentProduct mapSaveRequest(ParentProductSaveRequest ppSaveRequest){
              return ParentProduct.builder()
                          .productId(ppSaveRequest.getProductId())
                          .productName(ppSaveRequest.getProductName())
                          .productDescription(ppSaveRequest.getProductDescription())
                          .productVersions(ppSaveRequest.getProductVersions())
                          .createdAt(LocalDateTime.now())
                          .build();
       }
}
