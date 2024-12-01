package com.testassignment.service;

import com.testassignment.dto.AnimalDto;
import com.testassignment.dto.AnimalWithDetailsDto;
import com.testassignment.entity.AnimalEntity;
import com.testassignment.mapper.DtoEntityMapper;
import com.testassignment.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;


    @Autowired
    DtoEntityMapper mapper;
    public AnimalDto addAnimal(AnimalDto animalDto) {
        AnimalEntity animalEntity = mapper.toAnimalEntity(animalDto);
        AnimalEntity saved = animalRepository.save(animalEntity);
        return mapper.toAnimalDto(saved);
    }

    public void removeAnimal(String id) {
        animalRepository.deleteById(Long.parseLong(id));
    }

    public void updateAnimal(AnimalDto animalDto) {

        Optional<AnimalEntity> byId = animalRepository.findById(animalDto.getId());
        if(byId.isEmpty()){
            throw new RuntimeException("Entity not found exception");
        }

        animalRepository.save(mapper.toAnimalEntity(animalDto));
    }

    public List<AnimalDto> getAnimals() {
        return StreamSupport.stream(animalRepository.findAll().spliterator(),false).map(mapper::toAnimalDto).toList();

    }

    public List<AnimalWithDetailsDto> getAnimalsWithDetails() {
        return StreamSupport
                .stream(animalRepository.findAll().spliterator(),false)
                .map(mapper::toAnimalWithDetailsDto).toList();

    }
}
