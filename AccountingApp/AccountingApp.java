package AccountingApp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AccountingApp extends JFrame{
	 private JTable ledgerTable;
	    private DefaultTableModel tableModel;
	    private JTextField dateTextField;
	    private JTextField accountTitleTextField;
	    private JTextField debitTextField;
	    private JTextField creditTextField;
	    private JButton addEntryButton;
	    private JButton saveButton;
	    private JButton loadButton;

	    public AccountingApp() {
	        setTitle("Accounting System");
	        setSize(1000, 1000);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);

	        initializeComponents();
	        addComponentsToFrame();
	    }

	    private void initializeComponents() {
	        String[] columnNames = {"Date", "Account Title", "Debit", "Credit"};
	        tableModel = new DefaultTableModel(columnNames, 0);
	        ledgerTable = new JTable(tableModel);

	        dateTextField = new JTextField(10);
	        accountTitleTextField = new JTextField(20);
	        debitTextField = new JTextField(10);
	        creditTextField = new JTextField(10);
	        addEntryButton = new JButton("Add Entry");
	        saveButton = new JButton("Save");
	        loadButton = new JButton("Load");

	        addEntryButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                addEntry();
	            }
	        });

	        saveButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                saveToFile();
	            }
	        });

	        loadButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                loadFromFile();
	            }
	        });
	    }

	    private void addComponentsToFrame() {
	        JPanel panel = new JPanel(new FlowLayout());

	        panel.add(new JLabel("Date:"));
	        panel.add(dateTextField);
	        panel.add(new JLabel("Account Title:"));
	        panel.add(accountTitleTextField);
	        panel.add(new JLabel("Debit:"));
	        panel.add(debitTextField);
	        panel.add(new JLabel("Credit:"));
	        panel.add(creditTextField);
	        panel.add(addEntryButton);
	        panel.add(saveButton);
	        panel.add(loadButton);

	        JScrollPane scrollPane = new JScrollPane(ledgerTable);

	        add(panel, BorderLayout.NORTH);
	        add(scrollPane, BorderLayout.CENTER);
	    }

	    private void addEntry() {
	        String date = dateTextField.getText();
	        String accountTitle = accountTitleTextField.getText();
	        String debitStr = debitTextField.getText();
	        String creditStr = creditTextField.getText();

	        if (!date.isEmpty() && !accountTitle.isEmpty() && (!debitStr.isEmpty() || !creditStr.isEmpty())) {
	            try {
	                double debit = debitStr.isEmpty() ? 00.0 : Double.parseDouble(debitStr);
	                double credit = creditStr.isEmpty() ? 00.0 : Double.parseDouble(creditStr);

	                Object[] rowData = {date, accountTitle, debit, credit};
	                tableModel.addRow(rowData);

	                dateTextField.setText("");
	                accountTitleTextField.setText("");
	                debitTextField.setText("");
	                creditTextField.setText("");
	            } catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(this, "Invalid debit or credit amount. Please enter valid numerical values.");
	            }
	        } else {
	            JOptionPane.showMessageDialog(this, "Please enter date, account title, and either debit or credit amount.");
	        }
	    }

	    private void saveToFile() {
	        JFileChooser fileChooser = new JFileChooser();
	        int result = fileChooser.showSaveDialog(this);

	        if (result == JFileChooser.APPROVE_OPTION) {
	            File file = fileChooser.getSelectedFile();

	            try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
	                for (int row = 0; row < tableModel.getRowCount(); row++) {
	                    for (int col = 0; col < tableModel.getColumnCount(); col++) {
	                        writer.print(tableModel.getValueAt(row, col));
	                        if (col < tableModel.getColumnCount() - 1) {
	                            writer.print(" - ");
	                        }
	                    }
	                    writer.println();
	                }
	                JOptionPane.showMessageDialog(this, "File saved successfully.");
	            } catch (IOException e) {
	                e.printStackTrace();
	                JOptionPane.showMessageDialog(this, "Error saving file.");
	            }
	        }
	    }

	    private void loadFromFile() {
	        JFileChooser fileChooser = new JFileChooser();
	        int result = fileChooser.showOpenDialog(this);

	        if (result == JFileChooser.APPROVE_OPTION) {
	            File file = fileChooser.getSelectedFile();

	            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	                String line;
	                while ((line = reader.readLine()) != null) {
	                    String[] parts = line.split(" - ");
	                    if (parts.length == 4) {
	                        Object[] rowData = {parts[0], parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3])};
	                        tableModel.addRow(rowData);
	                    }
	                }
	                JOptionPane.showMessageDialog(this, "File loaded successfully.");
	            } catch (IOException | NumberFormatException e) {
	                e.printStackTrace();
	                JOptionPane.showMessageDialog(this, "Error loading file.");
	            }
	        }
	    }

}
