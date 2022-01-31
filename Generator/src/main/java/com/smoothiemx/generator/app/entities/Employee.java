package com.smoothiemx.generator.app.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    //@TableGenerator(name = "employee_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 100)
    //@GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_gen")
    @GenericGenerator(name = "emp_id", strategy = "com.smoothiemx.generator.app.customgenerator.CustomRandomIDGenerator")
    @GeneratedValue(generator = "emp_id")
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}