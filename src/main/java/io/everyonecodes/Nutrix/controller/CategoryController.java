package io.everyonecodes.Nutrix.controller;

import io.everyonecodes.Nutrix.entity.Category;
import io.everyonecodes.Nutrix.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }


    @GetMapping("/allcategories")
    List<Category> getAll() {
        return service.getAll();
    }

    @GetMapping("/category/{id}")
    Category getById(@PathVariable long id) {
        return service.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/category")
    Category createNew(@RequestBody Category category) {
        return service.createOne(category);
    }

    @PostMapping("/categories")
    List<Category> createAll(@RequestBody List<Category> categories) {
        return service.createAll(categories);
    }

    @PutMapping("/category/{id}")
    Category createOrReplace(@RequestBody Category category, @PathVariable long id) {
        return service.createOrReplace(category, id);
    }

    @DeleteMapping("/category/{id}")
    void delete(@PathVariable long id) {
        service.delete(id);
    }
}
