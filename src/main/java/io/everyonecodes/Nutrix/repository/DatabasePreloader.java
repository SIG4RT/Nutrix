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

            Category breakfast = new Category(null, "breakfast",null);
            Category lunch = new Category(null, "lunch",null);
            Category dinner = new Category(null, "dinner", null);
            Category snacks = new Category(null, "snacks", null);

            List<Meal> meals = new ArrayList<>(
                    List.of(
                            new Meal(null, "Spaghetti Carbonara", 850, 80.0, 20.0, 40.0, LocalDateTime.now(), new ArrayList<>(List.of(lunch)), null),
                            new Meal(null, "Pizza 33cm", 1000, 120.0, 30.0, 50.0, LocalDateTime.now(), new ArrayList<>(List.of(lunch)), null),
                            new Meal(null, "Burger", 900, 45.0, 40.0, 30.0, LocalDateTime.now(), new ArrayList<>(List.of(dinner)), true),
                            new Meal(null, "Buttered toast with ham and cheese", 300, 20.0, 10.0, 5.0, LocalDateTime.now(), new ArrayList<>(List.of(breakfast, snacks)), null),
                            new Meal(null, "Fruit Loop Cereal", 400, 50.0, 2.0, 8.0, LocalDateTime.now(), new ArrayList<>(List.of(breakfast)), true),
                            new Meal(null, "A chocolate bar with icing", 20, 30.0, 2.0, 8.0, LocalDateTime.now(), new ArrayList<>(List.of(snacks)), true),
                            new Meal(null, "Chicken Alfredo with parmesan", 20, 60.0, 20.0, 8.0, LocalDateTime.now(), new ArrayList<>(List.of(lunch)), true)
            ));

            List<Category> categories = List.of(breakfast, lunch, dinner, snacks);

            categoryService.createAll(categories);
            mealService.createAll(meals);
        };
    }
}
