package io.everyonecodes.Nutrix.repository;

import io.everyonecodes.Nutrix.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    List<Meal> findTop20ByOrderByLastAddedDesc();

    List<Meal> findByIsFavoriteTrue();

    List<Meal> findByCategoriesId(Long categoryId);

    @Query("SELECT SUM(m.calories) FROM Meal m JOIN m.categories c WHERE c.id = :categoryId")
    Integer getTotalCaloriesByCategoryId(@Param("categoryId") Long categoryId);

    @Query("SELECT SUM(m.carbs) FROM Meal m JOIN m.categories c WHERE c.id = :categoryId")
    Double getTotalCarbsByCategoryId(@Param("categoryId") Long categoryId);

    @Query("SELECT SUM(m.protein) FROM Meal m JOIN m.categories c WHERE c.id = :categoryId")
    Double getTotalProteinByCategoryId(@Param("categoryId") Long categoryId);

    @Query("SELECT SUM(m.fat) FROM Meal m JOIN m.categories c WHERE c.id = :categoryId")
    Double getTotalFatByCategoryId(@Param("categoryId") Long categoryId);

}
