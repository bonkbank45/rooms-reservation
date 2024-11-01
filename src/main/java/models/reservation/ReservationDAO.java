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
//    List<Reservation> getAllRoomCheckIn() throws SQLException;
    boolean editReservation(Reservation reservation) throws SQLException;
    boolean addReservation(Reservation reservation) throws SQLException;
    boolean destroyReservation(int reservationId) throws SQLException;
    
    boolean checkinReservation(int reservationId) throws SQLException;
    boolean checkoutReservation(int reservationId) throws SQLException;
    boolean cancelReservation(int reservationId) throws SQLException;
}
