package com.rapid.stock.mapper;

import com.rapid.stock.dto.ParentProductSaveRequest;
import com.rapid.stock.dto.ProductVersionSaveRequest;
import com.rapid.stock.model.ParentProduct;
import com.rapid.stock.model.ProductType;
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
                          .productVersions(mapToProductVersion(ppSaveRequest.getProductVersions()))
                          .createdAt(LocalDateTime.now())
                          .build();
       }

       public List<ProductVersion> mapToProductVersion(List<ProductVersionSaveRequest> pvSaveRequestList){

              return pvSaveRequestList.stream()
                                      .map(pvSaveRequest -> { return ProductVersion.builder()
                                              .versionId(UUID.randomUUID().toString())
                                              .name(pvSaveRequest.getName())
                                              .description(pvSaveRequest.getDescription())
                                              .productType(pvSaveRequest.getProductType())
                                              .price(pvSaveRequest.getPrice())
                                              .quantityAvailable(pvSaveRequest.getQuantityAvailable())
                                              .isAvailable(pvSaveRequest.isAvailable())
                                              .createdAt(LocalDateTime.now())
                                              .optionCategories(null)
                                              .build();})
                                      .collect(Collectors.toList());
       }
}
