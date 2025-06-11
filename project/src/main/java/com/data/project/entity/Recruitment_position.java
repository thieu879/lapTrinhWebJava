package com.data.project.entity;

import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Check(constraints = "minSalary >= 0 AND maxSalary >= minSalary")
public class Recruitment_position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, columnDefinition = "varchar(100)")
    private String name;
    @Column(nullable = true, columnDefinition = "varchar(100)")
    private String description;
    @Column(nullable = false)
    private double minSalary;
    @Column(nullable = false)
    private double maxSalary;
    @Column(columnDefinition = "default 0")
    private int minExperience;
    @Column(columnDefinition = "default current_date")
    private LocalDate createdDate;
    @Column(nullable = false)
    private LocalDate expiredDate;
}
