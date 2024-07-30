package com.qrencia.inventoryapp.repository;

import com.qrencia.inventoryapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

     List<Product> findByPriceBetween(Double lower, Double higher);
}
