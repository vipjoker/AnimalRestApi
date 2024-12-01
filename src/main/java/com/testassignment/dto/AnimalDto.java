package com.testassignment.dto;

public class AnimalDto{
   private Long id;
   private String name;
   private Integer age;
   private Long breedType;
   private String gender;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getBreedType() {
        return breedType;
    }

    public void setBreedType(Long breedType) {
        this.breedType = breedType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}




