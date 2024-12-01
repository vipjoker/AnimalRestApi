package com.testassignment.repository;

import com.testassignment.entity.AnimalDto;
import com.testassignment.entity.AnimalEntity;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<AnimalEntity,Long > {

}
