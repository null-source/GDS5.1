package com.controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.model.Grocery;

public class CartHandle {

	/** used to store the results of database queries */
	private ResultSet resultSet;
	
	/** fetches the data from the GDS database */
	private DataFetcher data;
	
	/**
	 * Constructs a new CartHandle object
	 */
	public CartHandle() {
		this.data = new DataFetcher();
		resultSet = null;
	}
	
	public ArrayList<Grocery> getCart(String cartId) throws SQLException{
		resultSet = data.fetchCart(cartId);
		ArrayList<Grocery> cartItems = new ArrayList<Grocery>();
		
		while(resultSet.next()) {			
			String itemId = resultSet.getString("itemId");
			int quantity = resultSet.getInt("quantity");
			ResultSet itemResult = data.fetchGroceryItem(itemId);
			String name = itemResult.getString("name");
			String description = itemResult.getString("description");
			Date lastDt = itemResult.getDate("lastDt");
			double price = itemResult.getDouble("price");
			String area = itemResult.getString("area");
			
			cartItems.add(new Grocery(itemId, name, description, 
						price, quantity, lastDt, area));
		}
		return cartItems;
	}
}
