package com.vacancy.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vacancy.demo.util.annotation.ValidPassword;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "users")
public class CustomUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    @Column(unique = true)
    private String email;
    @Size(max = 30)
    private String name;
    @Size(max = 30)
    private String lastName;
    private String number;
    private String skype;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String confirmPassword;
    @ManyToMany
    @JoinTable(
            name = "User_Vacancy",
            joinColumns = { @JoinColumn(name = "users_id")},
            inverseJoinColumns = { @JoinColumn(name = "vacancy_id")}
    )
    private Set<Vacancy> listOfVacancy;
    private Role role;
}
