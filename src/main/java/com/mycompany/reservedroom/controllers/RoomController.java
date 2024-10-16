/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reservedroom.controllers;

import models.Room;
import models.RoomDAO;
import models.RoomDAOImpl;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thana
 */
public class RoomController {
    private final RoomDAO roomDAO;
    
    public RoomController() {
        this.roomDAO = new RoomDAOImpl();
    }
    
    public void displayTableRoom(DefaultTableModel tblModel) {
        try {
            List<Room> roomList = this.roomDAO.getAllRooms();
            tblModel.setRowCount(0);
            for (Room room : roomList) {
                tblModel.addRow(new Object[]{
                    room.getRoomId(),
                    room.getRoomNumber(),
                    room.getRoomPrice(),
                    ((room.getStatus()).substring(0, 1)).toUpperCase() + 
                    (room.getStatus()).substring(1)
                });
            }
        } catch (SQLException e) {
            System.out.println("Error displaying room table: " + e.getMessage());
        }
    }
    
    public boolean addRoom(String roomNumber, double pricePerDay) throws IllegalArgumentException {
        Room room;
        try {
            room = new Room(9999999, roomNumber, pricePerDay, "Available");
            return this.roomDAO.addRoom(room.getRoomNumber(), room.getRoomPrice());
        } catch (SQLException e) {
            System.out.println("Error adding room: " + e.getMessage());
            return false;
        }
    }
    
    public boolean editRoom(int roomId, String newRoomNumber, Double newPrice, String newStatus) throws IllegalArgumentException {
        try {
            Room room = this.roomDAO.getRoomById(roomId);
            if (room == null) {
                throw new IllegalArgumentException("Room not found with id: " + roomId);
            }
            
            room.setRoomNumber(newRoomNumber);
            room.setRoomPrice(newPrice);
            room.setStatus(newStatus);
            
            return this.roomDAO.editRoom(room);
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return false;
        }
    }
    
    public boolean destroyRoom(int roomId) {
        try {
            return this.roomDAO.destroyRoom(roomId);
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return false;
        }
    }
}
