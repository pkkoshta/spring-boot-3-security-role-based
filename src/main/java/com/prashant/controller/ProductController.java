package com.prashant.controller;

import com.prashant.entity.Products;
import com.prashant.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int pid){
        productService.deleteProduct(pid);
    }

    @PutMapping("/{id}")
    public Products edit(@PathVariable int id, @RequestBody Products products){
        return productService.updateProduct(id, products);
    }

    @PostMapping
    public Products createProduct(@RequestBody Products products){
        return productService.createProduct(products);
    }

    @GetMapping("/getAll")
    public List<Products> productsList(){
        return productService.products();
    }


}
