package io.everyonecodes.Nutrix.service;

import io.everyonecodes.Nutrix.Category;
import io.everyonecodes.Nutrix.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }


    public List<Category> getAll() {
        return repository.findAll();
    }

    public Category createNew(Category category) {
        return repository.save(category);
    }

}
