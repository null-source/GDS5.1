package application.model;
import java.util.ArrayList;

/***
 * 
 * @author Null
 *
 */

public class ShoppingCart {
	
	private static String cartId;					//Cart ID for each ShoppingCart
	private ArrayList<Grocery> cart;		//ArrayList containing Grocery objects
	private String status;					//inProcess, paid
	
	
	/**
	 * Contructs a new ShoppingCart Object consisting of
	 * a cart ID and a cart.
	 * @param cartId A shopping cart ID
	 * @param cart An ArrayList of Grocery ITems
	 */
	public ShoppingCart(ArrayList<Grocery> cart) {
		this.status = "inProcess";
		this.cart = cart;
	}
	
	/**
	 * Contructs a new ShoppingCart Object consisting of a 
	 * cart id and an empty cart.
	 * @param cart An ArrayList of Grocery ITems
	 */
	public ShoppingCart(String cartId) {
		this.cart = getCart(cartId);
	}
	
	/**
	 * Returns the cart id for this shopping cart
	 * @return A string literal representing the shopping cart ID
	 */
	public String getCartId() {
		return this.cartId;
	}
	
	/**
	 * Returns an arrayList of Grocery Objects.
	 * @return
	 */
	public ArrayList<Grocery> getCart(){
		return this.cart;
	}
	
	public void setCart(ArrayList<Grocery> newCart) { 
		cart = newCart;
	}
	

	
	/**
	 * Returns a string representations of this ShoppingCart
	 * @return A string literal value
	 */
	public String toString() {
		String result = this.cartId + ":\n";
		for(Grocery current: this.cart)
			result += current.toString() + "\n";
		return result;
	}
	
	/**
	 * Method to be used for .jsp files to display the user's Shopping Cart
	 * to them. 
	 * 
	 * @return An ArrayList containing arrays with an item's name, price, 
	 * 			and quantity. 
	 */
	public ArrayList<String[]> displayShoppingCart() {
		
		//Convert the shopping cart into Strings to be displayed
		ArrayList<String[]> shoppingCart = new ArrayList<String[]>();
		
		//Create an array containing item name, price, and quantity. 
		for (Grocery g: cart) {
			String[] item = {g.getName(), Double.toString(g.getPrice()), Integer.toString(g.getQuantity())};
			shoppingCart.add(item);
		}
		
		return shoppingCart;
	}
	
	/**
	 * 
	 * @param grocery
	 * @param quantity
	 */

	
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
}
