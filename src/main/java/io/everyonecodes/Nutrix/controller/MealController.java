package io.everyonecodes.Nutrix.controller;

import io.everyonecodes.Nutrix.Meal;
import io.everyonecodes.Nutrix.service.MealService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MealController {

    private final MealService service;

    public MealController(MealService service) {
        this.service = service;
    }


    @GetMapping("/allmeals")
    public List<Meal> getAll() {
        return service.getAll();
    }

    @GetMapping("/meal/{id}")
    public Meal getById(@PathVariable long id) {
        return service.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("recentmeals")
    public List<Meal> getLast20Meals() {
        return service.getLast20Meals();
    }

    @GetMapping("/savedmeals")
    public List<Meal> getSavedMeals() {
        return service.getSavedMeals();
    }

    @PostMapping("/meal")
    public Meal createNew(@RequestBody Meal meal) {
        return service.createNew(meal);
    }

    @PutMapping("/meal/{id}")
    public Meal createOrReplace(@RequestBody Meal meal, @PathVariable long id) {
        return service.createOrReplace(meal, id);
    }

    @DeleteMapping("/meal/{id}")
    public String delete(@PathVariable long id) {
        service.delete(id);
        return "Successfully deleted Meal with id " + id;
    }
}
