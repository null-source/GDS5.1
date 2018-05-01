package com.controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.model.Grocery;

public class ItemHandler {

	/** used to store the results of database queries */
	private ResultSet resultSet;
	
	/** fetches the data from the GDS database */
	private DataFetcher data;
	
	/**
	 * Constructs a new ItemHandler.
	 */
	public ItemHandler() {
		this.data = new DataFetcher();
		this.resultSet = null;
	}
	
	/**
	 * Returns an ArrayList of Grocery Items located in the GDSDB
	 * @return An ArrayList of Grocery Objects
	 * @throws SQLException
	 */
	public ArrayList<Grocery> getInventory() throws SQLException {
		ArrayList<Grocery> inventory = new ArrayList<Grocery>();
		resultSet = data.fetchGroceryList();
		
		//add tuples in the result set to inventory
		while(resultSet.next()) {			
			inventory.add(new Grocery(resultSet.getString("itemId"), 
					resultSet.getString("name"), resultSet.getString("description"), 
					resultSet.getDouble("price"), resultSet.getInt("quantity"), 
					resultSet.getDate("lastDt"), resultSet.getString("area"), 
					inventory.size()));
		}
		return inventory;
	}
	
	/**
	 * Updates an existing item in the GDS database.
	 * @param oldItemId A string literal representing the item's old Id
	 * @param newItemId A string literal specifying the item's new Id
	 * @param newName A string literal specifying the item's new name
	 * @param newDescription A string literal specifying the item's new description
	 * @param newLastDt A SQL date object specifying the item's new date
	 * @param newQuantity An integer value specifying the item's new quantity
	 * @param newPrice Double value specifying the item's new price
	 * @param newArea String literal specifying the item's new area
	 */
	public void updateItem(String oldItemId, String newItemId, String newName, String newDescription, 
							Date newLastDt, int newQuantity, double newPrice, String newArea) {
		
		data.updateGrocery(oldItemId, newItemId, newName, newDescription, newLastDt, 
							newQuantity, newPrice, newArea);
	}
	
	/** Returns the specified Grocery item from the database, and decrements 
	 *  its quantity by the specified amount.
	 * @param itemId A string literal specifying the items Id.
	 * @param amount An integer representing the amount to decrement
	 * @return A Grocery Object
	 * @throws SQLException
	 */
	public Grocery removeItem(String itemId, int amount) throws SQLException {
		resultSet = data.fetchGroceryItem(itemId);
		int quantity = resultSet.getInt("quantity");
		
		Grocery item = new Grocery(resultSet.getString("itemId"), 
				resultSet.getString("name"), resultSet.getString("description"), 
				resultSet.getDouble("price"), (quantity - amount), 
				resultSet.getDate("lastDt"), resultSet.getString("area"));
		
		//the amount requested to be remove is greater than the current quantity
		if(item.getQuantity() > quantity) {
			data.decrementGroceryItem(itemId, item.getQuantity());	
		}else{ //the requested amount to take is less than the current quantity
			data.decrementGroceryItem(itemId, quantity);
			item.setQuantity(quantity);
		}
		return item;
	}
}
