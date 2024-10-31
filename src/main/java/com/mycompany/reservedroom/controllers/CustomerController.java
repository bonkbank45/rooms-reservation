/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reservedroom.controllers;

import com.mycompany.reservedroom.views.*;
import org.apache.commons.lang3.StringUtils;
import com.mycompany.reservedroom.views.ReservedRoomGUI;
import java.sql.SQLException;
import java.util.List;
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
    private AddCustomerGUI viewAddCustomer;
    private EditCustomerGUI viewEditCustomer;
    
    public CustomerController() {
        this.customerDAO = new CustomerDAOImpl();
    }
    
    public void setView(ReservedRoomGUI view) {
        this.viewMain = view;
    }
    
    public void setAddCustomerGUI(AddCustomerGUI view) {
        this.viewAddCustomer = view;
    }
    
    public void setEditCustomerGUI(EditCustomerGUI view) {
        this.viewEditCustomer = view;
    }
    
    public void refreshManageCustomerTable() {
        try {
            List<Customer> customerList = this.customerDAO.getAllCustomers();
            viewMain.updateManageCustomerTable(customerList);
        } catch (SQLException e) {
            viewMain.showErrorMessage("Error retrieving customer data: " + e.getMessage());
        }
    }
    
    public void handleCustomerSearching(String firstName, String lastName, String email, String phoneNumber) {
        try {
           List<Customer> customers = this.customerDAO.searchCustomer(firstName, lastName, email, phoneNumber);
           viewMain.updateBookingCustomerTable(customers);
           if (customers.isEmpty()) {
               viewMain.showInfoMessage("Not found customer.");
           }
        } catch (IllegalArgumentException e) {
           viewMain.showErrorMessage("Invalid search criteria: " + e.getMessage());
        }
    }
    
    public void handleCustomerAdding(String firstName, String lastName, String email, String phoneNumber) throws IllegalArgumentException {
        Customer customer;
        try {
            customer = new Customer(9999999, StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), email, phoneNumber);
            boolean success = this.customerDAO.addCustomer(customer.getCustomerFname(), customer.getCustomerLname(), customer.getEmail(), customer.getPhoneNumber());
            
            if (success) {
                this.refreshManageCustomerTable();
                this.viewAddCustomer.showInfoMessage("Customer added successfully!");
                this.viewAddCustomer.dispose();
            } else {
                this.viewAddCustomer.showErrorMessage("Failed to add customer.");
            }
        } catch (SQLException e) {
            System.out.println("Error adding customer: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            this.viewAddCustomer.showErrorMessage(e.getMessage());
        }
    }
    
    public void handleCustomerEdit(int customerId, String newFirstName, String newLastName, String newEmail, String newPhoneNumber) throws IllegalArgumentException {
        try {
            Customer customer = this.customerDAO.getCustomerById(customerId);
            if (customer == null) {
                this.viewEditCustomer.showErrorMessage("Customer not found with id: " + customerId);
            }

            customer.setCustomerFname(StringUtils.capitalize(newFirstName));
            customer.setCustomerLname(StringUtils.capitalize(newLastName));
            customer.setEmail(newEmail);
            customer.setPhoneNumber(newPhoneNumber);

            boolean success = this.customerDAO.editCustomer(customer);
            if (success) {
                this.refreshManageCustomerTable();
                this.viewEditCustomer.showInfoMessage("Customer edited successfully!");
                this.viewEditCustomer.dispose();
            } else {
                this.viewEditCustomer.showErrorMessage("Failed to edit customer.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            this.viewEditCustomer.showErrorMessage(e.getMessage());
        }
    }

    
    public void handleCustomerDeletion(int customerId) {
        try {
            boolean success = this.customerDAO.destroyCustomer(customerId);
            if (success) {
                this.refreshManageCustomerTable();
                this.viewMain.showInfoMessage("Delete Customer ID: " + customerId + " completed.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            this.viewMain.showErrorMessage("Failed to delete customer ID: " + customerId);
        }
    }
}
