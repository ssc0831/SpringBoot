package com.example.ezprder.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
public class OrderInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	private String orderStatus;
	@OneToMany(mappedBy = "orderInfo",cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("orderInfo")
	private List<OrderCount> orderList = new ArrayList<>();
	@ManyToOne
	@JoinColumn(name = "shopid")
	private Shop shop;
	@OneToOne
	@JoinColumn(name = "memberid")
	private Member member;
	private int totPrice;
	public OrderInfo() {
    }
	public OrderInfo(OrderInfo orderInfo) {
		orderStatus = orderInfo.getOrderStatus();
	}
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@CollectionTable(name="order_item_mapping",
//			joinColumns = {@JoinColumn(name="order_id",referencedColumnName = "id")})
//	@MapKeyJoinColumn(name="menu_id")
//	private Map<Menu, Double> orderItem;
	

}
