package com.testassignment.entity;

import com.testassignment.Gender;
import jakarta.persistence.*;

@Entity
public class AnimalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String breedAge;
    @Enumerated(EnumType.STRING)
    private Gender gender;


}
