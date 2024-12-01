package com.testassignment.controller;

import com.testassignment.dto.AnimalDto;
import com.testassignment.dto.AnimalWithDetailsDto;
import com.testassignment.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalController {

    @Autowired
    AnimalService animalService;

    @PostMapping("addAnimal")
    AnimalDto addAnimal(@RequestBody AnimalDto animalDto){
        return animalService.addAnimal(animalDto);
    }

    @DeleteMapping("removeAnimal/{id}")
    String removeAnimal(@PathVariable String id){
        animalService.removeAnimal(id);
        return "Animal was removed";
    }

    @PutMapping("updateAnimal")
    AnimalDto updateAnimal(@RequestBody AnimalDto animalDto){
        return animalService.updateAnimal(animalDto);
    }

    @GetMapping("getAnimals")
    List<AnimalDto> getAnimals(){
        return animalService.getAnimals();
    }

    @GetMapping("getAnimalsWithDetails")
    List<AnimalWithDetailsDto> getAnimalsWithDetails(){
        return animalService.getAnimalsWithDetails();
    }



}
