package com.testassignment.entity;

import com.testassignment.Gender;
import jakarta.persistence.*;

@Entity
public class AnimalEntity {
    @Id()
    private Long id;
    private String name;
    private Integer age;
    private String breedAge;
    @Enumerated(EnumType.STRING)
    private String gender;


}
