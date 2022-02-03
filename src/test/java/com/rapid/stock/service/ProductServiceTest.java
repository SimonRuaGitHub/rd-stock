package com.rapid.stock.service;

import com.rapid.stock.dto.ParentProductSaveRequest;
import com.rapid.stock.mapper.ParentProductMapper;
import com.rapid.stock.model.ParentProduct;
import com.rapid.stock.model.ProductType;
import com.rapid.stock.model.ProductVersion;
import com.rapid.stock.repository.ParentProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.Validator;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ParentProductMapper parentProductMapper;

    @Mock
    private ParentProductRepository parentProductRepository;

    @Mock
    private Validator validator;

    @InjectMocks
    private ProductServiceImp productService;

    @Test
    public void when_creating_new_product_it_should_return_same_product(){

        ParentProductSaveRequest ppSaveRequest = Mockito.mock(ParentProductSaveRequest.class);

        ProductVersion productVersion = new ProductVersion();
        productVersion.setVersionId("anyselftgeneratedstringUUID");
        productVersion.setName("prod_version_name");
        productVersion.setDescription("prod_version_description");
        productVersion.setAvailable(true);
        productVersion.setProductType(ProductType.MENU_RESTAURANT);
        productVersion.setCreatedAt(LocalDateTime.now());
        productVersion.setPrice(Double.valueOf(0));
        productVersion.setQuantityAvailable(Integer.valueOf(90));

        ParentProduct expectedParentProduct = new ParentProduct();
        expectedParentProduct.setProductId("23523352");
        expectedParentProduct.setProductName("product_name");
        expectedParentProduct.setProductDescription("prod_description");
        expectedParentProduct.setCreatedAt(LocalDateTime.now());
        expectedParentProduct.setProductVersions(Arrays.asList(productVersion));

        when(parentProductMapper.mapSaveRequest(any(ParentProductSaveRequest.class))).thenReturn(expectedParentProduct);
        when(parentProductRepository.insert(any(ParentProduct.class))).thenReturn(expectedParentProduct);

        ParentProduct actualParentProduct = productService.save(ppSaveRequest);

        ProductVersion expectedProdVersion = expectedParentProduct.getProductVersions().stream().findFirst().get();
        ProductVersion actualProdVersion = actualParentProduct.getProductVersions().stream().findFirst().get();

        Assertions.assertAll("It should return same product",
                ()-> Assertions.assertEquals(expectedParentProduct.getProductName(), actualParentProduct.getProductName()),
                ()-> Assertions.assertEquals(expectedParentProduct.getCreatedAt(), actualParentProduct.getCreatedAt()),
                ()-> Assertions.assertEquals(!expectedProdVersion.getVersionId().isEmpty(), !actualProdVersion.getVersionId().isEmpty()),
                ()-> Assertions.assertEquals(expectedProdVersion.getProductType(), actualProdVersion.getProductType()),
                ()-> Assertions.assertEquals(expectedProdVersion.getName(), actualProdVersion.getName()),
                ()-> Assertions.assertEquals(expectedProdVersion.isAvailable(), actualProdVersion.isAvailable())
        );
    }

}
