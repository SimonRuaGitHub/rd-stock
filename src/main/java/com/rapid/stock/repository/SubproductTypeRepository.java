package com.rapid.stock.repository;

import com.rapid.stock.model.SubProductType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubproductTypeRepository extends MongoRepository<SubProductType, String> {
}
