package com.controller;

import java.sql.ResultSet;

/**
 * EmpHandle handles any requested data from the CustomerLogin controller
 * and process data retrieved from DataFetcher. Any information from CustomerLogin
 * will be passed into DataFetcher and DataFetcher pull information from
 * the database. EmpHandle sends codes (ints) or objects based on what
 * the CustomerLogin controller is asking for.
 * 
 * @author Clarence Bumanglag
 *
 */
public class Handle {
	
	private ResultSet resultSet = null;
	
	/**
	 * 
	 * empExist() processes raw data fetched from the database and 
	 * checks to see if the processed data matches the data requested
	 * by the controller.
	 * 
	 * @param username of potential employee ID
	 * @param password of potential employee ID
	 * @param type Integer value used to determine if an employee or customer
	 * 		  data should be fetched (0 == Employee, Everything else == Customer)
	 * @return
	 * 
	 * 		-2 if the Employee ID does not exist
	 * 		-1 if the Employee ID was found, but the password was incorrect
	 * 		0 if the Employee exists and is of type "Manager", or if the Customer exists
	 * 		1 if the Employee exists and is of type "Maintainer"
	 * 		2 if the Employee exists and is of type "Shopper"
	 * 		3 if the Employee exists and is of type "Driver"
	 */
	public int userExist(String username, String password, int type) {
		
		//Local variables for login testing
		DataFetcher data = new DataFetcher();
		String rUser = null, rPass = null; //buffers for data from the database
		int value = -2; //return value
		
		if(type == 0) {
			resultSet = data.fetchEmp(username, password);
		}else {
			resultSet = data.fetchCustomer(username, password);
		}
		
		// Main testing for database information processing
		try {
			
			resultSet.next();	//next column for process (current position is the header of the table)
			
			rUser = resultSet.getString(1);	// username from the database
			rPass = resultSet.getString(2);	// password from the database
			
			/*
			 * Tests to see if the username from the controller matches the username
			 * from the database. Sets 'value' to -2 if username does not exist
			 */
			if (rUser.equals(username)) {
				
				/*
				 * Tests to see if the password matches with the specified username. 
				 * 'Value' is set to -1 if the passwords do not match. 'Value' is
				 * set to the Employee type if the credentials are valid
				 */
				if (rPass.equals(password)) {
					if (type == 0) {
						value = resultSet.getInt(4);	//Employee type
					}else {
						value = 0;   //Customer return value (Shane: 0 in the event I break the employee login)
		 			}
				}
				else {
					value = -1; //Invalid Credentials
				}
			} else {
				value = -2;	//User not found
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Return statement
		return value;
	}
	
	public int createCustomer(String email, String fullname, String password) {
		return 0;
	}
}
