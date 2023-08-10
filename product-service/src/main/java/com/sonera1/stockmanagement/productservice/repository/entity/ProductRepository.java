package com.sonera1.stockmanagement.productservice.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Product getByProductIdAndDeletedFalse(Long productId); // from productId goto DB and take Database

    List<Product> getAllByDeletedFalse(); // is deleted false all pull database

}
