package io.everyonecodes.Nutrix.repository;

import io.everyonecodes.Nutrix.Category;
import io.everyonecodes.Nutrix.Meal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DatabasePreloader {

    @Bean
    CommandLineRunner initDatabase(MealRepository mealRepository, CategoryRepository categoryRepository) {
        return args -> {

            Category recent = new Category(null, "recent", null);
            Category savedMeals = new Category(null, "saved meals", null);

            Category breakfast = new Category(null, "breakfast",null);
            Category lunch = new Category(null, "lunch",null);
            Category dinner = new Category(null, "dinner", null);
            Category snacks = new Category(null, "snacks", null);


            List<Meal> meals = new ArrayList<>(List.of(
                    new Meal(null, "Spaghetti", 850, 80.0, 20.0, 40.0, LocalDateTime.now(), lunch),
                    new Meal(null, "Pizza 33cm", 1000, 120.0, 30.0, 50.0, LocalDateTime.now(), lunch),
                    new Meal(null, "Burger", 900, 45.0, 40.0, 30.0, LocalDateTime.now(), dinner),
                    new Meal(null, "Toast", 300, 20.0, 10.0, 5.0, LocalDateTime.now(), breakfast),
                    new Meal(null, "Cereal", 400, 50.0, 2.0, 8.0, LocalDateTime.now(), breakfast)
            ));

            categoryRepository.save(breakfast);
            categoryRepository.save(lunch);
            categoryRepository.save(dinner);
            categoryRepository.save(snacks);

            mealRepository.saveAll(meals);
        };
    }
}
