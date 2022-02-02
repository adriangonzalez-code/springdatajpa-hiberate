package com.smoothiemx.springdatajpa.findermethods.app;

import com.smoothiemx.springdatajpa.findermethods.app.entities.Product;
import com.smoothiemx.springdatajpa.findermethods.app.repos.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class FinderMethodsApplicationTests {

    @Autowired
    ProductRepository repository;

    @Test
    void testCreateMultiples() {
        List<Product> products = Arrays.asList(
                new Product(1L, "IWatch", "From Apple Inc.", 400d),
                new Product(2L, "TV", "From Samsung Inc.", 1000d),
                new Product(3L, "Washer", "From LG Inc.", 2000d),
                new Product(4L, "Dryer", "From LG Inc.", 1500d)
        );

        repository.saveAll(products);
    }

    @Test
    void testFindByName() {
        List<Product> products = repository.findAllByName("IWatch");
        products.forEach(p -> System.out.println(p.getPrice()));
    }

    @Test
    void testFindByPriceGraterThan() {
        List<Product> products = repository.findAllByPriceGreaterThan(500d);
        products.forEach(p -> System.out.println(p.getName()));
    }
}