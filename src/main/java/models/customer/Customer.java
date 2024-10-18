/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.customer;

import java.util.regex.Pattern;

/**
 *
 * @author thana
 */

public class Customer {
    private final int customerId;
    private String customerFname;
    private String customerLname;
    private String email;
    private String phoneNumber;
    
    private static final String NAME_REGEX = "^[a-zA-Z]{3,}$";
    private static final Pattern NAME_PATTERN = Pattern.compile(NAME_REGEX);
    
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_.+\\-]+@[a-zA-Z0-9\\-]+\\.[a-zA-Z0-9\\-.]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public Customer(int customerId, String customerFname, String customerLname, String email, String phoneNumber) {
        this.customerId = customerId;
        this.setCustomerFname(customerFname);
        this.setCustomerLname(customerLname);
        this.setEmail(email);
        this.setPhoneNumber(phoneNumber);
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public String getCustomerFname() {
        return this.customerFname;
    }

    public void setCustomerFname(String customerFname) {
        if (customerFname == null || customerFname.trim().isEmpty()) {
            throw new IllegalArgumentException("First name can't be null or empty");
        }
        if (!NAME_PATTERN.matcher(customerFname).matches()) {
            throw new IllegalArgumentException("First name must contain alphabet only.");
        }
        this.customerFname = customerFname;
    }

    public String getCustomerLname() {
        return this.customerLname;
    }

    public void setCustomerLname(String customerLname) {
        if (customerLname == null || customerLname.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name can't be null or empty");
        }
        if (!NAME_PATTERN.matcher(customerLname).matches()) {
            throw new IllegalArgumentException("Last name must contain alphabet only.");
        }
        this.customerLname = customerLname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email can't be null or empty");
        }
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number can't be null or empty");
        }
        this.phoneNumber = phoneNumber;
    }
}
