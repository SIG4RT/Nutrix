package io.everyonecodes.Nutrix.service;

import io.everyonecodes.Nutrix.entity.Meal;
import io.everyonecodes.Nutrix.repository.MealRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealService {
    private final MealRepository repository;
    public MealService(MealRepository repository) {
        this.repository = repository;
    }


    public List<Meal> getAll() {
        return repository.findAll();
    }

    public Optional<Meal> getById(long id) {
        return repository.findById(id);
    }

    public List<Meal> getMealsByCategoryId(long categoryId) {
        return repository.findByCategoriesId(categoryId);
    }

    public List<Meal> getLast20Meals() {
        return repository.findTop20ByOrderByLastAddedDesc();
    }

    public List<Meal> getFavorites() {
        return repository.findByIsFavoriteTrue();
    }

    public Meal createOne(Meal meal) {
        return repository.save(meal);
    }

    public List<Meal> createAll(List<Meal> meals) {
        return repository.saveAll(meals);
    }

    public Meal createOrReplace(Meal newMeal, long id) {
        Optional<Meal> oOldMeal = repository.findById(id);
        if (oOldMeal.isPresent()) {
            var oldMeal = oOldMeal.get();
            oldMeal.setCalories(newMeal.getCalories());
            oldMeal.setName(newMeal.getName());
            oldMeal.setProtein(newMeal.getProtein());
            oldMeal.setCarbs(newMeal.getCarbs());
            oldMeal.setFat(newMeal.getFat());
            oldMeal.setCategories(newMeal.getCategories());
            return repository.save(oldMeal);
        } else {
            return repository.save(newMeal);
        }
    }

    public void delete(long id) {
        repository.deleteById(id);
    }


    public Integer getTotalCaloriesByCategoryId(long id) {
        return repository.getTotalCaloriesByCategoryId(id);
    }

    public Double getTotalCarbsByCategoryId(long id) {
        return repository.getTotalCarbsByCategoryId(id);
    }
    public Double getTotalProteinByCategoryId(long id) {
        return repository.getTotalProteinByCategoryId(id);
    }
    public Double getTotalFatByCategoryId(long id) {
        return repository.getTotalFatByCategoryId(id);
    }
}
