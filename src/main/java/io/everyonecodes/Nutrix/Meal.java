package io.everyonecodes.Nutrix;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "category_id")
    private Category category;

//    @JsonIgnore
    private Boolean isSaved;

//    @PrePersist
//    void preInsert() {
//        if (this.isSaved == null) {
//            this.isSaved = false;
//        }
//    }
}
