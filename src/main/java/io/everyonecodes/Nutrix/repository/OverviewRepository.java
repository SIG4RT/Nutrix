package io.everyonecodes.Nutrix.repository;

import io.everyonecodes.Nutrix.entity.Overview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface OverviewRepository extends JpaRepository<Overview, LocalDate> {
}
