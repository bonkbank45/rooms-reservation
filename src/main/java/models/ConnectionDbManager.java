/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package models;

/**
 *
 * @author thana
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDbManager {
    private final String url = "jdbc:mysql://localhost:3306/reserved-room";
    private final String username = "root";
    private final String password =  "Qq01355001862_";
    private Connection connection = null;
    
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException e) {
            System.out.println("Close connection failed");
        }
    }
    
    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Connection failed");
        }
        return connection;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
