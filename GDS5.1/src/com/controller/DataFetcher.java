package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

public class DataFetcher {

	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private Connection connect = null;

	private static final String USER = "clarence";
	private static final String PASS = "hawaii97";

	public DataFetcher() {
		try {
			// This will load the MySQL driver, each DBMS has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			this.connect = DriverManager
					.getConnection("jdbc:mysql://gds3-0.cemshgppnxt2.us-east-2.rds.amazonaws.com/gds3", USER, PASS);
		} catch (Exception e) {
			// TODO: Needs to redirect to error page
			e.printStackTrace();
		}
	}

	public ResultSet fetchEmp(String username, String password) {
		
		try {
			preparedStatement = connect.prepareStatement("select e.* from Employee e where e.empId = ?");
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	/**
	 * Inserts a new Employee into the Employee table.
	 * @param empId A string literal specifying the new Employee's employee ID
	 * @param empPw A string literal specifying the new Employees's password
	 * @param name A string literal specifying the new Employee's name
	 * @param empType A string literal specifying the new Employee's type
	 */
	public void insertEmployee(String empId, String empPw, String name, int empType) {
		try {
			preparedStatement = connect.prepareStatement("insert into Employee values "
									+ "(?, ?, ?, ?)");
			preparedStatement.setString(1, empId);
			preparedStatement.setString(2, empPw);
			preparedStatement.setString(3, name);
			preparedStatement.setInt(4, empType);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Updates an existing Employee located by employee Id. 
	 * @param oldEmpId String literal specifying the old Id of the employee
	 * @param newEmpId String literal specifying the new Id of the employee
	 * @param newPassword String literal specifying the new password of the employee
	 * @param newName String literal specifying the new name of the employee
	 * @param newEmpType String literal specifying the new designation of the employee
	 */
	public void updateEmployee(String oldEmpId, String newEmpId, String newPassword, 
								String newName, int newEmpType) {
		try {
			preparedStatement = connect.prepareStatement("update Employee set empId = ?, "
									+ "passwd = ?, name = ?, empType = ? where empId = ?");
			preparedStatement.setString(1, newEmpId);
			preparedStatement.setString(2, newPassword);
			preparedStatement.setString(3, newName);
			preparedStatement.setInt(4, newEmpType);
			preparedStatement.setString(5, oldEmpId);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the resulSet of performing an SQL query on a Customer
	 * by their email and password.
	 * @param email A string literal specifying the Customer's email
	 * @param password A string literal specifying the Customer's password
	 * @return ResultSet The results of the query
	 */
	public ResultSet fetchCustomer(String email, String password) {
		try {
			preparedStatement = connect.prepareStatement("select c.* from Customer c where c.email = ? "
														+ " and passwd = ?");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	/**
	 * Inserts a new Customer into the Customer table.
	 * @param email A string literal specifying the new Customer's email
	 * @param password A string literal specifying the new Customer's password
	 * @param name A string literal specifying the new Customer's name
	 * @param cartId A string literal specifying the new Customer's cartId
	 */
	public void insertCustomer(String email, String password, String name, 
								String cartId, String address) {
		try {
			preparedStatement = connect.prepareStatement("insert into Customer values "
									+ "(?, ?, ?, ?, ?)");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, name);
			preparedStatement.setString(4, cartId);
			preparedStatement.setString(5, address);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Updates an existing Customer located in the Customer table (located by email).
	 * @param oldEmail A string literal specifying the Customer's email
	 * @param newEmail A string literal specifying the new Customer's email
	 * @param newPassword A string literal specifying the new Customer's password
	 * @param newName A string literal specifying the new Customer's name
	 * @param newCartId A string literal specifying the new Customer's cartId
	 * @param newAddress
	 */
	public void updateCustomer(String oldEmail, String newEmail, String newPassword, 
								String newName, String newCartId, String newAddress) {
		try {
			preparedStatement = connect.prepareStatement("update Customer set email = ?, "
									+ "passwd = ?, name = ?, cartId = ?, address = ? where email = ?");
			preparedStatement.setString(1, newEmail);
			preparedStatement.setString(2, newPassword);
			preparedStatement.setString(3, newName);
			preparedStatement.setString(4, newCartId);
			preparedStatement.setString(5, oldEmail);
			preparedStatement.setString(6, newAddress);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns all data fields from the Carts table and the price
	 * of each matching item from the Grocery table in the GDS Database
	 * that matches the specified cartId.
	 * @param cartId A string literal representing the cart id
	 * @param email A string literal representing the customer's email
	 * @return ResultSet the resulset of the SQL query
	 */
	public ResultSet fetchCart(String cartId) {
		try {
			preparedStatement = connect.prepareStatement("select sc.*, g.price from Carts sc, Grocery g"
									+ " where sc.cartId = ? and sc.itemId = g.itemId");
			preparedStatement.setString(1, cartId);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	/**
	 * Returns a specified item from a shopping cart.
	 * @param cartId String literal specifying the cart Id
	 * @param itemId String literal spedcifying the itemID
	 * @return resultSet A resultSet of the SQL query
	 */
	public ResultSet fetchCartItem(String cartId, String itemId) {
		try {
			preparedStatement = connect.prepareStatement("select sc.*, g.price from Carts sc, Grocery g "
									+ "where sc.cartId = ? and sc.itemId = ? "
									+ "sc.itemId = g.itemId");
			preparedStatement.setString(1, cartId);
			preparedStatement.setString(2, itemId);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	/**
	 * Inserts a new cart item into the GDS database.
	 * @param cartId A string literal specifying the new cartId
	 * @param email A string literal specifying the email address
	 * @param itemId A string literal specifying item id
	 * @param quantity Integer value specifying the quantity of the item
	 */
	public void insertCart(String cartId, String email, String itemId, int quantity) {
		try {
			preparedStatement = connect.prepareStatement("insert into Carts values "
									+ "(?, ?, ?, ?)");
			preparedStatement.setString(1, cartId);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, itemId);
			preparedStatement.setInt(4, quantity);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Removes an item from a specified cart.
	 * @param cartId String literal specifying the cart to remove from
	 * @param itemId String literal specifying the item to remove from the cart
	 */
	public void removeCartItem(String cartId, String itemId) {
		try {
			preparedStatement = connect.prepareStatement("delete from Carts "
						+ "cartId = ? and itemId = ?");
			preparedStatement.setString(1, cartId);
			preparedStatement.setString(2,  itemId);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
	
	/**
	 * Returns all fields from the Grocery table in the GDS database.
	 * @return ResultSet the results of the SQL query
	 */
	public ResultSet fetchGroceryList() {
		try {
			preparedStatement = connect.prepareStatement("select * from Grocery");
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public ResultSet fetchGroceryItem(String itemId) {
		try {
			preparedStatement = connect.prepareStatement("select g.* from Grocery g "
								+ "where g.itemId = ?");
			preparedStatement.setString(1, itemId);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	/**
	 * Decrements the specified Grocery quantity by 1
	 * @param itemId A string literal representing the item ID
	 * @return A resultSet of the query
	 */
	public ResultSet decrementGroceryItem(String itemId, int amount) {
		try {
			preparedStatement = connect.prepareStatement("Update Grocery "
							+ " set quantity = IF(quantity >= ?, quantity - ?, quantity) "
							+ " where itemId = ?");
			preparedStatement.setInt(1, amount);
			preparedStatement.setInt(2, amount);
			preparedStatement.setString(3, itemId);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	/**
	 * Inserts a new Grocery item into the Grocery Table.
	 * @param itemId A string literal specifying the new Grocery item ID
	 * @param description A string literal specifying the description of the new item
	 * @param lastDt A string literal specifying the date the item was last updated
	 * @param quantity An integer value specifying the availability of the item
	 * @param price A double value specifying the price of the item
	 * @param area A string literal specifying the area the item belongs to
	 */
	public void insertGrocery(String itemId, String name, String description, String lastDt, 
								int quantity, double price, String area) {
		try {
			preparedStatement = connect.prepareStatement("insert into Grocery values "
									+ "(?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, itemId);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, description);
			preparedStatement.setString(4, lastDt);
			preparedStatement.setInt(5, quantity);
			preparedStatement.setDouble(6, price);			
			preparedStatement.setString(7, area);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Updates an existing Grocery item in the Grocery Table (located by itemId).
	 * @param oldItemId A string literal specifying the Grocery item's current id
	 * @param newItemId A string literal specifying the Grocery item's new id
	 * @param newDescription A string literal specifying the Grocery item's new description
	 * @param newLastDt A string literal specifying the Grocery item's last update
	 * @param newQuantity An integer value specifying the Grocery item's new availability
	 * @param newPrice A double value specifying the Grocery item's new price
	 * @param newArea A string literal specifying the Grocery item's new area
	 */
	public void updateGrocery(String oldItemId, String newItemId, String newName, String newDescription,
						Date newLastDt, int newQuantity, double newPrice, String newArea) {
		try {
			preparedStatement = connect.prepareStatement("update Grocery "
									+ "set itemId = ?, name = ?, description = ?, lastDt = ?, "
									+ "quantity = ?, price = ?, area = ? where itemId = ?");
			
			preparedStatement.setString(1, newItemId);
			preparedStatement.setString(2, newName);
			preparedStatement.setString(3, newDescription);
			preparedStatement.setDate(4, newLastDt);
			preparedStatement.setInt(5, newQuantity);
			preparedStatement.setDouble(6, newPrice);			
			preparedStatement.setString(7, newArea);
			preparedStatement.setString(8, oldItemId);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
