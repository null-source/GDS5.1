package application.model;

import java.util.*;

public class Customer {
	
	private String email;
	private String fullname;
	private String password;
	private ArrayList<Grocery> cart;
	private Order currentOrder;
	private String paymentInfo;
	private String deliveryInfo;
	
	/**
	 * Create a new customer object by registering for an account. 
	 * @param email			Customer's email
	 * @param fullname		Customer's full name
	 * @param password		Custmomer's password
	 */
	public Customer(String email, String fullname, String password) {
		this.email = email;
		this.fullname = fullname;
		this.password = password;
		
		
	}

	/**
	 * Create a new customer object by adding to the shopping cart without registering
	 * for an account. 
	 * 
	 * @param items			A shopping cart to add to the customer
	 */
	public Customer(ArrayList<Grocery> items) {
		this.cart = items;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Grocery> getCart() {
		return cart;
	}

	public void setCart(ArrayList<Grocery> cart) {
		this.cart = cart;
	}

	public String getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public String getDeliveryInfo() {
		return deliveryInfo;
	}

	public void setDeliveryInfo(String deliveryInfo) {
		this.deliveryInfo = deliveryInfo;
	}
	
	/**
	 * Returns the total price this shopping cart.
	 * @return A double value representing the total price of the cart
	 */
	public double getTotal() {
		double price = 0;
		for(Grocery current: this.cart)
			price += current.getPrice();
		return price;
	}
	
	public void removeFromShoppingCart(Grocery grocery, int quantity) {
		int index = containsName(grocery.getName());
		
		//Remove the item entirely
		if (cart.get(index).quantity <= quantity) {
			cart.remove(index);
		} else { //update the quantity
			cart.get(index).setQuantity( cart.get(index).quantity - quantity);
		}
	}
	
	public void addToShoppingCart(Grocery grocery, int quantity) {
		
		int inCart = containsName(grocery.getName());
		
		//If the item is in the cart already, update the quantity
		if (inCart >= 0) {
			cart.get(inCart).setQuantity( cart.get(inCart).quantity + quantity);		
		} else { //If not, add it to the cart
			cart.add(grocery);
		}
	}

	private int containsName(String name) {
	
		for(Grocery g: cart) {
			int counter = 0;
			if ( name.equals(g.getName() ) ) {
				return counter;
			}
			counter++;
		}
	return -1;
	}

	public Order getCurrentOrder() {
		return currentOrder;
	}

	public void setCurrentOrder(Order order) {
		this.currentOrder = order;
	}
	
	public void payCart() {
		this.currentOrder = new Order(cart, this);
		this.cart = null;
	}
	
	
	
}
