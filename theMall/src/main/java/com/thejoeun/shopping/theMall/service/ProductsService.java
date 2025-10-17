package com.thejoeun.shopping.theMall.service;

import com.thejoeun.shopping.theMall.model.Products;
import com.thejoeun.shopping.theMall.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    public List<Products> findAll() {
        return productsRepository.findAll();
    }
}
