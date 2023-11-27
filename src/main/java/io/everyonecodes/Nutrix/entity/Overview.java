package io.everyonecodes.Nutrix.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Overview {

    @Id
    @Column(nullable = false, unique = true)
    private LocalDate date;

    @OneToMany(mappedBy = "overview")
    @JsonBackReference
    private List<Category> categories;

    private int totalCalories;
    private int totalCarbs;
    private int totalProtein;
    private int totalFat;
}
