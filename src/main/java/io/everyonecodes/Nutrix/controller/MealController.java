package io.everyonecodes.Nutrix.controller;

import io.everyonecodes.Nutrix.entity.Meal;
import io.everyonecodes.Nutrix.service.MealService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MealController {

    private final MealService service;

    MealController(MealService service) {
        this.service = service;
    }


    @GetMapping("/allmeals")
    List<Meal> getAll() {
        return service.getAll();
    }

    @GetMapping("/meal/{id}")
    Meal getById(@PathVariable long id) {
        return service.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/mealcategory")
    List<Meal> getMealsByCategoryId(@PathVariable long categoryId) {
        return service.getMealsByCategoryId(categoryId);
    }

    @GetMapping("recentmeals")
    List<Meal> getLast20Meals() {
        return service.getLast20Meals();
    }

    @GetMapping("/favoritemeals")
    List<Meal> getFavorites() {
        return service.getFavorites();
    }

    @PostMapping("/meal")
    Meal createOne(@RequestBody Meal meal) {
        return service.createOne(meal);
    }

    @PostMapping("/meals")
    List<Meal> createAll(@RequestBody List<Meal> meals) {
        return service.createAll(meals);
    }

    @PutMapping("/meal/{id}")
    Meal createOrReplace(@RequestBody Meal meal, @PathVariable long id) {
        return service.createOrReplace(meal, id);
    }

    @DeleteMapping("/meal/{id}")
    void delete(@PathVariable long id) {
        service.delete(id);
    }

    @DeleteMapping("/meals/{categoryId}")
    void deleteByCategoryId(@PathVariable long categoryId) {
        service.deleteByCategoryId(categoryId);
    }
}
