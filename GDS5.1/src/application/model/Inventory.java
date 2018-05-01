package application.model;

import application.model.Grocery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.controller.DataFetcher;

public class Inventory {
	
	public ArrayList<Grocery> inventory;
	
	public Inventory() {
		
		DataFetcher data = new DataFetcher();
		ResultSet resultSet = data.fetchList();
		
		try {
			while (resultSet.next()) {
	
				Grocery groc = new Grocery(resultSet.getString("itemId"),
										   resultSet.getString("name"), 
										   resultSet.getString("description"), 
										   resultSet.getDouble("price"), 
										   resultSet.getInt("quantity"), 
										   resultSet.getDate("lastDt"),
										   resultSet.getString("area"),   
										   inventory.size());
				inventory.add(groc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public ArrayList<Grocery> getInventory() {
		return this.inventory;
	}
	

	public ArrayList<Grocery> addToInventory(String itemId, String name, String desc, double price, int quantity, Date lastDt2, String area) {
		Grocery grocery = new Grocery(itemId, name, desc, price, quantity, lastDt2, area, inventory.size());
		//TODO: Add logic to add a grocery item to the database
		this.inventory.add(grocery);
		
		return this.inventory;
	}
	

	public ArrayList<Grocery> removeFromInventory(Grocery grocery) {
		
		this.inventory.remove(grocery.index);
		//TODO: Add logic to remove a grocery item from the database
		return this.inventory;
	}
}
