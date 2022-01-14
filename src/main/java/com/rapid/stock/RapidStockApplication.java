package com.rapid.stock;

import com.rapid.stock.model.Item;
import com.rapid.stock.model.Product;
import com.rapid.stock.model.ProductType;
import com.rapid.stock.model.Subproduct;
import com.rapid.stock.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RapidStockApplication {
    public static void main(String[] args){
        SpringApplication.run(RapidStockApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(ProductRepository repository, MongoTemplate mongoTemplate){
           return args -> {
                 System.out.println("Inserting Product");

                 List<Item> items = Arrays.asList(new Item(1,"Coca Cola", 0),
                                                  new Item(2,"Sprite", 0),
                                                  new Item(3, "Beer", 4000));

                 List<Subproduct> subproducts = Arrays.asList(new Subproduct(1,"drinks",true, items));

                 Product product = new Product(
                          "2353565",
                          "Rapidogs Big",
                          "Rapidogs clásico con queso, tocineta, papas y gaseosa a elección.",
                          Double.valueOf(12000),
                          50,
                           ProductType.MENU_RESTAURANT,
                          true,
                           LocalDateTime.now(),
                           subproducts
                          );

               Query query = Query.query(Criteria.where("productType").is(ProductType.MENU_RESTAURANT.toString())
                                                 .and("isAvailable").is(true)
                                                 .and("quantityAvailable").gt(29));

               List<Product> products = mongoTemplate.find(query, Product.class);

               System.out.println("products found through query: ");
               products.forEach(System.out::println);

               repository.insert(product);
           };
    }
}
