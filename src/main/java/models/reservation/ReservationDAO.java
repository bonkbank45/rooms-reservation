package models.reservation;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author thana
 */
public interface ReservationDAO {
    List<Reservation> getAllReservations() throws SQLException;
    List<ReservationInfomation> getCheckInDetails() throws SQLException;
    List<ReservationInfomation> getCheckOutDetails() throws SQLException;
    boolean addReservation(Reservation reservation) throws SQLException;
    
    boolean checkinReservation(int reservationId) throws SQLException;
    boolean checkoutReservation(int reservationId, String roomNumber) throws SQLException;
    boolean cancelReservation(int reservationId, String roomNumber) throws SQLException;
}
