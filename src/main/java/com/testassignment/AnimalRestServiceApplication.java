package com.testassignment;

import com.testassignment.entity.BreedEntity;
import com.testassignment.repository.AnimalRepository;
import com.testassignment.repository.BreedRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AnimalRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalRestServiceApplication.class, args);
	}

}
