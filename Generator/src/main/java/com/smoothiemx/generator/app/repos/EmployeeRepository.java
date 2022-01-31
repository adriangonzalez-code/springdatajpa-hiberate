package com.smoothiemx.generator.app.repos;

import com.smoothiemx.generator.app.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}