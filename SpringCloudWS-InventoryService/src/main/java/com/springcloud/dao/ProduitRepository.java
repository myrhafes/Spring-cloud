package com.springcloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcloud.entities.Product;

@Repository
public interface ProduitRepository extends JpaRepository<Product, Long> {

}
