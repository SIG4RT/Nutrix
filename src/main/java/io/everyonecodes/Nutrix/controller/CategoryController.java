package io.everyonecodes.Nutrix.controller;

import io.everyonecodes.Nutrix.Category;
import io.everyonecodes.Nutrix.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private CategoryService service;
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping("/allcategories")
    public List<Category> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Category createNew(@RequestBody Category category) {
        return service.createNew(category);
    }

}
