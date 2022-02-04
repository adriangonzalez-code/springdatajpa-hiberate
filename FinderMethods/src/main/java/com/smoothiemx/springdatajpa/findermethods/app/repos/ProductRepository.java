package com.smoothiemx.springdatajpa.findermethods.app.repos;

import com.smoothiemx.springdatajpa.findermethods.app.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findAllByName(String name);

    List<Product> findAllByNameAndDesc(String name, String desc);

    List<Product> findAllByPriceGreaterThan(Double price);

    List<Product> findByDescContains(String desc);

    List<Product> findByPriceBetween(Double price1, Double price2);

    List<Product> findByDescLike(String desc);

    List<Product> findByIdIn(List<Integer> ids);
}