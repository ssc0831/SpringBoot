package com.example.ezorder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ezorder.model.Member;
import com.example.ezorder.model.OrderInfo;
import com.example.ezorder.model.Shop;

public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long> {
	List<OrderInfo> findByMemberOrderByOrderIdDesc(Member member);
	List<OrderInfo> findByShopOrderByOrderIdDesc(Shop shop);
}
