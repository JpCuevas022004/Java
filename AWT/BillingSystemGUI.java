package AWT;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BillingSystemGUI extends JFrame{

	// to declare a serialVersionUID field in the class
	private static final long serialVersionUID = 1L;
	private JList<Product> productList; // to display the list of the products
	    private DefaultListModel<Product> productListModel; // to manage the products in the list
	    private JButton addButton; //adding
	    private JButton removeButton; // removing
	    private JButton generateBillButton; // generating bill actions
	    private JLabel totalLabel; // to display the total amount of the bill

	    private Bill bill; // represents the bill and manages the list of products

	    public BillingSystemGUI() {
	        super("Billing System");

	        bill = new Bill();
	        productListModel = bill.getProducts();
	        productList = new JList<>(productListModel);
	        addButton = new JButton("Add Product");
	        removeButton = new JButton("Remove Product");
	        generateBillButton = new JButton("Generate Bill");
	        totalLabel = new JLabel("Total: $0.00");

	        setLayout(new BorderLayout());
	        add(new JScrollPane(productList), BorderLayout.CENTER);

	        JPanel buttonPanel = new JPanel();
	        buttonPanel.add(addButton);
	        buttonPanel.add(removeButton);
	        buttonPanel.add(generateBillButton);
	        add(buttonPanel, BorderLayout.SOUTH);

	        JPanel totalPanel = new JPanel();
	        totalPanel.add(totalLabel);
	        add(totalPanel, BorderLayout.NORTH);
      
	        //  opens a dialog to enter details of a new product
	        addButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                showAddProductDialog();
	            }
	        });

	        // removes the selected product from the list
	        removeButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                int selectedIndex = productList.getSelectedIndex();
	                if (selectedIndex != -1) {
	                    bill.removeProduct(selectedIndex);
	                    updateTotalLabel();
	                }
	            }
	        });

	        // displays a dialog with the generated bill
	        generateBillButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                generateBill();
	            }
	        });

	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(400, 300);
	        setLocationRelativeTo(null);
	        setVisible(true);
	    }

	    // creates a dialog with input fields for the name, price, and quantity of a new product
	    private void showAddProductDialog() {
	        JTextField nameField = new JTextField(); 
	        JTextField priceField = new JTextField();
	        JTextField quantityField = new JTextField();

	        JPanel panel = new JPanel(new GridLayout(0, 1));
	        panel.add(new JLabel("Product Name:"));
	        panel.add(nameField);
	        panel.add(new JLabel("Price:"));
	        panel.add(priceField);
	        panel.add(new JLabel("Quantity:"));
	        panel.add(quantityField);
	        

	        // when the user clicks OK, the input values are retrieved, a new Product object is created, added to the productListModel, and the total label is updated 
	        int result = JOptionPane.showConfirmDialog(null, panel, "Add Product",
	                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

	        if (result == JOptionPane.OK_OPTION) {
	            String name = nameField.getText();
	            double price = Double.parseDouble(priceField.getText());
	            int quantity = Integer.parseInt(quantityField.getText());

	            Product product = new Product(name, price, quantity);
	            bill.addProduct(product);
	            updateTotalLabel();
	        }
	    }

	    // calculates the total amount of the bill using the calculate() method of the bill instance and updates the total label with the formatted total value
	    private void updateTotalLabel() {
	        double total = bill.calculateTotal();
	        totalLabel.setText("Total: $" + String.format("%.2f", total));
	    }

	    // generates a textual representation of the bill, including product details and the total amount, and displays it in a message dialog
	    private void generateBill() {
	        StringBuilder billText = new StringBuilder();
	        billText.append("========== Bill ==========\n");

	        for (int i = 0; i < productListModel.size(); i++) {
	            Product product = productListModel.elementAt(i);
	            double price = product.getPrice();
	            int quantity = product.getQuantity();
	            double subtotal = price * quantity;

	            billText.append(product.getName()).append(" - $").append(price).append(" x ")
	                    .append(quantity).append(" = $").append(subtotal).append("\n");
	        }

	        billText.append("==========================\n");
	        billText.append("Total: $").append(String.format("%.2f", bill.calculateTotal()));

	        JOptionPane.showMessageDialog(this, billText.toString(), "Bill", JOptionPane.INFORMATION_MESSAGE);
	    }

}
