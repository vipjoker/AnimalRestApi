package com.testassignment.controller;

import com.testassignment.entity.AnimalDto;
import com.testassignment.service.AnimalService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalController {

    @Autowired
    AnimalService animalService;

    @PostMapping("addAnimal")
    AnimalDto addAnimal(AnimalDto animalDto){
        return animalService.addAnimal(animalDto);
    }

    @DeleteMapping("removeAnimal/{id}")
    void removeAnimal(@PathParam("id") String id){
        animalService.removeAnimal(id);
    }

    @PutMapping("updateAnimal")
    void updateAnimal(AnimalDto animalDto){
        animalService.updateAnimal(animalDto);
    }

    @GetMapping("getAnimals")
    List<AnimalDto> getAnimals(){
        return animalService.getAnimals();
    }

    @GetMapping("getAnimalsWithDetails")
    List<AnimalDto> getAnimalsWithDetails(){
        return animalService.getAnimalsWithDetails();
    }



}
