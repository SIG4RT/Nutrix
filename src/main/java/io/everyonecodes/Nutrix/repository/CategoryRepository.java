package io.everyonecodes.Nutrix.repository;

import io.everyonecodes.Nutrix.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
