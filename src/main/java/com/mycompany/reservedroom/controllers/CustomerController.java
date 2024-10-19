/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reservedroom.controllers;

import org.apache.commons.lang3.StringUtils;
import com.mycompany.reservedroom.views.ReservedRoomGUI;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.customer.Customer;
import models.customer.CustomerDAO;
import models.customer.CustomerDAOImpl;

/**
 *
 * @author thana
 */
public class CustomerController {
    private final CustomerDAO customerDAO;
    private ReservedRoomGUI viewMain;
    
    public CustomerController() {
        this.customerDAO = new CustomerDAOImpl();
    }
    
    public void setView(ReservedRoomGUI view) {
        this.viewMain = view;
    }
    
    public void updateCustomerTable() {
        try {
            List<Customer> customerList = this.customerDAO.getAllCustomers();
            DefaultTableModel model = (DefaultTableModel) viewMain.getShowCustomerTable();
            model.setRowCount(0); // Clear existing rows
            for (Customer customer : customerList) {
                model.addRow(new Object[]{
                    customer.getCustomerId(),
                    customer.getCustomerFname(),
                    customer.getCustomerLname(),
                    customer.getEmail(),
                    customer.getPhoneNumber()
                });
            }
        } catch (SQLException e) {
            System.out.println("Error displaying customer table: " + e.getMessage());
        }
    }
    
    public boolean handleCustomerAdding(String customerFname, String customerLname, String email, String phoneNumber) throws IllegalArgumentException {
        Customer customer;
        try {
            customer = new Customer(9999999, StringUtils.capitalize(customerFname), StringUtils.capitalize(customerLname), email, phoneNumber);
            boolean success = this.customerDAO.addCustomer(customer.getCustomerFname(), customer.getCustomerLname(), customer.getEmail(), customer.getPhoneNumber());
            
            if (success) {
                this.updateCustomerTable();
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error adding room: " + e.getMessage());
        }
        return false;
    }
    
    public boolean handleCustomerEdit(int customerId, String newFirstName, String newLastName, String newEmail, String newPhoneNumber) throws IllegalArgumentException {
    try {
        Customer customer = this.customerDAO.getCustomerById(customerId);
        if (customer == null) {
            throw new IllegalArgumentException("Customer not found with id: " + customerId);
        }
        
        customer.setCustomerFname(StringUtils.capitalize(newFirstName));
        customer.setCustomerLname(StringUtils.capitalize(newLastName));
        customer.setEmail(newEmail);
        customer.setPhoneNumber(newPhoneNumber);
        
        boolean success = this.customerDAO.editCustomer(customer);
        if (success) {
            this.updateCustomerTable();
            return true;
        }
    } catch (SQLException e) {
        System.out.println("Database error: " + e.getMessage());
    }
        return false;
    }

    
    public boolean handleCustomerDeletion(int customerId) {
        try {
            boolean success = this.customerDAO.destroyCustomer(customerId);
            if (success) {
                this.updateCustomerTable();
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        return false;
    }
}
