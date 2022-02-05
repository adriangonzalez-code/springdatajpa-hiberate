package com.smoothiemx.springdatajpa.component.mapping.app;

import com.smoothiemx.springdatajpa.component.mapping.app.entities.Address;
import com.smoothiemx.springdatajpa.component.mapping.app.entities.Employee;
import com.smoothiemx.springdatajpa.component.mapping.app.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ComponentMappingApplicationTests {

    @Autowired
    EmployeeRepository repository;

    @Test
    void testCreate() {
        Address address = new Address();
        address.setCity("Austin");
        address.setStreetaddress("Spicewood Springs");
        address.setCountry("USA");
        address.setState("TEXAS");
        address.setZipcode("78750");

        Employee employee = new Employee();

        employee.setId(123);
        employee.setName("Adrian");
        employee.setAddress(address);
        repository.save(employee);
    }
}