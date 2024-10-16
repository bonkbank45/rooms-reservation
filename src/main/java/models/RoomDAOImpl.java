/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import models.Room;
import models.ConnectionDbManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author thana
 */
public class RoomDAOImpl implements RoomDAO {
    
    @Override
    public Room getRoomById(int roomId) throws SQLException {
        String query = "SELECT room_id, room_number, price_per_night, status FROM rooms WHERE room_id = ?";
        
        Room roomFounded = null;
        ResultSet rs;
        
        try (Connection conn = new ConnectionDbManager().getConnection()) {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, roomId);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                int id = rs.getInt("room_id");
                String room_number = rs.getString("room_number");
                double price_per_night = rs.getDouble("price_per_night");
                String status = rs.getString("status");

                roomFounded = new Room(id, room_number, price_per_night, status);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return roomFounded;
        
    }
    
    @Override
    public List<Room> getAllRooms() throws IllegalArgumentException, SQLException {
        List<Room> roomList = new ArrayList<>();
        String query = "SELECT room_id, room_number, price_per_night, status FROM rooms";
        StringBuilder errorMessages = new StringBuilder();
        
        try (Connection conn = new ConnectionDbManager().getConnection()) {
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                int room_id = rs.getInt("room_id");
                String room_number = rs.getString("room_number");
                double room_price = rs.getDouble("price_per_night");
                String status = rs.getString("status");
                try {
                    Room room = new Room(room_id, room_number, room_price, status);
                    roomList.add(room);
                } catch (IllegalArgumentException e) {
                    errorMessages.append("Invalid room data - Id: ").append(room_id).append(" ").append(e.getMessage()).append("\n");
                }
            }
        }
        if (errorMessages.length() > 0) {
            JOptionPane.showMessageDialog(null, errorMessages.toString(), "Data Error!", JOptionPane.ERROR_MESSAGE);
        }
        return roomList;
    }
    
    @Override
    public boolean addRoom(String roomNumber, double pricePerDay) throws SQLException {
        String query = "INSERT INTO rooms (room_number, price_per_night, status) VALUES (?, ?, 'available')";
        
        try (Connection conn = new ConnectionDbManager().getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
            
            pst.setString(1, roomNumber);
            pst.setDouble(2, pricePerDay);
            
            int affectedRows = pst.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    @Override
    public boolean editRoom(Room room) throws SQLException {
        String query = "UPDATE rooms SET room_number = ? , price_per_night = ?, status = ? WHERE room_id = ?";
        try (Connection conn = new ConnectionDbManager().getConnection()) {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, room.getRoomNumber());
            pst.setDouble(2, room.getRoomPrice());
            pst.setString(3, room.getStatus());
            pst.setInt(4, room.getRoomId());
            int affectedRows = pst.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating room failed, no rows affected.");
            }
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    @Override
    public boolean destroyRoom(int roomId) {
        String query = "DELETE FROM rooms WHERE room_id = ?";
        try (Connection conn = new ConnectionDbManager().getConnection()) {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, roomId);
            int affectedRows = pst.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Delete room failed, no rows affected.");
            }
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
