package com.rapid.stock.mapper;

import com.rapid.stock.dto.ParentProductSaveRequest;
import com.rapid.stock.dto.ProductVersionSaveRequest;
import com.rapid.stock.model.ParentProduct;
import com.rapid.stock.model.ProductVersion;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ParentProductMapper {

       public ParentProduct mapSaveRequest(ParentProductSaveRequest ppSaveRequest){
              return ParentProduct.builder()
                          .productId(ppSaveRequest.getProductId())
                          .productName(ppSaveRequest.getProductName())
                          .productDescription(ppSaveRequest.getProductDescription())
                          .productVersions(mapProductVersionSaveRequest(ppSaveRequest.getProductVersions()))
                          .createdAt(LocalDateTime.now())
                          .build();
       }

       public List<ProductVersion> mapProductVersionSaveRequest(List<ProductVersionSaveRequest> productVersionSaveRequestList){

              return productVersionSaveRequestList.stream()
                                    .map(prodVersionSaveRequest ->
                                            ProductVersion.builder()
                                                    .versionId(UUID.randomUUID().toString())
                                                    .name(prodVersionSaveRequest.getName())
                                                    .description(prodVersionSaveRequest.getDescription())
                                                    .productType(prodVersionSaveRequest.getProductType())
                                                    .price(prodVersionSaveRequest.getPrice())
                                                    .quantityAvailable(prodVersionSaveRequest.getQuantityAvailable())
                                                    .isAvailable(prodVersionSaveRequest.isAvailable())
                                                    .createdAt(LocalDateTime.now())
                                                    .build())
                                  .collect(Collectors.toList());
       }


}
