package com.ecommerce.dao;

import com.ecommerce.Model.MyCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyCartRespository extends JpaRepository<MyCart,Integer> {
}
