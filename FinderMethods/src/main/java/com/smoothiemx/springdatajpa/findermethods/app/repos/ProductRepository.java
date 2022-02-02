package com.smoothiemx.springdatajpa.findermethods.app.repos;

import com.smoothiemx.springdatajpa.findermethods.app.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAllByName(String name);

    List<Product> findAllByNameAndDesc(String name, String desc);

    List<Product> findAllByPriceGreaterThan(Double price);
}