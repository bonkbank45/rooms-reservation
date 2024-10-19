package models.customer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.ConnectionDbManager;

/**
 *
 * @author thana
 */
public class CustomerDAOImpl implements CustomerDAO{
    @Override
    public Customer getCustomerById(int customerId) throws SQLException {
        String query = "SELECT customer_id, first_name, last_name, email, phone_number FROM customers WHERE customer_id = ?";
        
        Customer customerFounded = null;
        ResultSet rs;
        
        try (Connection conn = new ConnectionDbManager().getConnection()) {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, customerId);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                int id = rs.getInt("customer_id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String email = rs.getString("email");
                String phone_number = rs.getString("phone_number");

                customerFounded = new Customer(id, first_name, last_name, email, phone_number);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return customerFounded;
    }
    
    @Override
    public List<Customer> getAllCustomers() throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        String query = "SELECT customer_id, first_name, last_name, email, phone_number FROM customers";
        StringBuilder errorMessages = new StringBuilder();

        try (Connection conn = new ConnectionDbManager().getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int customer_id = rs.getInt("customer_id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String email = rs.getString("email");
                String phone_number = rs.getString("phone_number");

                try {
                    Customer customer = new Customer(customer_id, first_name, last_name, email, phone_number);
                    customerList.add(customer);
                } catch (IllegalArgumentException e) {
                    errorMessages.append("Invalid customer data - Id: ").append(customer_id).append(" ").append(e.getMessage()).append("\n");
                }
            }
        }
        if (errorMessages.length() > 0) {
            System.out.println(errorMessages.toString());
        }

        return customerList;
    }
    
    @Override
    public boolean addCustomer(String customerFname, String customerLname, String email, String phoneNumber) throws SQLException {
        String query = "INSERT INTO customers (first_name, last_name, email, phone_number) VALUES (?, ?, ?, ?)";

        try (Connection conn = new ConnectionDbManager().getConnection();
            PreparedStatement pst = conn.prepareStatement(query)) {

            pst.setString(1, customerFname);
            pst.setString(2, customerLname);
            pst.setString(3, email);
            pst.setString(4, phoneNumber);

            int affectedRows = pst.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;


    }
    
    @Override
    public boolean editCustomer(Customer customer) throws SQLException {
        String query = "UPDATE customers SET first_name = ?, last_name = ?, email = ?, phone_number = ? WHERE customer_id = ?";
        try (Connection conn = new ConnectionDbManager().getConnection()) {
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, customer.getCustomerFname());
            pst.setString(2, customer.getCustomerLname());
            pst.setString(3, customer.getEmail());
            pst.setString(4, customer.getPhoneNumber());
            pst.setInt(5, customer.getCustomerId());

            int affectedRows = pst.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating customer failed, no rows affected.");
            }
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean destroyCustomer(int customerId) throws SQLException {
        String query = "DELETE FROM customers WHERE customer_id = ?";
        try (Connection conn = new ConnectionDbManager().getConnection()) {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, customerId);
            int affectedRows = pst.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Delete customer failed, no rows affected.");
            }
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
