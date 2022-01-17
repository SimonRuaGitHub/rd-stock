package com.rapid.stock.repository;

import com.rapid.stock.model.OptionType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OptionTypeRepository extends MongoRepository<OptionType, String> {
}
