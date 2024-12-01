package com.testassignment.controller;


import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.testassignment.dto.AnimalDto;
import com.testassignment.service.AnimalService;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

@WebMvcTest(AnimalController.class)
class AnimalControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AnimalService service;

    @Test
    public void whenGetAnimals_thenEmptyArrayShouldBeReturned() throws Exception {
        when(service.getAnimals()).thenReturn(new ArrayList<>());
        this.mockMvc.perform(get("/getAnimals"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("[]")));
    }

    @Test
    public void whenPostAddAnimalRequest_thenSavedEntityShouldBeReturned() throws Exception {
        String animal = "{" +
                "\"name\": \"rex\"," +
                " \"age\" : 2," +
                " \"gender\" : \"MALE\"," +
                " \"breedType\" : 1" +
                "}";

        AnimalDto dto = new AnimalDto();
        dto.setName("rex");
        dto.setAge(2);
        dto.setGender("MALE");
        dto.setBreedType(1L);
        dto.setId(66L);
        when(service.addAnimal(any())).thenReturn(dto);
        this.mockMvc.perform(post("/addAnimal")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(animal))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"id\":66,\"name\":\"rex\",\"age\":2,\"breedType\":1,\"gender\":\"MALE\"}")));
    }

    @Test
    public void whenDeleteWasInvoked_thenServiceMethodShouldBeCalled() throws Exception {
        Mockito.doNothing().when(service).removeAnimal(any());
        this.mockMvc.perform(delete("/removeAnimal/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Animal was removed")));
    }

}

