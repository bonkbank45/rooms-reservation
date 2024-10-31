package com.mycompany.reservedroom.controllers;

import com.mycompany.reservedroom.views.ReservedRoomGUI;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import models.reservation.Reservation;
import models.reservation.ReservationDAO;
import models.reservation.ReservationImpl;

/**
 *
 * @author thana
 */
public class ReservationController {
    private ReservedRoomGUI viewMain;
    private final ReservationDAO reservationDAO;
    
    public ReservationController() {
        this.reservationDAO = new ReservationImpl();
    }
    
    public void setView(ReservedRoomGUI view) {
        this.viewMain = view;
    }
    
    public void handleReservation(int customerId, int roomId, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(999999, customerId, roomId, checkInDate, checkOutDate, getTodayDate(), "RESERVED");
        try {
            boolean success = this.reservationDAO.addReservation(reservation);
            if (success) {
                this.viewMain.showInfoMessage("Reservation added successfully!");
            } else {
                this.viewMain.showErrorMessage("Failed to reservation room.");
            }
            this.viewMain.resetRoomTable();
            this.viewMain.resetRoomSelectedLabel();
            this.viewMain.resetRoomSelected();
            
        } catch (SQLException e) {
            System.out.println("Error adding room: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            this.viewMain.showErrorMessage(e.getMessage());
        }
    }
    
    public void handleCheckIn() {
        // TODO
    }
    
    public void handleCheckOut() {
        // TODO
    }
    
    public void handleCancelReservation() {
        // TODO
    }
    
    private Date getTodayDate() {
        Calendar todayCalendar = Calendar.getInstance();
        todayCalendar.set(Calendar.HOUR_OF_DAY, 0);
        todayCalendar.set(Calendar.MINUTE, 0);
        todayCalendar.set(Calendar.SECOND, 0);
        todayCalendar.set(Calendar.MILLISECOND, 0);
        return todayCalendar.getTime();
    }
}
