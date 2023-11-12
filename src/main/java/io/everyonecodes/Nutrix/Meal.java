package io.everyonecodes.Nutrix;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Meal {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private int calories;
    private double carbs;
    private double protein;
    private double fat;

//    private List<Ingredient> ingredients;
//
//    public Meal(String name, int calories, double carbs, double protein, double fat, List<Ingredient> ingredients) {
//        this.name = name;
//        this.calories = calories;
//        this.carbs = carbs;
//        this.protein = protein;
//        this.fat = fat;
//        this.ingredients = ingredients;
//    }

    public Meal(String name, int calories, double carbs, double protein, double fat) {
        this.name = name;
        this.calories = calories;
        this.carbs = carbs;
        this.protein = protein;
        this.fat = fat;
    }
}
