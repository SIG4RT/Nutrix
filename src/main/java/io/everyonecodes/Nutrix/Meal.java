package io.everyonecodes.Nutrix;

import jakarta.persistence.*;
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
    private Long id;

    private String name;
    private Integer calories;
    private Double carbs;
    private Double protein;
    private Double fat;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
