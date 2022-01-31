package com.rapid.stock.dto;

import com.rapid.stock.model.ProductVersion;
import lombok.Data;
import java.util.List;

@Data
public class ParentProductSaveRequest {
       private String productId;
       private String productName;
       private String productDescription;
       private List<ProductVersionSaveRequest> productVersions;
}
