package com.example.demoTESTproject.repository;

import com.example.demoTESTproject.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {

    // Jpa에서 기본적으로 작성한 SELECT, INSERT, UPDATE, DELETE 사용한다.


}
