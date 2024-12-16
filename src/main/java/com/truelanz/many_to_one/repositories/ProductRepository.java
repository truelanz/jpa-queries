package com.truelanz.many_to_one.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.truelanz.many_to_one.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p FROM Product p JOIN FETCH p.categories")
    List<Product> searchAll();
}
