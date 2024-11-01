package com.mycompany.reservedroom.controllers;

import com.mycompany.reservedroom.views.AddRoomGUI;
import com.mycompany.reservedroom.views.EditRoomGUI;
import com.mycompany.reservedroom.views.ReservedRoomGUI;
import models.room.Room;
import models.room.RoomDAO;
import models.room.RoomDAOImpl;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author thana
 */
public class RoomController {
    private final RoomDAO roomDAO;
    private ReservedRoomGUI viewMain;
    private AddRoomGUI viewAddRoom;
    private EditRoomGUI viewEditRoom;
        
    public RoomController() {
        this.roomDAO = new RoomDAOImpl();
    }
    
    public void setView(ReservedRoomGUI view) {
        this.viewMain = view;
    }
    
    public void setAddRoomGUI(AddRoomGUI view) {
        this.viewAddRoom = view;
    }
    
    public void setEditRoomGUI(EditRoomGUI view) {
        this.viewEditRoom = view;
    }
    
    public void refreshManageRoomTable() {
        try {
            List<Room> roomList = this.roomDAO.getAllRooms();
            this.viewMain.updateManageRoomTable(roomList);
        } catch (SQLException e) {
            this.viewMain.showErrorMessage("Error retrieving room data: " + e.getMessage());
        }
    }

    public void handleSearchRoomAvailableByType(String type) {
        try {
            List<Room> rooms = this.roomDAO.getRoomAvailableByType(type);
            this.viewMain.updateReservationRoomTable(rooms);
            if (rooms.isEmpty()) {
                viewMain.showInfoMessage("No available rooms found for the selected type.");
            }
        } catch (SQLException e) {
            this.viewMain.showErrorMessage("Error searching for available rooms: " + e.getMessage());
        }
    }
    
    public void handleRoomAdding(String roomNumber, String roomType, double pricePerDay) throws IllegalArgumentException {
        Room room;
        try {
            room = new Room(9999999, roomNumber, roomType, pricePerDay, "Available");
            boolean success = this.roomDAO.addRoom(room.getRoomNumber(), room.getRoomType(), room.getRoomPrice());
            
            if (success) {
                this.refreshManageRoomTable();
                this.viewAddRoom.showInfoMessage("Room added successfully!");
                this.viewAddRoom.dispose();
            } else {
                this.viewAddRoom.showErrorMessage("Failed to add room.");
            }
        } catch (SQLException e) {
            System.out.println("Error adding room: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            this.viewAddRoom.showErrorMessage(e.getMessage());
        }
    }
    
    public void handleRoomEdit(int roomId, String newRoomNumber, String newRoomType, Double newPrice, String newStatus) throws IllegalArgumentException {
        try {
            Room room = this.roomDAO.getRoomById(roomId);
            if (room == null) {
                this.viewEditRoom.showErrorMessage("Room not found with id: " + roomId);
            }
            room.setRoomNumber(newRoomNumber);
            room.setRoomType(newRoomType);
            room.setRoomPrice(newPrice);
            room.setStatus(newStatus);
            
            boolean success = this.roomDAO.editRoom(room);
            if (success) {
                this.refreshManageRoomTable();
                this.viewEditRoom.showInfoMessage("Room edited successfully!");
                this.viewEditRoom.dispose();
            } else {
                this.viewEditRoom.showErrorMessage("Failed to edit room.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            this.viewEditRoom.showErrorMessage(e.getMessage());
        }
    }
    
    public void handleRoomDeletion(int roomId) {
        try {
            boolean success = this.roomDAO.destroyRoom(roomId);
            if (success) {
                this.refreshManageRoomTable();
                this.viewMain.showInfoMessage("Delete Room ID: " + roomId + " completed.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            this.viewMain.showErrorMessage("Failed to delete room ID: " + roomId);
        }
    }
}
