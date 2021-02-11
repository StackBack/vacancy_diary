package com.vacancy.demo.repository;

import com.vacancy.demo.domain.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
}
