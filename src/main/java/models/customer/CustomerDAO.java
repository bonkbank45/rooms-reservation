/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package models.customer;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author thana
 */
public interface CustomerDAO {
    Customer getCustomerById(int customerId) throws SQLException;
    List<Customer> getAllCustomers() throws SQLException;
    List<Customer> searchCustomer(String firstName, String lastName, String email, String phoneNumber);
    boolean addCustomer(String customerFname, String customerLname, String email, String phoneNumber) throws SQLException;
    boolean editCustomer(Customer customer) throws SQLException;
    boolean destroyCustomer(int customerId) throws SQLException;
}
