package application.model;
import java.util.*;

public class Order {

	private String status;				//newOrder, gatheringItems, onRoute, completed
	private Customer customer; 		    //shopping cart will be within customer
	private String orderId;				//orderId...
	private ArrayList<Grocery> items;	//items in the order
	
	public Order(ArrayList<Grocery> cart, Customer customer) {
		this.items = cart;
		this.customer = customer;
		
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
		
		if (this.status.equals("completed")) {
			this.customer.setCurrentOrder(null);
		}
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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
}
