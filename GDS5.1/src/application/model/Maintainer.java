package application.model;


import java.sql.SQLException;
import java.util.ArrayList;
import application.model.Grocery;
import com.controller.ItemHandler;

public class Maintainer extends Employee {

	public Maintainer(String empId, String empPw, String fullName, int empType) {
		super(empId, empPw, fullName, empType);
	}

	// Returns a string version of the grocery list
	public ArrayList<Grocery> retrieveGroceryTable() {

		ArrayList<Grocery> items = null;
		ItemHandler IH = new ItemHandler();
		
		try {
			items = IH.getInventory();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return items;
		
	}
}
