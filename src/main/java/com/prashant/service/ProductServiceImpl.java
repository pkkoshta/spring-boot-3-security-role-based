package com.prashant.service;

import com.prashant.dao.ProductDao;
import com.prashant.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Products> products() {
        return productDao.findAll();
    }

    @Override
    public Products createProduct(Products products) {
        return productDao.save(products);
    }

    @Override
    public void deleteProduct(int id) {
        productDao.deleteById(id);
    }

    @Override
    public Products updateProduct(int pid, Products products) {
        Optional<Products> optionalProduct = productDao.findById(pid);
        if (optionalProduct.isPresent()){
            Products products1 = optionalProduct.get();
            products1.setName(products.getName());
            products1.setDesc(products.getDesc());
           // products1.setCategorys(products.getCategorys());
            products1.setImageUrl(products.getImageUrl());
/*
            product1.setProductPrice(product.getProductPrice());
*/
            return productDao.save(products1);
        }
        return null;
    }
}
