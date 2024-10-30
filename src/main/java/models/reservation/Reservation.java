package models.reservation;

import java.util.Date;

/**
 *
 * @author thana
 */
public class Reservation {
    private final int reservationId;
    private int customerId;
    private int roomId;
    private Date checkInDate;
    private Date checkOutDate;
    private Date reservationDate;
    private ReservationStatus reservationStatus;
    
    public Reservation(int reservationId, int customerId, int roomId, Date checkInDate, Date checkOutDate, Date reservationDate, String reservationStatus) {
        this.reservationId = reservationId;
        this.setCustomerId(customerId);
        this.setRoomId(roomId);
        this.setCheckInDate(checkInDate);
        this.setCheckOutDate(checkOutDate);
        this.setReservationDate(reservationDate);
        this.setReservationStatus(ReservationStatus.valueOf(reservationStatus));
    }
    
    public int getReservationId() {
        return this.reservationId;
    }
    
    public int getCustomerId() {
        return this.customerId;
    }
    
    public int getRoomId() {
        return this.roomId;
    }
    
    public Date getCheckInDate() {
        return this.checkInDate;
    }
    
    public Date getCheckOutDate() {
        return this.checkOutDate;
    }
    
    public Date getReservationDate() {
        return this.reservationDate;
    }
    
    public String getReservationStatus() {
        return this.reservationStatus.toString();
    }

    private void setCustomerId(int customerId) {
        if (customerId < 1) {
            throw new IllegalArgumentException("Customer ID must be a positive number.");
        }
        this.customerId = customerId;
    }

    private void setRoomId(int roomId) {
        if (roomId < 1) {
            throw new IllegalArgumentException("Room ID must be a positive number.");
        }
        this.roomId = roomId;
    }

    private void setCheckInDate(Date checkInDate) {
        if (checkInDate == null) {
            throw new IllegalArgumentException("Check-In date can't be null.");
        }
        this.checkInDate = checkInDate;
    }

    private void setCheckOutDate(Date checkOutDate) {
        if (checkOutDate == null || checkOutDate.before(this.checkInDate)) {
            throw new IllegalArgumentException("Check-out date must be after check-in date.");
        }
        this.checkOutDate = checkOutDate;
    }

    private void setReservationDate(Date reservationDate) {
        if (reservationDate == null) {
            throw new IllegalArgumentException("Reservation date can't be null.");
        }
        this.reservationDate = reservationDate;
    }

    private void setReservationStatus(ReservationStatus reservationStatus) {
        if (reservationStatus == null) {
            throw new IllegalArgumentException("Reservation status can't be null.");
        }
        this.reservationStatus = reservationStatus;
    }
    
    public enum ReservationStatus {
        CHECKED_ID, CHECKED_OUT, CANCELED
    }
}
