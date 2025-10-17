package com.thejoeun.shopping.theMall.controller;

import com.thejoeun.shopping.theMall.model.Products;
import com.thejoeun.shopping.theMall.repository.ProductsRepository;
import com.thejoeun.shopping.theMall.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JsonController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/products/all")
    public List<Products> findAll(){
        return productsService.findAll();
    }

}
