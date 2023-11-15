package io.everyonecodes.Nutrix.repository;

import io.everyonecodes.Nutrix.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
}
