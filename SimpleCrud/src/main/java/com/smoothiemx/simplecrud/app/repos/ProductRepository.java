package com.smoothiemx.simplecrud.app.repos;

import com.smoothiemx.simplecrud.app.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}