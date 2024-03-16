package com.example.week3;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(ProductRepository.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository repository){
        return (args) ->{
            log.info("Preloading: " + repository.
                    save(new Product("Apple",2.99,"Red and fresh")));
            log.info("Preloading: " + repository.
                    save(new Product("Beef",25.99,"Fresh and tasty")));
        };
    }

}
