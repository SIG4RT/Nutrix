package io.everyonecodes.Nutrix.service;

import io.everyonecodes.Nutrix.Meal;
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

    public List<Meal> getLast20Meals() {
        return repository.findTop20ByOrderByTimestampDesc();
    }

    public List<Meal> getSavedMeals() {
        return repository.findByIsSavedTrue();
    }

    public Meal createNew(Meal meal) {
        return repository.save(meal);
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
            oldMeal.setCategory(newMeal.getCategory());
            return repository.save(oldMeal);
        } else {
            return repository.save(newMeal);
        }
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
