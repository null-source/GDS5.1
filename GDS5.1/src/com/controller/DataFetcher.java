package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.model.*;
import java.util.ArrayList;
import java.util.Date;

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
	
	public ResultSet fetchCustomer(String email, String password) {
		try {
			preparedStatement = connect.prepareStatement("select c.* from Customer c where c.email = ?");
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	/**
	 * Returns all data fields from the Carts table in the GDS Database
	 * that match the specified cartId and customer email.
	 * @param cartId A string literal representing the cart id
	 * @param email A string literal representing the customer's email
	 * @return ResultSet the resulset of the SQL query
	 */
	public ResultSet fetchCart(String cartId, String email) {
		try {
			preparedStatement = connect.prepareStatement("select sc.* from Carts sc where sc.cartId = ?"
															+ "and sc.email = ?");
			preparedStatement.setString(1, cartId);
			preparedStatement.setString(2, email);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	/**
	 * Returns all fields from the Grocery table in the GDS database.
	 * @return ResultSet the results of the SQL query
	 */
	public ResultSet fetchList() {

		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from Grocery");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

}
