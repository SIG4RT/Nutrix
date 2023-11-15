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
    public Meal getOne(@PathVariable long id) {
        return service.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/meal")
    public Meal createNew(@RequestBody Meal Meal) {
        return service.createNew(Meal);
    }

    @PutMapping("/meal/{id}")
    public String createOrReplace(@RequestBody Meal Meal, @PathVariable long id) {
        return service.createOrReplace(Meal, id);
    }

    @DeleteMapping("/meal/{id}")
    public String delete(@PathVariable long id) {
        service.delete(id);
        return "Successfully deleted Meal with id " + id;
    }
}
