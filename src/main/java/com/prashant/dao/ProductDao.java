package com.prashant.dao;

import com.prashant.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Products, Integer> {
}
