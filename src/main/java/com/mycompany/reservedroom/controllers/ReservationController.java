package com.mycompany.reservedroom.controllers;

import com.mycompany.reservedroom.views.ReservedRoomGUI;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import models.reservation.Reservation;
import models.reservation.ReservationDAO;
import models.reservation.ReservationImpl;
import models.reservation.ReservationInfomation;

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
    
//    public void refreshReservationTable() {
//        try {
//            List<Reservation> reservationList = this.reservationDAO.getAllReservations();
//            this.viewMain.updateCheckInTable(reservationList);
//        } catch (SQLException e) {
//            this.viewMain.showErrorMessage("Error retrieving reservation data: " + e.getMessage());
//        }
//    }
    
    public void refreshCheckInTable() {
        try {
            List<ReservationInfomation> reservationInfomationList = this.reservationDAO.getCheckInDetails();
            this.viewMain.updateCheckInTable(reservationInfomationList);
        } catch (SQLException e) {
            this.viewMain.showErrorMessage("Error retrieving check-in data: " + e.getMessage());
        }
    }
    
    public void refreshCheckOutTable() {
        try {
            List<ReservationInfomation> reservationInfomationList = this.reservationDAO.getCheckOutDetails();
            this.viewMain.updateCheckOutTable(reservationInfomationList);
        } catch (SQLException e) {
            this.viewMain.showErrorMessage("Error retrieving check-out data: " + e.getMessage());
        }
    }
    
    public void handleMakeReservation(int customerId, int roomId, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(999999, customerId, roomId, checkInDate, checkOutDate, getTodayDate(), "RESERVED");
        try {
            boolean success = this.reservationDAO.addReservation(reservation);
            if (success) {
                this.viewMain.showInfoMessage("Reservation added successfully!");
            } else {
                this.viewMain.showErrorMessage("Failed to reservation room.");
            }
            this.refreshCheckInTable();
            this.viewMain.resetRoomTable();
            this.viewMain.resetRoomSelectedLabel();
            this.viewMain.resetRoomSelected();
            
        } catch (SQLException e) {
            System.out.println("Error adding room: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            this.viewMain.showErrorMessage(e.getMessage());
        }
    }
    
    public void handleMakeCheckIn(int reservationId) {
        try {
            boolean success = this.reservationDAO.checkinReservation(reservationId);
            if (success) {
                this.viewMain.showInfoMessage("Check-In room success!");
                this.refreshCheckInTable();
                this.refreshCheckOutTable();
            } else {
                this.viewMain.showErrorMessage("Failed to check-in room.");
            }
        } catch (SQLException e) {
            this.viewMain.showErrorMessage("Error check-in for this reservation: " + e.getMessage());
        }
    }
    
    public void handleMakeCheckOut(int reservationId, String roomNumber) {
        try {
            boolean success = this.reservationDAO.checkoutReservation(reservationId, roomNumber);
            if (success) {
                this.viewMain.showInfoMessage("Check-Out room success!");
                this.refreshCheckOutTable();
            } else {
                this.viewMain.showErrorMessage("Failed to check-out room.");
            }
        } catch (SQLException e) {
            this.viewMain.showErrorMessage("Error check-in for this reservation: " + e.getMessage());
        }
    }
    
    public void handleMakeCancel() {
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
