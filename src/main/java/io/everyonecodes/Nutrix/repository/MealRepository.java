package io.everyonecodes.Nutrix.repository;

import io.everyonecodes.Nutrix.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    List<Meal> findTop20ByOrderByTimestampDesc();

    List<Meal> findByIsFavoriteTrue();

    List<Meal> findByCategoriesId(Long categoryId);

}
