package com.ecommerce.dao;

import com.ecommerce.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRespository extends JpaRepository<User,Integer> {
    @Query ("select u from User u where u.email = :email")
    public User getUserByUsername(@Param("email") String email) ;
}
