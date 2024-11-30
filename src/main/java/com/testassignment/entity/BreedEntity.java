package com.testassignment.entity;

import jakarta.persistence.Entity;

@Entity
public class BreedEntity {
    private Long id;
    private String name;

    public BreedEntity(String name) {
        this.name = name;
    }

    public BreedEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
