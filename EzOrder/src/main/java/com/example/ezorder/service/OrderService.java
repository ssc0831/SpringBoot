package com.example.ezorder.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ezorder.model.Member;
import com.example.ezorder.model.OrderCount;
import com.example.ezorder.model.OrderInfo;
import com.example.ezorder.model.Shop;
import com.example.ezorder.repository.OrderCountRepository;
import com.example.ezorder.repository.OrderInfoRepository;
import com.example.ezorder.repository.ShopRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	private final OrderCountRepository orderCountRepository;
	private final OrderInfoRepository orderInfoRepository;
	
	//주문 번호 생성, 주문 정보 입력
	public void save(OrderInfo orderInfo) {
		OrderInfo nowOrderInfo=orderInfoRepository.save(orderInfo);
		for(OrderCount orderCount : orderInfo.getOrderList()) {
			OrderCount o = new OrderCount(orderCount.getMenu(), orderCount.getCount(),nowOrderInfo);
			orderCountRepository.save(o);
		}
	}
	
	//최신(가장 주문번호가 큰)순서대로 정렬해서 memberName기준으로 주문내역 불러오기
	public List<OrderInfo> findByMemberId(Member member){
		
		return orderInfoRepository.findByMemberOrderByOrderIdDesc(member);
	}
	public List<OrderInfo> findByShopId(Shop shop){
		return orderInfoRepository.findByShopOrderByOrderIdDesc(shop);
	}
	@Transactional
	public void updateOrderStatus(long orderId) {
		OrderInfo orderInfo = orderInfoRepository.findById(orderId).get();
		orderInfo.setOrderStatus("주문완료");
	}
	
}
