/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reservedroom.controllers;

import com.mycompany.reservedroom.views.ReservedRoomGUI;
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
    private ReservedRoomGUI viewMain;
    
    public RoomController() {
        this.roomDAO = new RoomDAOImpl();
    }
    
    public void setView(ReservedRoomGUI view) {
        this.viewMain = view;
    }
    
    public void updateRoomTable() {
        try {
            List<Room> roomList = this.roomDAO.getAllRooms();
            DefaultTableModel model = (DefaultTableModel) viewMain.getShowRoomTable();
            model.setRowCount(0); // Clear existing rows
            for (Room room : roomList) {
                model.addRow(new Object[]{
                    room.getRoomId(),
                    room.getRoomNumber(),
                    room.getRoomType(),
                    room.getRoomPrice(),
                    ((room.getStatus()).substring(0, 1)).toUpperCase() + 
                    (room.getStatus()).substring(1)
                });
            }
        } catch (SQLException e) {
            System.out.println("Error displaying room table: " + e.getMessage());
        }
    }
    
    public boolean handleRoomAdding(String roomNumber, String roomType, double pricePerDay) throws IllegalArgumentException {
        Room room;
        try {
            room = new Room(9999999, roomNumber, roomType, pricePerDay, "Available");
            boolean success = this.roomDAO.addRoom(room.getRoomNumber(), room.getRoomType(), room.getRoomPrice());
            
            if (success) {
                this.updateRoomTable();
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error adding room: " + e.getMessage());
        }
        return false;
    }
    
    public boolean handleRoomEdit(int roomId, String newRoomNumber, String newRoomType, Double newPrice, String newStatus) throws IllegalArgumentException {
        try {
            Room room = this.roomDAO.getRoomById(roomId);
            if (room == null) {
                throw new IllegalArgumentException("Room not found with id: " + roomId);
            }
            room.setRoomNumber(newRoomNumber);
            room.setRoomType(newRoomType);
            room.setRoomPrice(newPrice);
            room.setStatus(newStatus);
            
            boolean success = this.roomDAO.editRoom(room);
            if (success) {
                this.updateRoomTable();
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        return false;
    }
    
    public boolean handleRoomDeletion(int roomId) {
        try {
            boolean success = this.roomDAO.destroyRoom(roomId);
            if (success) {
                this.updateRoomTable();
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        return false;
    }
}
