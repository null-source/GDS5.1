package application.model;
import java.util.*;

public class Order {

	private String status;				//placed, gathered, completed
	private String customerName; 		    //shopping cart will be within customer
	private String orderId;				//orderId...
	private ArrayList<Grocery> items;	//items in the order
	
	public Order(ArrayList<Grocery> cart, String customer) {
		this.items = cart;
		this.customerName = customer;
		
	}
	
	public Order(ArrayList<Grocery> cart, String customer, String orderId) {
		this.items = cart;
		this.customerName = customer;
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;

	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomer(String customer) {
		this.customerName = customer;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public ArrayList<Grocery> getItems() {
		return items;
	}

	public void setItems(ArrayList<Grocery> items) {
		this.items = items;
	}
	
	public String toString() {
		String orderString = this.orderId + " " + this.customerName + " " + this.items;
		return orderString;
		
	}
}
