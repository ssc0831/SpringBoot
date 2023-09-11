package com.example.ezorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ezorder.model.OrderCount;

public interface OrderCountRepository extends JpaRepository<OrderCount, Long> {

}
