package com.smoothiemx.springdatajpa.relationships.app.manytomany.repos;

import com.smoothiemx.springdatajpa.relationships.app.manytomany.entities.Programmer;
import org.springframework.data.repository.CrudRepository;

public interface ProgrammerRepository extends CrudRepository<Programmer, Integer> {
}
