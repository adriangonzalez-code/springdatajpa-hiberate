package com.smoothiemx.springdatajpa.relationships.app.onetomany.repos;

import com.smoothiemx.springdatajpa.relationships.app.onetomany.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}