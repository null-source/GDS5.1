package application.model;
import java.util.ArrayList;

/***
 * 
 * @author Null
 *
 */

public class ShoppingCart {
	
	/** The shopping cart ID */
	private String cartId;
	
	/** An ArrayList of Grocery items */
	private ArrayList<Grocery> cart;
	
	
	/**
	 * Contructs a new ShoppingCart Object consisting of
	 * a cart ID and a cart.
	 * @param cartId A shopping cart ID
	 * @param cart An ArrayList of Grocery ITems
	 */
	public ShoppingCart(String cartId, ArrayList<Grocery> cart) {
		this.cartId = cartId;
		this.cart = cart;
	}
	
	/**
	 * Contructs a new ShoppingCart Object consisting of a 
	 * cart id and an empty cart.
	 * @param cart An ArrayList of Grocery ITems
	 */
	public ShoppingCart(String cartId) {
		this(cartId, new ArrayList<Grocery>());
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
	
	
	
}
