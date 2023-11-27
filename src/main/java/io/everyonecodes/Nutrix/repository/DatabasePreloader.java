package io.everyonecodes.Nutrix.repository;

import io.everyonecodes.Nutrix.entity.Category;
import io.everyonecodes.Nutrix.entity.Meal;
import io.everyonecodes.Nutrix.service.CategoryService;
import io.everyonecodes.Nutrix.service.MealService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DatabasePreloader {


    @Bean
    CommandLineRunner initDatabase(MealService mealService, CategoryService categoryService) {
        return args -> {

            Category breakfast = new Category(null, "breakfast",null, null);
            Category lunch = new Category(null, "lunch",null, null);
            Category dinner = new Category(null, "dinner", null, null);
            Category snacks = new Category(null, "snacks", null, null);

            List<Meal> meals = new ArrayList<>(
                    List.of(
                        new Meal(null, "Spaghetti", 850, 80.0, 20.0, 40.0, LocalDateTime.now(), lunch, null),
                        new Meal(null, "Pizza 33cm", 1000, 120.0, 30.0, 50.0, LocalDateTime.now(), lunch, null),
                        new Meal(null, "Burger", 900, 45.0, 40.0, 30.0, LocalDateTime.now(), dinner, true),
                        new Meal(null, "Toast", 300, 20.0, 10.0, 5.0, LocalDateTime.now(), breakfast, null),
                        new Meal(null, "Cereal", 400, 50.0, 2.0, 8.0, LocalDateTime.now(), breakfast, true)
            ));


            categoryService.createAll(List.of(breakfast, lunch, dinner, snacks));
            mealService.createAll(meals);
        };
    }
}
