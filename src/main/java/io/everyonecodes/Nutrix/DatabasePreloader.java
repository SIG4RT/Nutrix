package io.everyonecodes.Nutrix;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DatabasePreloader {

    @Bean
    CommandLineRunner initDatabase(MealRepository repository) {
        return args -> {
            List<Meal> posts = new ArrayList<>(List.of(
                    new Meal("Spaghetti", 850, 80, 20, 40),
                    new Meal("Pizza 33cm", 1000, 120, 30, 50),
                    new Meal("Burger", 900, 45, 40, 30)
            ));
            repository.saveAll(posts);
        };
    }

}
