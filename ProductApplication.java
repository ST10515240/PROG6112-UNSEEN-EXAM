/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.matresssales;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;

/**
 *
 * @author Student
 */
public class ProductApplication extends JFrame {
    //frame configuration
    private JTextField txtCustomerName;
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice;
    private JButton btnProcess;
    
     public ProductApplication() {
        // Frame configuration
        setTitle("Product App");
        setSize(420, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
     }
}
 public ProductApp() {
        // Frame configuration
        setTitle("Product App");
        setSize(420, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // 1. Setup Menu Bar (Q.2.4)
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");

        processItem.addActionListener(e -> processSale());
        clearItem.addActionListener(e -> clearFields());

        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);
        

        // 2. Setup Form Panel (Q.2.2)
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Customer Name row
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        formPanel.add(new JLabel("Customer Name:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.7;
        txtCustomerName = new JTextField(15);
        formPanel.add(txtCustomerName, gbc);

        // Select Product row
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.3;
        formPanel.add(new JLabel("Select Product:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.7;
        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };
        cmbProduct = new JComboBox<>(products);
        formPanel.add(cmbProduct, gbc);

        // Enter Price row
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.3;
        formPanel.add(new JLabel("Enter Price:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.7;
        txtPrice = new JTextField(15);
        formPanel.add(txtPrice, gbc);

        // Process Button row
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(12, 6, 6, 6);
        btnProcess = new JButton("PROCESS");
        btnProcess.addActionListener(e -> processSale());
        formPanel.add(btnProcess, gbc);

        add(formPanel, BorderLayout.CENTER);
    }

    // Handles calculation, message popup, and file logging (Q.2.3)
    private void processSale() {
        String customerName = txtCustomerName.getText().trim();
        String productName = (String) cmbProduct.getSelectedItem();
        String priceText = txtPrice.getText().trim();

        // Validate inputs
        if (customerName.isEmpty() || priceText.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter both Customer Name and Product Price.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        double price;
        try {
            price = Double.parseDouble(priceText);
            if (price < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a valid positive numeric price.",
                    "Invalid Price",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Perform calculations using ProductCalculations class
        ProductCalculations calc = new ProductCalculations(price);
        double vat = calc.GetVat();
        double commission = calc.GetCommission();
        double total = calc.GetTotal();

        // Format output message matching the sample screenshot
        String outputMessage = "Customer Name: " + customerName + "\n"
                + "Product: " + productName + "\n"
                + "VAT: R " + vat + "\n"
                + "COMMISSION: R " + commission + "\n"
                + "TOTAL: R " + total;

        // Display dialog message
        JOptionPane.showMessageDialog(this, outputMessage, "Message", JOptionPane.INFORMATION_MESSAGE);

        // Save details to data.txt
        saveToFile(outputMessage);
    }

    // Appends the formatted transaction record to data.txt
    private void saveToFile(String recordDetails) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt", true))) {
            writer.println("DATA LOG");
            writer.println("************************************");
            writer.println(recordDetails);
            writer.println("************************************");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error saving data to file: " + e.getMessage(),
                    "File Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Resets text boxes and sets combo box to index 0 (Q.2.4)
    private void clearFields() {
        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ProductApp().setVisible(true);
        });
    }
}


