package io.everyonecodes.Nutrix.repository;

import io.everyonecodes.Nutrix.Meal;
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
            List<Meal> meals = new ArrayList<>(List.of(
                    new Meal("Spaghetti", 850, 80.0, 20.0, 40.0),
                    new Meal("Pizza 33cm", 1000, 120.0, 30.0, 50.0),
                    new Meal("Burger", 900, 45.0, 40.0, 30.0)
            ));
            repository.saveAll(meals);
        };
    }

}
