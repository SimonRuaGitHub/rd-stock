package com.rapid.stock;

import com.rapid.stock.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class RapidStockApplication {
    public static void main(String[] args){
        SpringApplication.run(RapidStockApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(ProductRepository repository, MongoTemplate mongoTemplate){
           return args -> {
                /* System.out.println("Inserting ProductVersion");

                 List<Item> items = Arrays.asList(new Item(1,"Coca Cola", 0),
                                                  new Item(2,"Sprite", 0),
                                                  new Item(3, "Beer", 4000));

                 List<Subproduct> subproducts = Arrays.asList(new Subproduct(1,"drinks",true, items));

                 ProductVersion parentProduct = new ProductVersion(
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

               List<ProductVersion> parentProducts = mongoTemplate.find(query, ProductVersion.class);

               System.out.println("parentProducts found through query: ");
               parentProducts.forEach(System.out::println);

               repository.insert(parentProduct);*/
           };
    }
}
