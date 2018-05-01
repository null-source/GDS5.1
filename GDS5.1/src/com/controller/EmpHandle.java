package com.controller;

import java.sql.ResultSet;

public class EmpHandle {
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public int empExist(String username, String password) {
		DataFetcher data = new DataFetcher();
		ResultSet resultSet = data.fetchEmp(username, password);
		String rUser = null, rPass = null;
		int value = 0;
		
		try {
			resultSet.next();
			rUser = resultSet.getString(1);
			rPass = resultSet.getString(2);
			
			if (rUser.equals(username)) {
				if (rPass.equals(password)) {
					value = resultSet.getInt(4);
				}
				else {
					value = -1;
				}
			} else {
				value = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}
}
