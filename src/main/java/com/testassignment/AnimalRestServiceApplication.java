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
//https://www.baeldung.com/jpa-one-to-one
//https://www.baeldung.com/spring-boot-bean-validation