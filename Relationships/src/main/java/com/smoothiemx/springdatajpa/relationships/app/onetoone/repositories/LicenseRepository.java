package com.smoothiemx.springdatajpa.relationships.app.onetoone.repositories;

import com.smoothiemx.springdatajpa.relationships.app.onetoone.entities.License;
import org.springframework.data.repository.CrudRepository;

public interface LicenseRepository extends CrudRepository<License, Long> {


}