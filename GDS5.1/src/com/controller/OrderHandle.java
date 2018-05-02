package com.controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import application.model.Order;
import com.controller.CartHandle;
import application.model.Grocery;


public class OrderHandle {
	
	private ResultSet resultSet;
	private DataFetcher data;
	
	public OrderHandle() {
		this.data = new DataFetcher();
		this.resultSet = null;
	}
	
	public ArrayList<Order> getShopperOrders() throws SQLException {
		resultSet = data.fetchOrders("placed");
		ArrayList<Order> currentOrders = new ArrayList<Order>();
		ArrayList<Grocery> items = new ArrayList<Grocery>();
		
		while(resultSet.next()) {
			CartHandle CH = new CartHandle();
			String orderId = resultSet.getString("orderId");
			String customerName = resultSet.getString("name");
			
			items = CH.getCart(resultSet.getString("cartId"));
			
			Order order = new Order(items, customerName);
			order.setOrderId(orderId);
			
			currentOrders.add(order);
		}
		
		return currentOrders;
	}
	
	public ArrayList<Order> getDriverOrders() throws SQLException {
		resultSet = data.fetchOrders("gathered");
		ArrayList<Order> currentOrders = new ArrayList<Order>();
		ArrayList<Grocery> items = new ArrayList<Grocery>();
		
		while(resultSet.next()) {
			CartHandle CH = new CartHandle();
			String orderId = resultSet.getString("orderId");
			String customerName = resultSet.getString("name");
			
			items = CH.getCart(resultSet.getString("cartId"));
			
			Order order = new Order(items, customerName);
			order.setOrderId(orderId);
			
			currentOrders.add(order);
		}
		
		return currentOrders;
	}
	
	public ArrayList<Order> getManagerOrders() throws SQLException {
		resultSet = data.fetchOrders("gathered");
		ResultSet resSet2 = data.fetchOrders("placed");
		ArrayList<Order> currentOrders = new ArrayList<Order>();
		ArrayList<Grocery> items = new ArrayList<Grocery>();
		
		while(resultSet.next()) {
			CartHandle CH = new CartHandle();
			String orderId = resultSet.getString("orderId");
			String customerName = resultSet.getString("name");
			
			items = CH.getCart(resultSet.getString("cartId"));
			
			Order order = new Order(items, customerName);
			order.setOrderId(orderId);
			
			currentOrders.add(order);
			

			orderId = resSet2.getString("orderId");
			customerName = resSet2.getString("name");
			items = CH.getCart(resSet2.getString("cartId"));
			
			Order order2 = new Order(items, customerName);
			order2.setOrderId(orderId);
			
			currentOrders.add(order2);
		}
		
		return currentOrders;
		
	}

}
