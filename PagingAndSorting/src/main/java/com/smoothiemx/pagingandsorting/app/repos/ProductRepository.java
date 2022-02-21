package com.smoothiemx.pagingandsorting.app.repos;

import com.smoothiemx.pagingandsorting.app.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

    List<Product> findAllByName(String name);

    List<Product> findAllByNameAndDesc(String name, String desc);

    List<Product> findAllByPriceGreaterThan(Double price);

    List<Product> findByDescContains(String desc);

    List<Product> findByPriceBetween(Double price1, Double price2);

    List<Product> findByDescLike(String desc);

    List<Product> findByIdIn(List<Integer> ids, Pageable pageable);
}