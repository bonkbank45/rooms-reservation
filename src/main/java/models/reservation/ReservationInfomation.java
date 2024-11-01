/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.reservation;

import java.util.Date;

/**
 *
 * @author thana
 */
public class ReservationInfomation {
    private int reservationId;
    private int customerId;
    private String customerFirstName;
    private String customerEmail;
    private String roomNumber;
    private Date checkInDate;
    private Date checkOutDate;
    private Date reservationDate;
    private String reservationStatus;

    public ReservationInfomation(int reservationId, int customerId, String customerFirstName, String customerEmail, 
                       String roomNumber, Date checkInDate, Date checkOutDate, Date reservationDate, String reservationStatus) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.customerFirstName = customerFirstName;
        this.customerEmail = customerEmail;
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.reservationDate = reservationDate;
        this.reservationStatus = reservationStatus;
    }

    public int getReservationId() {
        return reservationId;
    }
    
    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }
    
    public Date getReservationDate() {
        return reservationDate;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
    
    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}

