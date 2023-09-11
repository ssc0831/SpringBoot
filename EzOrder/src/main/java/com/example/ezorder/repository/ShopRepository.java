package com.example.ezorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ezorder.model.Shop;
import com.example.ezorder.model.User;

public interface ShopRepository extends JpaRepository<Shop, Long> {
	Shop findByUser(User user);

}
