/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author thana
 */

public class Room {
    private final int roomId;
    private String roomNumber;
    private double roomPrice;
    private String status;

    public Room(int roomId, String roomNumber, double roomPrice, String status) {
        this.roomId = roomId;
        this.setRoomNumber(roomNumber);
        this.setRoomPrice(roomPrice);
        this.setStatus(status);
    }

    public int getRoomId() {
        return roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
    
    public void setRoomNumber(String roomNumber) {
        if (roomNumber == null || roomNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Room number can't be null or empty");
        }
        this.roomNumber = roomNumber;
    }

    public double getRoomPrice() {
        return roomPrice;
    }
    
    public void setRoomPrice(double roomPrice) {
        if (roomPrice < 0) {
            throw new IllegalArgumentException("Price per night can't be negative");
        }
        this.roomPrice = roomPrice;
    }

    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
            throw new IllegalArgumentException("Status can't be null or empty");
        }
        if (!status.equalsIgnoreCase("Available") && !status.equalsIgnoreCase("Unavailable") ) {
            throw new IllegalArgumentException("Invalid status. Must be 'Available' or 'Unavailable'");
        }
        this.status = status;
    }
}
