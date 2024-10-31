package models.reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import models.ConnectionDbManager;

/**
 *
 * @author thana
 */
public class ReservationImpl implements ReservationDAO {
    private final String STATUS_CHECKED_IN = "CHECKED_ID";
    private final String STATUS_CHECKED_OUT = "CHECKED_OUT";
    private final String STATUS_CHECKED_CANCEL = "CHECKED_CANCEL";
    private final String STATUS_RESERVED = "RESERVED";
    
    @Override
    public List<Reservation> getAllReservations() throws SQLException {
        List<Reservation> reservationList = new ArrayList<>();
        String query = "SELECT reservation_id, customer_id, room_id, check_in_date, check_out_date, reservation_date, status FROM reservations";
        StringBuilder errorMessages = new StringBuilder();
        
        try (Connection conn = new ConnectionDbManager().getConnection()) {
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                int reservationId = rs.getInt("reservation_id");
                int customerId = rs.getInt("customer_id");
                int roomId = rs.getInt("room_id");
                Date checkInDate = rs.getDate("check_in_date");
                Date checkOutDate = rs.getDate("check_out_date");
                Date reservationDate = rs.getDate("reservation_date");
                String reservationStatus = rs.getString("status");
                try {
                    Reservation reservation = new Reservation(reservationId, customerId, roomId, checkInDate, checkOutDate, reservationDate, reservationStatus);
                    reservationList.add(reservation);
                } catch (IllegalArgumentException e) {
                    errorMessages.append("Invalid reservation data - Id: ").append(reservationId).append(" ").append(e.getMessage()).append("\n");
                }
            }
        } catch (SQLException e) {
           System.out.println(e.getMessage());
        }
        if (errorMessages.length() > 0) {
            JOptionPane.showMessageDialog(null, errorMessages.toString(), "Data Error!", JOptionPane.ERROR_MESSAGE);
        }
        return reservationList;
    }

    @Override
    public boolean editReservation(Reservation reservation) throws SQLException {
        String query = "UPDATE reservations SET customer_id = ?, room_id = ?, check_in_date = ?, check_out_date = ?, reservation_date = ?, status = ? WHERE reservation_id = ?";
        return executeUpdateWithReservation(query, reservation);
    }
    
    @Override
    public boolean addReservation(Reservation reservation) throws SQLException {
        if (this.isRoomReserved(reservation.getRoomId())) {
            System.out.println("Cannot add reservation: Room is already reserved.");
            
            throw new IllegalArgumentException("Fail to reservation because this room reserved already.");
        }
        
        String reservationQuery = "INSERT INTO reservations (customer_id, room_id, check_in_date, check_out_date, reservation_date, status) VALUES (?, ?, ?, ?, ?, ?)";
        String updateRoomQuery = "UPDATE rooms SET status = ? WHERE room_id = ?";

        boolean success = executeUpdateWithReservation(reservationQuery, reservation);
        if (success) {
            try (Connection conn = new ConnectionDbManager().getConnection()) {
                PreparedStatement pst = conn.prepareStatement(updateRoomQuery);
                pst.setString(1, STATUS_RESERVED);
                pst.setInt(2, reservation.getRoomId());
                int affectedRows = pst.executeUpdate();
                if (affectedRows == 0) {
                    throw new SQLException("Add reservation failed, no rows affected when updating room status.");
                }
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean destroyReservation(int reservationId) throws SQLException {
        String query = "DELETE FROM reservations WHERE reservation_id = ?";
        try (Connection conn = new ConnectionDbManager().getConnection()) {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, reservationId);

            int affectedRows = pst.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Delete reservation failed, no rows affected.");
            }
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    @Override
    public boolean checkinReservation(int reservationId) throws SQLException {
        return updateReservationStatus(reservationId, this.STATUS_CHECKED_IN);
    }
    
    @Override
    public boolean checkoutReservation(int reservationId) throws SQLException {
        return updateReservationStatus(reservationId, this.STATUS_CHECKED_OUT);
    }
    
    @Override
    public boolean cancelReservation(int reservationId) throws SQLException {
        return updateReservationStatus(reservationId, this.STATUS_CHECKED_CANCEL);
    }
    
    private boolean updateReservationStatus(int reservationId, String status) {
    String query = "UPDATE reservations SET status = ? WHERE reservation_id = ?";
        try (Connection conn = new ConnectionDbManager().getConnection()) {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, status);
            pst.setInt(2, reservationId);
            int affectedRows = pst.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Check-in failed, no rows affected.");
            }
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private boolean executeUpdateWithReservation(String query, Reservation reservation) throws SQLException {        
        try (Connection conn = new ConnectionDbManager().getConnection()) {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, reservation.getCustomerId());
            pst.setInt(2, reservation.getRoomId());

            // Convert java.util.Date to java.sql.Date
            pst.setDate(3, new java.sql.Date(reservation.getCheckInDate().getTime())); // Convert check-in date
            pst.setDate(4, new java.sql.Date(reservation.getCheckOutDate().getTime())); // Convert check-out date
            pst.setDate(5, new java.sql.Date(reservation.getReservationDate().getTime())); // Convert reservation date

            pst.setString(6, reservation.getReservationStatus());

            int affectedRow = pst.executeUpdate();
            return affectedRow > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    return false;
    }
    
    private boolean isRoomReserved(int roomId) throws SQLException {
        String query = "SELECT status FROM rooms WHERE room_id = ?";
        try (Connection conn = new ConnectionDbManager().getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setInt(1, roomId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String roomStatus = rs.getString("status");
                return STATUS_RESERVED.equals(roomStatus);
            }
        }
        return false;
    }
}




