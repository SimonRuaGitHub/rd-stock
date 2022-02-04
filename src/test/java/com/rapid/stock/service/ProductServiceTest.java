package com.rapid.stock.service;

import com.rapid.stock.dto.ParentProductSaveRequest;
import com.rapid.stock.exception.InvalidDataFieldException;
import com.rapid.stock.mapper.ParentProductMapper;
import com.rapid.stock.model.ParentProduct;
import com.rapid.stock.model.ProductType;
import com.rapid.stock.model.ProductVersion;
import com.rapid.stock.repository.ParentProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.Validation;
import javax.validation.Validator;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ParentProductMapper parentProductMapper;

    @Mock
    private ParentProductRepository parentProductRepository;

    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    private ProductServiceImp productService;

    @BeforeEach
    public void setUpService(){
        productService = new ProductServiceImp(parentProductRepository, parentProductMapper, validator);
    }

    @Test
    public void can_create_a_main_product_with_product_versions_only(){
            //Given
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

            //When
            productService.save(ppSaveRequest);

            //Then
            ArgumentCaptor<ParentProduct> parProdArgumentCaptor = ArgumentCaptor.forClass(ParentProduct.class);
            verify(parentProductRepository).insert(parProdArgumentCaptor.capture());

            ParentProduct capturedParentProduct = parProdArgumentCaptor.getValue();

            assertThat(capturedParentProduct).isEqualTo(expectedParentProduct);
    }

    @Test
    public void can_create_a_main_product_without_product_versions(){
        //Given
        ParentProductSaveRequest ppSaveRequest = Mockito.mock(ParentProductSaveRequest.class);

        ParentProduct expectedParentProduct = new ParentProduct();
        expectedParentProduct.setProductId("23523352");
        expectedParentProduct.setProductName("product_name");
        expectedParentProduct.setProductDescription("prod_description");
        expectedParentProduct.setCreatedAt(LocalDateTime.now());
        expectedParentProduct.setProductVersions(null);

        when(parentProductMapper.mapSaveRequest(any(ParentProductSaveRequest.class))).thenReturn(expectedParentProduct);

        //When
        productService.save(ppSaveRequest);

        //Then
        ArgumentCaptor<ParentProduct> parProdArgumentCaptor = ArgumentCaptor.forClass(ParentProduct.class);
        verify(parentProductRepository).insert(parProdArgumentCaptor.capture());

        ParentProduct capturedParentProduct = parProdArgumentCaptor.getValue();

        assertThat(capturedParentProduct).isEqualTo(expectedParentProduct);
    }

    @Test
    public void cannot_create_only_main_product_with_invalid_data_in_all_fields(){
        //Given
        ParentProductSaveRequest ppSaveRequest = Mockito.mock(ParentProductSaveRequest.class);

        ParentProduct expectedParentProduct = new ParentProduct();
        expectedParentProduct.setProductId(null);
        expectedParentProduct.setProductName("");
        expectedParentProduct.setProductDescription("");
        expectedParentProduct.setCreatedAt(null);
        expectedParentProduct.setProductVersions(null);

        when(parentProductMapper.mapSaveRequest(any(ParentProductSaveRequest.class))).thenReturn(expectedParentProduct);

        //When
        Throwable exception = assertThrows(InvalidDataFieldException.class, () -> productService.save(ppSaveRequest) );

        //Then
        assertThat(exception.getMessage()).contains("Some of the fields have invalid have invalid data or no data at all");
        String validationsMessage = exception.getMessage().split(":")[1];
        assertFalse(validationsMessage == null || validationsMessage.isEmpty());
    }

    @Test
    public void cannot_create_only_main_product_with_invalid_data_in_one_field(){
        //Given
        ParentProductSaveRequest ppSaveRequest = Mockito.mock(ParentProductSaveRequest.class);

        ParentProduct expectedParentProduct = new ParentProduct();
        expectedParentProduct.setProductId(null);
        expectedParentProduct.setProductName("product_name");
        expectedParentProduct.setProductDescription("prod_description");
        expectedParentProduct.setCreatedAt(LocalDateTime.now());
        expectedParentProduct.setProductVersions(null);

        when(parentProductMapper.mapSaveRequest(any(ParentProductSaveRequest.class))).thenReturn(expectedParentProduct);

        //When
        Throwable exception = assertThrows(InvalidDataFieldException.class, () -> productService.save(ppSaveRequest) );

        //Then
        assertThat(exception.getMessage()).contains("Some of the fields have invalid have invalid data or no data at all");
        String validationsMessage = exception.getMessage().split(":")[1];
        assertFalse(validationsMessage == null || validationsMessage.isEmpty());
    }
}
