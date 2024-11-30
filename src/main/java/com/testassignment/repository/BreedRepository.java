package com.testassignment.repository;

import com.testassignment.entity.AnimalDto;
import com.testassignment.entity.BreedEntity;
import org.springframework.data.repository.CrudRepository;

public interface BreedRepository  extends CrudRepository<BreedEntity, Long> {
}
