package com.lbg.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.domain.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer> {

}
