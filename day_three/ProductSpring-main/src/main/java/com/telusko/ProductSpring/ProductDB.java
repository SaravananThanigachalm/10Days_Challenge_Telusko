package com.telusko.ProductSpring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDB extends JpaRepository<Product, Integer> {

    Product findByName(String s);

    List<Product> findByPlaceContainingIgnoreCase(String place);

    List<Product> findByWarrantyLessThan(int currentYr);

    List<Product> findByNameContainingIgnoreCaseOrTypeContainingIgnoreCaseOrPlaceContainingIgnoreCase(String text1, String text2, String text3);
}
