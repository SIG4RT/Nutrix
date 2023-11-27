package io.everyonecodes.Nutrix.service;

import io.everyonecodes.Nutrix.entity.Category;
import io.everyonecodes.Nutrix.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }


    public List<Category> getAll() {
        return repository.findAll();
    }

    public Optional<Category> getById(long id) {
        return repository.findById(id);
    }

    public Category createOne(Category category) {
        return repository.save(category);
    }

    public List<Category> createAll(List<Category> categories) {
        return repository.saveAll(categories);
    }

    public Category createOrReplace(Category category, long id) {

        var oCategory = repository.findById(id);

        if (oCategory.isPresent()) {
            var oldCategory = oCategory.get();
            oldCategory.setName(category.getName());
            return repository.save(oldCategory);
        } else {
            return repository.save(category);
        }
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
