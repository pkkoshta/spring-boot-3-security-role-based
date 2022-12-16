package com.prashant.service;

import com.prashant.entity.Products;

import java.util.List;

public interface ProductService {

    public List<Products> products();

    Products createProduct(Products products);

    void deleteProduct(int id);

    Products updateProduct(int pid, Products products);


}
