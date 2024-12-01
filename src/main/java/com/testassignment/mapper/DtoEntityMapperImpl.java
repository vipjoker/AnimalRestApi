package com.testassignment.mapper;

import com.testassignment.dto.AnimalDto;
import com.testassignment.dto.AnimalWithDetailsDto;
import com.testassignment.entity.AnimalEntity;
import com.testassignment.entity.BreedEntity;
import com.testassignment.entity.Gender;
import com.testassignment.exceptions.ApiException;

public class DtoEntityMapperImpl implements  DtoEntityMapper {



    @Override
    public AnimalEntity toAnimalEntity(AnimalDto animalDto, BreedEntity breed) {
        AnimalEntity entity = new AnimalEntity();
        entity.setId(animalDto.getId());
        entity.setName(animalDto.getName());
        entity.setAge(animalDto.getAge());
        entity.setBreed(breed);
        try{

            entity.setGender(Gender.valueOf(animalDto.getGender()));
        }catch (Exception e){
            throw new ApiException("Gender should be MALE or FEMALE");
        }
        return entity;
    }

    @Override
    public AnimalDto toAnimalDto(AnimalEntity animalEntity) {
        AnimalDto entity = new AnimalDto();
        entity.setId(animalEntity.getId());
        entity.setName(animalEntity.getName());
        entity.setAge(animalEntity.getAge());
        entity.setBreedType(animalEntity.getBreed().getId());
        entity.setGender(animalEntity.getGender().name());
        return entity;
    }

    @Override
    public AnimalWithDetailsDto toAnimalWithDetailsDto(AnimalEntity animalEntity) {
        AnimalWithDetailsDto entity = new AnimalWithDetailsDto();
        entity.setId(animalEntity.getId());
        entity.setName(animalEntity.getName());
        entity.setAge(animalEntity.getAge());
        if(animalEntity.getBreed() != null){
            entity.setBreedType(animalEntity.getBreed().getName());
        }
        entity.setGender(animalEntity.getGender().name());
        return entity;
    }
}