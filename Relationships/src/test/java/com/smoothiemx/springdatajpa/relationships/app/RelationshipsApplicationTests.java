package com.smoothiemx.springdatajpa.relationships.app;

import com.smoothiemx.springdatajpa.relationships.app.manytomany.entities.Programmer;
import com.smoothiemx.springdatajpa.relationships.app.manytomany.entities.Project;
import com.smoothiemx.springdatajpa.relationships.app.manytomany.repos.ProgrammerRepository;
import com.smoothiemx.springdatajpa.relationships.app.onetomany.entities.Customer;
import com.smoothiemx.springdatajpa.relationships.app.onetomany.entities.PhoneNumber;
import com.smoothiemx.springdatajpa.relationships.app.onetomany.repos.CustomerRepository;
import com.smoothiemx.springdatajpa.relationships.app.onetoone.entities.License;
import com.smoothiemx.springdatajpa.relationships.app.onetoone.entities.Person;
import com.smoothiemx.springdatajpa.relationships.app.onetoone.repositories.LicenseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class RelationshipsApplicationTests {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private ProgrammerRepository programmerRepository;

    @Autowired
    private LicenseRepository licenseRepository;

    @Test
    void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setName("Jane");

        PhoneNumber ph1 = new PhoneNumber();
        ph1.setNumber("48942144");
        ph1.setType("cell");

        PhoneNumber ph2 = new PhoneNumber();
        ph2.setNumber("8745454");
        ph2.setType("home");

        customer.addPhoneNumber(ph1);
        customer.addPhoneNumber(ph2);

        repository.save(customer);
    }

    @Test
    @Transactional
    void testLoadCustomer() {
        Customer customer = this.repository.findById(3L).get();
        System.out.println("customer = " + customer.getName());

        Set<PhoneNumber> numbers = customer.getNumbers();
        numbers.forEach(number -> {
            System.out.println("number = " + number.getNumber());
        });
    }

    @Test
    void testUpdateCustomer() {
        Customer customer = this.repository.findById(3L).get();
        customer.setName("John Bush");

        Set<PhoneNumber> numbers = customer.getNumbers();
        numbers.forEach(number -> {
            number.setType("cell");
        });

        repository.save(customer);
    }

    @Test
    void testDelete() {
        repository.deleteById(2L);
    }


    /*
     * ManyToMany Test
     */

    @Test
    void testM2MCreateProgrammer() {
        Programmer programmer = new Programmer();
        programmer.setName("Juan");
        programmer.setSal(20000);

        HashSet<Project> projects = new HashSet<>();
        Project project = new Project();
        project.setName("Spring Project");

        projects.add(project);

        programmer.setProjects(projects);

        programmerRepository.save(programmer);
    }

    @Test
    void testM2MFindProgrammer() {
        Programmer programmer = programmerRepository.findById(5).get();
        System.out.println("programmer = " + programmer);
        System.out.println("programmer.getProjects() = " + programmer.getProjects());
    }

    @Test
    void testO2OCreateLicense() {
        License license = new License();
        license.setType("CAR");
        license.setValidFrom(new Date());
        license.setValidTo(new Date());

        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setAge(35);

        license.setPerson(person);
        licenseRepository.save(license);
    }
}