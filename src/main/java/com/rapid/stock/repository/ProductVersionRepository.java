package com.rapid.stock.repository;

import com.rapid.stock.model.ProductVersion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductVersionRepository extends MongoRepository<ProductVersion,String> {
}
