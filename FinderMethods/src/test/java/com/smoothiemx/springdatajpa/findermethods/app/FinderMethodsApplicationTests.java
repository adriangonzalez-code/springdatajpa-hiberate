package com.smoothiemx.springdatajpa.findermethods.app;

import com.smoothiemx.springdatajpa.findermethods.app.entities.Product;
import com.smoothiemx.springdatajpa.findermethods.app.repos.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class FinderMethodsApplicationTests {

    @Autowired
    ProductRepository repository;

    @Test
    void testCreateMultiples() {
        List<Product> products = Arrays.asList(
                new Product(1, "IWatch", "From Apple Inc.", 400d),
                new Product(2, "TV", "From Samsung Inc.", 1000d),
                new Product(3, "Washer", "From LG Inc.", 2000d),
                new Product(4, "Dryer", "From LG Inc.", 1500d)
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

    @Test
    void testFindByNameAndDesc() {
        List<Product> products = repository.findAllByNameAndDesc("TV", "From Samsung Inc.");
        products.forEach(p -> System.out.println(p.getPrice()));
    }

    @Test
    void testFindByDescContains() {
        List<Product> products = repository.findByDescContains("Apple");
        products.forEach(p -> System.out.println(p.getName()));
    }

    @Test
    void testFindByPriceBetween() {
        List<Product> products = repository.findByPriceBetween(500d, 2500d);
        products.forEach(p -> System.out.println(p.getName()));
    }

    @Test
    void testFindByDescLike() {
        List<Product> products = repository.findByDescLike("%LG%");
        products.forEach(p -> System.out.println(p.getName()));
    }

    @Test
    void testFindByIdIn() {
        List<Product> products = repository.findByIdIn(Arrays.asList(1,2,3));
        products.forEach(p -> System.out.println(p.getName()));
    }
}