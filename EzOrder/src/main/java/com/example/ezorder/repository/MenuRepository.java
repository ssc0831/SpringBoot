package com.example.ezorder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ezorder.model.Menu;
import com.example.ezorder.model.Shop;

public interface MenuRepository extends JpaRepository<Menu, Long> {
	List<Menu> findByShop(Shop shop);
}
