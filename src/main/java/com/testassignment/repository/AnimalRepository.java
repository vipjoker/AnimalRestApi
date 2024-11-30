package com.testassignment.repository;

import com.testassignment.entity.AnimalDto;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Long, AnimalDto> {

}
