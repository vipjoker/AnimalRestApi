package com.testassignment.mapper;

import com.testassignment.dto.AnimalDto;
import com.testassignment.dto.AnimalWithDetailsDto;
import com.testassignment.entity.AnimalEntity;

public interface DtoEntityMapper {

    AnimalEntity toAnimalEntity(AnimalDto animalDto);

    AnimalDto toAnimalDto(AnimalEntity animalEntity);

    AnimalWithDetailsDto toAnimalWithDetailsDto(AnimalEntity animalEntity);

}
