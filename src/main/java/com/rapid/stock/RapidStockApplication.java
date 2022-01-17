package com.rapid.stock;

import com.rapid.stock.model.*;
import com.rapid.stock.repository.ParentProductRepository;
import com.rapid.stock.repository.ProductVersionRepository;
import com.rapid.stock.repository.SubproductTypeRepository;
import org.bson.types.ObjectId;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@SpringBootApplication
public class RapidStockApplication {
    public static void main(String[] args){
        SpringApplication.run(RapidStockApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(ParentProductRepository parentProdRepository, ProductVersionRepository productVersionRepository, SubproductTypeRepository subproductTypeRepository, MongoTemplate mongoTemplate){
           return args -> {
               System.out.println("Inserting ProductVersion");
               ArrayList<Subproduct> subproducts = new ArrayList<>();
               subproducts.add(new Subproduct(1,"Salsa de Tomate", Double.valueOf(0)));
               subproducts.add(new Subproduct(2, "Salsa Qbano", Double.valueOf(0)));
               subproducts.add(new Subproduct(3, "Salsa de la casa", Double.valueOf(1000)));

               ArrayList<SubProductType> subProductTypes = new ArrayList<>();
               subProductTypes.add(new SubProductType(new ObjectId().toString(),"Elige tus salsas y complementos aparte", "seleccion de salsas y complementos", subproducts));

               subproductTypeRepository.saveAll(subProductTypes);

               ArrayList<ProductVersion> productVersions = new ArrayList<>();
               productVersions.add(new ProductVersion(
                       new ObjectId().toString(),
                       UUID.randomUUID().toString(),
                       "Combo Rapidgos Big con queso, tocineta, papas y gasesosa",
                       "Combo con papas y gaseos agrandadas",
                       ProductType.MENU_RESTAURANT,
                       Double.valueOf(17000.9),
                       30,
                       true,
                       LocalDateTime.now(),
                       subProductTypes
               ));

               productVersionRepository.saveAll(productVersions);

               ParentProduct parentProduct = new ParentProduct(
                       "2353565",
                       "Rapidogs Big",
                       "Rapidogs clásico con queso, tocineta, papas y gaseosa agrandadas.",
                        LocalDateTime.now(),
                        productVersions
               );

               parentProdRepository.save(parentProduct);
           };
    }
}
