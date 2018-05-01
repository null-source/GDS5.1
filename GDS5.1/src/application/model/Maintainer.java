package application.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import application.model.Inventory;
import com.controller.DataFetcher;

public class Maintainer extends Employee {

	public Maintainer(String empId, String empPw, String fullName, int empType) {
		super(empId, empPw, fullName, empType);
	}

	// Returns a string version of the grocery list
	public ArrayList<String> retrieveGroceryTable() {
		ArrayList<String> groceryTable = new ArrayList<String>();
		Inventory inventory = new Inventory();
		ArrayList<Grocery> groceries = inventory.getInventory();
		for (int i = 0; i < groceries.size(); i++) {
			groceryTable.add(groceries.get(i).toString());
			
		}
		
		return groceryTable;
		
	}
}
