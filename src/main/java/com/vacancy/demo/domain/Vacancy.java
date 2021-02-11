package com.vacancy.demo.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Vacancy {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nameOfCompany;
    @NotNull
    private String position;
    private Long expectedSalary;
    private String linkToVacancy;
    @ManyToOne
    @NotNull
    private CustomUser recruiter;
    private Status status;
    private LocalDateTime localDateTime;
    @ManyToMany
    private Set<CustomUser> candidates;
}
