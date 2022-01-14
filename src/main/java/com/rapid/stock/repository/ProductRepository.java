package com.rapid.stock.repository;

import com.rapid.stock.model.ProductVersion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductVersion,String> {
}
