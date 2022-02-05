package com.smoothiemx.springdatajpa.component.mapping.app.repos;

import com.smoothiemx.springdatajpa.component.mapping.app.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}