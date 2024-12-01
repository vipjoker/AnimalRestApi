package com.testassignment.configuration;

import com.testassignment.entity.BreedEntity;
import com.testassignment.mapper.DtoEntityMapper;
import com.testassignment.mapper.DtoEntityMapperImpl;
import com.testassignment.repository.BreedRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfiguration {


    @Bean
    DtoEntityMapper createMapper(){
        return new DtoEntityMapperImpl();
    }

    @Bean
    CommandLineRunner runner (BreedRepository repository) {
        return args -> {
            List<BreedEntity> breedEntities = Arrays.asList(
                    new BreedEntity(1L, "Afganský chrt"),
                    new BreedEntity(2L, "Americká akita"),
                    new BreedEntity(3L, "Anglický buldog"),
                    new BreedEntity(4L, "Belgický ovčiak"),
                    new BreedEntity(5L, "Bradáč")
            );

            repository.saveAll(breedEntities);

        };
    }
}
