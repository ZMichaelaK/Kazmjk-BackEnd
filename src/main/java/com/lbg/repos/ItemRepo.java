package com.lbg.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.domain.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {

}
