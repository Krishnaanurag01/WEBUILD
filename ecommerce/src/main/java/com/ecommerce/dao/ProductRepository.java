package com.ecommerce.dao;

import com.ecommerce.Model.Product;
import com.ecommerce.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("select p from Product p where p.category = :category")
    public List<Product> getProductByCategory(@Param("category") String category) ;
}
