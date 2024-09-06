package AWT;

import javax.swing.DefaultListModel;

// this class represents a bill in the billing system and contains a list of products using a DefaultListModel<Product>
public class Bill {
	private DefaultListModel<Product> products; // represents the list of the products in the bill
	// this class has a constructor that initializes the list using the DefaultListModel class
    public Bill() {
        products = new DefaultListModel<>(); 
    }
   // this class provides an method that adds a product to the list using the addElement() method of DefaultListModel
    public void addProduct(Product product) {
        products.addElement(product);
    }
   // this method removes a product from the list based on the specified index using the remove() method of DefaultListModel
    public void removeProduct(int index) {
        products.remove(index);
    }
  // this method returns the list, allowing external code to retrieve and manipulate the list of products
    public DefaultListModel<Product> getProducts() {
        return products;
    }
  // this method iterates over each product in the list
    public double calculateTotal() {
        double total = 0;
        // retrieves its price and quantity using the getter methods of the Product class
        // calculates the subtotal for each product
        // accumulates the subtotals to calculate the total amount of bill
        for (int i = 0; i < products.size(); i++) {
            Product product = products.elementAt(i); 
            double price = product.getPrice();
            int quantity = product.getQuantity();
            double subtotal = price * quantity;
            total += subtotal;
        }
        // the total amount is the returned
        return total;
    }

}
