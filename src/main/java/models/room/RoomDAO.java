/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package models.room;

import java.sql.SQLException;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author thana
 */
public interface RoomDAO {
    Room getRoomById(int roomId) throws SQLException;
    List<Room> getAllRooms() throws SQLException;
    List<Room> getRoomAvailableByType(String type) throws SQLException;
    boolean addRoom(String roomNumber, String roomType, double pricePerDay) throws SQLException;
    boolean editRoom(Room room) throws SQLException;
    boolean destroyRoom(int RoomId) throws SQLException;
}
