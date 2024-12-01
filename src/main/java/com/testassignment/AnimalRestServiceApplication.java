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

@SpringBootApplication
public class AnimalRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalRestServiceApplication.class, args);
	}






	@Bean
	CommandLineRunner runner (BreedRepository repository) {
		return args -> {
			for (BreedEntity p : Arrays.asList(
					new BreedEntity("Afganský chrt"),
					new BreedEntity("Americká akita"),
					new BreedEntity("Anglický buldog"),
					new BreedEntity("Belgický ovčiak"),
					new BreedEntity("Bradáč")
			)) {

				repository.save(p);
			}
		};
	}

}