package com.testassignment.mapper;

import com.testassignment.dto.AnimalDto;
import com.testassignment.dto.AnimalWithDetailsDto;
import com.testassignment.entity.AnimalEntity;
import com.testassignment.entity.BreedEntity;

public interface DtoEntityMapper {

    AnimalEntity toAnimalEntity(AnimalDto animalDto, BreedEntity breedEntity);

    AnimalDto toAnimalDto(AnimalEntity animalEntity);

    AnimalWithDetailsDto toAnimalWithDetailsDto(AnimalEntity animalEntity);

}
