package com.testassignment.service;

import com.testassignment.dto.AnimalDto;
import com.testassignment.dto.AnimalWithDetailsDto;

import java.util.List;

public interface AnimalService {

    AnimalDto addAnimal(AnimalDto animalDto);

    void removeAnimal(String id);

    AnimalDto updateAnimal(AnimalDto animalDto);

    List<AnimalDto> getAnimals();

    List<AnimalWithDetailsDto> getAnimalsWithDetails();
}
