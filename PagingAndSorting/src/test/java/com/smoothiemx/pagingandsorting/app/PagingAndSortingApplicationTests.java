package com.smoothiemx.pagingandsorting.app;

import com.smoothiemx.pagingandsorting.app.entities.Product;
import com.smoothiemx.pagingandsorting.app.repos.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class PagingAndSortingApplicationTests {

    @Autowired
    ProductRepository repository;

    @Test
    void contextLoads() {
    }

    @Test
    void testFindAllPaging() {
        Pageable pageable = PageRequest.of(1,2);
        Page<Product> results = repository.findAll(pageable);
        results.forEach(p -> System.out.println(p.getName()));
    }

    @Test
    void testFindAllSorting() {
        Iterable<Product> results = repository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        results.forEach(p -> System.out.println(p.getName()));
    }

    @Test
    void testFindAllSortingMultipleProperties() {
        Iterable<Product> results = repository.findAll(Sort.by(Sort.Direction.DESC, "name", "price"));
        results.forEach(p -> System.out.println(p.getName()));
    }

    @Test
    void testFindAllSortingMultiplePropertiesAndDirection() {
        Iterable<Product> results = repository.findAll(Sort.by(Sort.Order.desc("name"), Sort.Order.by("price")));
        results.forEach(p -> System.out.println(p.getName()));
    }

    @Test
    void testFindAllPagingAndSorting() {
        Pageable pageable = PageRequest.of(0,2, Sort.Direction.DESC,"name");
        Iterable<Product> results = repository.findAll(pageable);
        results.forEach(p -> System.out.println(p.getName()));
    }

    @Test
    void testFindByIdIn() {
        Pageable pageable = PageRequest.of(0,2);
        List<Product> products = repository.findByIdIn(Arrays.asList(1,2,3), pageable);
        products.forEach(p -> System.out.println(p.getName()));
    }
}