package com.smoothiemx.simplecrud.app;

import com.smoothiemx.simplecrud.app.entities.Product;
import com.smoothiemx.simplecrud.app.repos.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SimpleCrudApplicationTests {

    @Autowired
    private ProductRepository repository;

    @Test
    void contextLoads() {
    }

    @Test
    void testCreate() {
        Product product = new Product();
        product.setId(3);
        product.setName("Sony Walkman");
        product.setDesc("Listen music");
        product.setPrice(5484d);

        repository.save(product);
    }

    @Test
    void testRead() {
        Product product = repository.findById(3).get();
        System.out.print(">>>>>>>>>>: " + product);
    }

    @Test
    void testUpdate() {
        Product product = repository.findById(2).get();
        product.setPrice(1200d);
        repository.save(product);

        Product newProduct = repository.findById(2).get();
        System.out.println(">>>>>>>>: " + product);
    }

    @Test
    void testDelete() {
        if (repository.existsById(4)) {
            repository.deleteById(4);
        }
    }

    @Test
    void testCount() {
        System.out.println(">>>>>>>> Total records: " + repository.count());
    }
}