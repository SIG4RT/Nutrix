package io.everyonecodes.Nutrix.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Meal {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Integer calories;
    private Double carbs;
    private Double protein;
    private Double fat;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime timestamp = LocalDateTime.now();

    @ManyToMany
    @JoinTable(
            name = "meal_category",
            joinColumns = @JoinColumn(name = "meal_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories = new ArrayList<>();

    private Boolean isFavorite;

    @Override
    public String toString() {
        var day = timestamp.getDayOfMonth();
        var month = timestamp.getMonth();
        var year = timestamp.getYear();
        var dot = ".";
        return "{Meal " +
                "id = " + id +
                ", name = " + name +
                ", calories = " + calories +
                ", carbs = " + carbs +
                ", protein = " + protein +
                ", fat = " + fat +
                ", creation date = " + day + dot + month + dot + year  +
                ", categories = " + categories +
                ", favorite = " + isFavorite +
                "}";
    }
}
