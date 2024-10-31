/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.room;

/**
 *
 * @author thana
 */

public class Room {
    private final int roomId;
    private String roomNumber;
    private String roomType;
    private double roomPrice;
    private String status;

    public Room(int roomId, String roomNumber, String roomType, double roomPrice, String status) {
        this.roomId = roomId;
        this.setRoomNumber(roomNumber);
        this.setRoomType(roomType);
        this.setRoomPrice(roomPrice);
        this.setStatus(status);
    }

    public int getRoomId() {
        return this.roomId;
    }

    public String getRoomNumber() {
        return this.roomNumber;
    }
    
    public String getRoomType() {
        return this.roomType;
    }
    
    public void setRoomType(String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Type can't be null or empty");
        }
        if (!type.equalsIgnoreCase("Single") && !type.equalsIgnoreCase("Double") ) {
            throw new IllegalArgumentException("Invalid type room. Must be 'Single' or 'Double'");
        }
        this.roomType = type;
    }
    
    public void setRoomNumber(String roomNumber) {
        if (roomNumber == null || roomNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Room number can't be null or empty");
        }
        this.roomNumber = roomNumber;
    }

    public double getRoomPrice() {
        return this.roomPrice;
    }
    
    public void setRoomPrice(double roomPrice) {
        if (roomPrice < 0) {
            throw new IllegalArgumentException("Price per night can't be negative");
        }
        this.roomPrice = roomPrice;
    }

    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
            throw new IllegalArgumentException("Status can't be null or empty");
        }
        if (!status.equalsIgnoreCase("Available") && !status.equalsIgnoreCase("Unavailable") && !status.equalsIgnoreCase("Reserved") ) {
            throw new IllegalArgumentException("Invalid status. Must be 'Available', 'Unavailable' or 'Reserved'");
        }
        this.status = status;
    }
}
