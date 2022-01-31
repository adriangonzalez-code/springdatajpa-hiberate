package com.smoothiemx.generator.app;

import com.smoothiemx.generator.app.entities.Employee;
import com.smoothiemx.generator.app.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GeneratorApplicationTests {

    @Autowired
    EmployeeRepository repository;

    @Test
    void testCreateEmployee() {
        Employee employee = new Employee();
        employee.setName("John");
        repository.save(employee);
    }

}