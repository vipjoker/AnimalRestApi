package com.testassignment.service;

import com.testassignment.dto.AnimalDto;
import com.testassignment.dto.AnimalWithDetailsDto;
import com.testassignment.entity.AnimalEntity;
import com.testassignment.entity.BreedEntity;
import com.testassignment.exceptions.ApiException;
import com.testassignment.mapper.DtoEntityMapper;
import com.testassignment.repository.AnimalRepository;
import com.testassignment.repository.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    BreedRepository breedRepository;

    @Autowired
    DtoEntityMapper mapper;
    @Override
    public AnimalDto addAnimal(AnimalDto animalDto) {
        Optional<BreedEntity> breed = breedRepository.findById(animalDto.getBreedType());
        validateBody(animalDto, breed);
        AnimalEntity animalEntity = mapper.toAnimalEntity(animalDto,breed.get());
        AnimalEntity saved = animalRepository.save(animalEntity);
        return mapper.toAnimalDto(saved);
    }

    @Override
    public void removeAnimal(String id) {
        animalRepository.deleteById(Long.parseLong(id));
    }

    @Override
    public AnimalDto updateAnimal(AnimalDto animalDto) {

        Optional<AnimalEntity> byId = animalRepository.findById(animalDto.getId());
        if(byId.isEmpty()){
            throw new ApiException("Entity not found");
        }

        return addAnimal(animalDto);
    }

    @Override
    public List<AnimalDto> getAnimals() {
        return StreamSupport.stream(animalRepository.findAll().spliterator(),false).map(mapper::toAnimalDto).toList();

    }

    @Override
    public List<AnimalWithDetailsDto> getAnimalsWithDetails() {
        return StreamSupport
                .stream(animalRepository.findAll().spliterator(),false)
                .map(mapper::toAnimalWithDetailsDto).toList();

    }

    private void validateBody(AnimalDto animalDto, Optional<BreedEntity> breed) {
        if(breed.isEmpty()){
            throw new ApiException("Breed type " + animalDto.getBreedType() + " is not valid");
        }

        if(animalDto.getName() == null || animalDto.getName().isBlank()){
            throw new ApiException("Name must not be empty or null");
        }

        if(animalDto.getAge() <= 0){
            throw new ApiException("Age should be greater than zero");
        }
    }
}
