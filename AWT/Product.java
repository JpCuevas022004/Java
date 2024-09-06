package AWT;

public class Product { 
	private String name; // represents the name of the product
	private double price; // represents the price of the product
	private int quantity; // represents the quantity of the product

	//this class has a constructor that takes three parameters to initialize the instance variables
	public Product(String name, double price, int quantity) {
	  this.name = name; 
	  this.price = price; 
	  this.quantity = quantity; 
	}

    // this class provides getter methods  to retrieve the values of the instance variables
	// to access the value of the product name
	public String getName() {
	  return name;
	}
	// to access the value of the product price                                 
    public double getPrice() {
      return price;
	}
    // to access the value of the product quantity
	public int getQuantity() {
      return quantity;
    }
    // to set the quantity of the product
	public void setQuantity(int quantity) {
	  this.quantity = quantity;
    }
}

