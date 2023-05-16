package com.ecommerce.dao;

import com.ecommerce.Model.myOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<myOrder,Integer> {
}
