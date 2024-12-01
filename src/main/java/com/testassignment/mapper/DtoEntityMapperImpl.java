package com.testassignment.mapper;

import com.testassignment.dto.AnimalDto;
import com.testassignment.dto.AnimalWithDetailsDto;
import com.testassignment.entity.AnimalEntity;
import com.testassignment.entity.Gender;

public class DtoEntityMapperImpl implements  DtoEntityMapper {
    @Override
    public AnimalEntity toAnimalEntity(AnimalDto animalDto) {
        AnimalEntity entity = new AnimalEntity();
        entity.setId(animalDto.getId());
        entity.setName(animalDto.getName());
        entity.setAge(animalDto.getAge());
        entity.setBreedId(animalDto.getBreedType());
        entity.setGender(Gender.valueOf(animalDto.getGender()));
        return entity;
    }

    @Override
    public AnimalDto toAnimalDto(AnimalEntity animalEntity) {
        AnimalDto entity = new AnimalDto();
        entity.setId(animalEntity.getId());
        entity.setName(animalEntity.getName());
        entity.setAge(animalEntity.getAge());
        entity.setBreedType(animalEntity.getBreedId());
        entity.setGender(animalEntity.getGender().name());
        return entity;
    }

    @Override
    public AnimalWithDetailsDto toAnimalWithDetailsDto(AnimalEntity animalEntity) {
        AnimalWithDetailsDto entity = new AnimalWithDetailsDto();
        entity.setId(animalEntity.getId());
        entity.setName(animalEntity.getName());
        entity.setAge(animalEntity.getAge());
        entity.setBreedType(animalEntity.getBreed().getName());
        entity.setGender(animalEntity.getGender().name());
        return entity;
    }
}