package io.everyonecodes.Nutrix;

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

    public Meal createNew(Meal meal) {
        return repository.save(meal);
    }

    public String createOrReplace(Meal newMeal, long id) {

        Optional<Meal> oOldMeal = repository.findById(id);

        if (oOldMeal.isPresent()) {
            repository.save(oOldMeal.get());
            return "Successfully replaced existing Meal with id " + id;
        } else {
            repository.save(newMeal);
            return "No existing entry found. Successfully created new Meal with id " + id;
        }
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

}
