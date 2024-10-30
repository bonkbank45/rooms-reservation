/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.reservedroom.views;

/**
 *
 * @author thana
 */

import com.mycompany.reservedroom.controllers.CustomerController;
import com.mycompany.reservedroom.controllers.RoomController;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import models.customer.Customer;
import models.room.Room;

public class ReservedRoomGUI extends javax.swing.JFrame {

    private final RoomController roomController;
    private final CustomerController customerController;
    
    private Customer customerSelected;
    private Room roomSelected;
    
    /**
     * Creates new form ReservedRoomGUI
     * @param roomController
     */
    public ReservedRoomGUI(RoomController roomController, CustomerController customerController) {        
        initComponents();
        this.roomController = roomController;
        this.roomController.setView(this);
        
        this.customerController = customerController;
        this.customerController.setView(this);
        this.customerController.refreshManageCustomerTable();
        
        TableColumnModel roomCcolumnModel = bookingRoomTable.getColumnModel();
        //columnModel.removeColumn(columnModel.getColumn(2));
    }
    
    public void setCustomerSelected(Customer customer) {
        this.customerSelected = customer;
    }
    
    public void setRoomSelected(Room room) {
        this.roomSelected = room;
    }
    
    public Customer getCustomerSelected() {
        return this.customerSelected;
    }
    
    public Room getRoomSelected() {
        return this.roomSelected;
    }
    
    public TableModel getShowRoomTable() {
        return this.showRoomTable.getModel();
    }
    
    public void updateRoomTable(TableModel model) {
        this.showRoomTable.setModel(model);
    }
    
    public TableModel getManageCustomerTable() {
        return this.manageCustomerTable.getModel();
    }
    
    public TableModel getBookingCustomerTable() {
        return this.bookingCustomerTable.getModel();
    }
    
    public TableModel getBookingRoomTable() {
        return this.bookingRoomTable.getModel();
    }
    
    public void updateCustomerTable(TableModel model) {
        this.manageCustomerTable.setModel(model);
    }
    
    public void updateManageCustomerTable(List<Customer> customerList) {
        DefaultTableModel model = (DefaultTableModel) manageCustomerTable.getModel();
        model.setRowCount(0); // Clear existing rows
        for (Customer customer : customerList) {
            model.addRow(new Object[]{
                customer.getCustomerId(),
                customer.getCustomerFname(),
                customer.getCustomerLname(),
                customer.getEmail(),
                customer.getPhoneNumber()
            });
        }
    }
    
    public void updateBookingCustomerTable(List<Customer> customers) {
        DefaultTableModel model = (DefaultTableModel) bookingCustomerTable.getModel();
        model.setRowCount(0);
        for (Customer customer : customers) {
            model.addRow(new Object[]{
                customer.getCustomerId(),
                customer.getCustomerFname(),
                customer.getCustomerLname(),
                customer.getEmail(),
                customer.getPhoneNumber()
            });
        }
        if (customers.isEmpty()) {
            showErrorMessage("No customers found matching the criteria.");
        }
    }
    
    public void updateManageRoomTable(List<Room> roomList) {
        DefaultTableModel model = (DefaultTableModel) showRoomTable.getModel();
        model.setRowCount(0);
        for (Room room : roomList) {
            model.addRow(new Object[]{
                room.getRoomId(),
                room.getRoomNumber(),
                room.getRoomType(),
                room.getRoomPrice(),
                room.getStatus()
            });
        }
    }

    public void updateBookingRoomTable(List<Room> rooms) {
        DefaultTableModel model = (DefaultTableModel) bookingRoomTable.getModel();
        model.setRowCount(0);
        for (Room room : rooms) {
            model.addRow(new Object[]{
                room.getRoomId(),
                room.getRoomNumber(),
                room.getRoomPrice(),
                room.getRoomType(),
                room.getStatus(),
            });
        }
    }
    
    public void showInfoMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jSplitPane1 = new javax.swing.JSplitPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        roomBookingTab = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        typeSingleButton = new javax.swing.JRadioButton();
        typeDoubleButton = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        searchRoomButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        bookingRoomTable = new javax.swing.JTable();
        selectRoomButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        labelFirstName = new javax.swing.JLabel();
        labelLastName = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        labelPhoneNumber = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        searchCustomerButton = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        emailFieldName = new javax.swing.JTextField();
        phoneNumberField = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        bookingCustomerTable = new javax.swing.JTable();
        jButton16 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jCalendar2 = new com.toedter.calendar.JCalendar();
        jCalendar3 = new com.toedter.calendar.JCalendar();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        roomCheckInTab = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        roomCheckOutTab = new javax.swing.JPanel();
        manageDataTab = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        customerPanel = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        manageCustomerTable = new javax.swing.JTable();
        roomPanel = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        showRoomTable = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Room Reservation Program");

        roomBookingTab.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 5, true));

        buttonGroup1.add(typeSingleButton);
        typeSingleButton.setText("Single");

        buttonGroup1.add(typeDoubleButton);
        typeDoubleButton.setText("Double");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Room Type :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("<html><u>Search Room Available</u></html>");

        searchRoomButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        searchRoomButton.setText("Search");
        searchRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchRoomButtonActionPerformed(evt);
            }
        });

        bookingRoomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Room Id", "Room Number", "Price Per Night", "Type", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(bookingRoomTable);
        if (bookingRoomTable.getColumnModel().getColumnCount() > 0) {
            bookingRoomTable.getColumnModel().getColumn(0).setResizable(false);
            bookingRoomTable.getColumnModel().getColumn(1).setResizable(false);
            bookingRoomTable.getColumnModel().getColumn(2).setResizable(false);
            bookingRoomTable.getColumnModel().getColumn(3).setResizable(false);
            bookingRoomTable.getColumnModel().getColumn(4).setResizable(false);
        }

        selectRoomButton.setText("Select Room");
        selectRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectRoomButtonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Room :");

        jLabel7.setBackground(new java.awt.Color(255, 0, 0));
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Your selected room");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(typeSingleButton)
                                .addGap(18, 18, 18)
                                .addComponent(typeDoubleButton)
                                .addGap(26, 26, 26)
                                .addComponent(searchRoomButton))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(selectRoomButton)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(typeSingleButton)
                    .addComponent(typeDoubleButton)
                    .addComponent(searchRoomButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectRoomButton)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        jPanel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 5, true));
        jPanel10.setPreferredSize(new java.awt.Dimension(527, 408));

        jButton14.setText("Submit Reservation");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText(" Summary");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("Date Information");

        jLabel30.setText("Check-In Date :");

        jLabel31.setText("Check-Out Date :");

        jLabel32.setForeground(new java.awt.Color(255, 0, 0));
        jLabel32.setText("Init date");

        jLabel33.setForeground(new java.awt.Color(255, 0, 51));
        jLabel33.setText("Init date");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel33))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setText("Room Information");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setText("Room Number :");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setText("Room Type :");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setText("Price Per Night :");

        jLabel27.setForeground(new java.awt.Color(255, 0, 0));
        jLabel27.setText("none");

        jLabel28.setForeground(new java.awt.Color(255, 0, 0));
        jLabel28.setText("none");

        jLabel29.setForeground(new java.awt.Color(255, 0, 0));
        jLabel29.setText("none");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel23)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel29))
                .addContainerGap())
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("First Name :");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Last Name :");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Email :");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Phone Number :");

        labelFirstName.setForeground(new java.awt.Color(255, 0, 0));
        labelFirstName.setText("none");

        labelLastName.setForeground(new java.awt.Color(255, 0, 0));
        labelLastName.setText("none");

        labelEmail.setForeground(new java.awt.Color(255, 0, 0));
        labelEmail.setText("none");

        labelPhoneNumber.setForeground(new java.awt.Color(255, 0, 0));
        labelPhoneNumber.setText("none");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Customer Information");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(labelFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelPhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 140, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(labelFirstName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(labelLastName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(labelEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(labelPhoneNumber)))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(66, 66, 66))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(320, 320, 320))
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(451, 451, 451)
                .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(36, 36, 36))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 5, true));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("<html><u>Search Customer</u></html>");

        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton12.setText("Add New Customer");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setLabelFor(phoneNumberField);
        jLabel21.setText("Phone Number :");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setLabelFor(emailFieldName);
        jLabel20.setText("Email :");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setLabelFor(lastNameField);
        jLabel19.setText("Last Name :");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setLabelFor(firstNameField);
        jLabel18.setText("First Name :");

        searchCustomerButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        searchCustomerButton.setText("Search");
        searchCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCustomerButtonActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 51, 51));
        jLabel22.setText("* Filling in all fields is not mandatory.");

        bookingCustomerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Customer Id", "First Name", "Last Name", "Email", "Phone Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(bookingCustomerTable);
        if (bookingCustomerTable.getColumnModel().getColumnCount() > 0) {
            bookingCustomerTable.getColumnModel().getColumn(0).setResizable(false);
            bookingCustomerTable.getColumnModel().getColumn(1).setResizable(false);
            bookingCustomerTable.getColumnModel().getColumn(2).setResizable(false);
            bookingCustomerTable.getColumnModel().getColumn(3).setResizable(false);
            bookingCustomerTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jButton16.setText("Select");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Customer :");

        jLabel14.setForeground(new java.awt.Color(255, 0, 51));
        jLabel14.setText("Your selected customer");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(firstNameField)
                            .addComponent(lastNameField)
                            .addComponent(emailFieldName)
                            .addComponent(phoneNumberField, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(searchCustomerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jButton16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(emailFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(phoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(searchCustomerButton))
                .addGap(9, 9, 9)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton16)
                    .addComponent(jLabel3)
                    .addComponent(jLabel14))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton12)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 5, true));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Check-In Date");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Check-Out Date");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setText("<html><u>Date Information</u></html>");

        jButton4.setText("Submit Date");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCalendar2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCalendar3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(9, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCalendar3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCalendar2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout roomBookingTabLayout = new javax.swing.GroupLayout(roomBookingTab);
        roomBookingTab.setLayout(roomBookingTabLayout);
        roomBookingTabLayout.setHorizontalGroup(
            roomBookingTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomBookingTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roomBookingTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        roomBookingTabLayout.setVerticalGroup(
            roomBookingTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomBookingTabLayout.createSequentialGroup()
                .addGroup(roomBookingTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roomBookingTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 25, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Room Booking", roomBookingTab);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout roomCheckInTabLayout = new javax.swing.GroupLayout(roomCheckInTab);
        roomCheckInTab.setLayout(roomCheckInTabLayout);
        roomCheckInTabLayout.setHorizontalGroup(
            roomCheckInTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomCheckInTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(623, Short.MAX_VALUE))
        );
        roomCheckInTabLayout.setVerticalGroup(
            roomCheckInTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomCheckInTabLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 342, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Room Check-In", roomCheckInTab);

        javax.swing.GroupLayout roomCheckOutTabLayout = new javax.swing.GroupLayout(roomCheckOutTab);
        roomCheckOutTab.setLayout(roomCheckOutTabLayout);
        roomCheckOutTabLayout.setHorizontalGroup(
            roomCheckOutTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1178, Short.MAX_VALUE)
        );
        roomCheckOutTabLayout.setVerticalGroup(
            roomCheckOutTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 781, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Room Check-Out", roomCheckOutTab);

        jSplitPane2.setDividerLocation(150);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Rooms");
        jButton1.setName("Add Room"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton7.setText("Customers");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 593, Short.MAX_VALUE))
        );

        jSplitPane2.setLeftComponent(jPanel3);

        mainPanel.setLayout(new java.awt.CardLayout());

        customerPanel.setAutoscrolls(true);

        jButton8.setText("Add Customer");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit Customer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton9.setText("Delete Customer");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jScrollPane4.setPreferredSize(new java.awt.Dimension(456, 406));

        manageCustomerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Customer Id", "First Name", "Last Name", "Email", "Phone Number"
            }
        ));
        jScrollPane4.setViewportView(manageCustomerTable);

        javax.swing.GroupLayout customerPanelLayout = new javax.swing.GroupLayout(customerPanel);
        customerPanel.setLayout(customerPanelLayout);
        customerPanelLayout.setHorizontalGroup(
            customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1005, Short.MAX_VALUE)
                    .addGroup(customerPanelLayout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        customerPanelLayout.setVerticalGroup(
            customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE))
        );

        mainPanel.add(customerPanel, "panel2");

        roomPanel.setAutoscrolls(true);

        jButton5.setText("Add Room");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Edit Room");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        showRoomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Room ID", "Room Number", "Room Type", "Price", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(showRoomTable);
        if (showRoomTable.getColumnModel().getColumnCount() > 0) {
            showRoomTable.getColumnModel().getColumn(0).setResizable(false);
            showRoomTable.getColumnModel().getColumn(1).setResizable(false);
            showRoomTable.getColumnModel().getColumn(2).setResizable(false);
            showRoomTable.getColumnModel().getColumn(3).setResizable(false);
            showRoomTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jButton3.setText("Delete Room");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roomPanelLayout = new javax.swing.GroupLayout(roomPanel);
        roomPanel.setLayout(roomPanelLayout);
        roomPanelLayout.setHorizontalGroup(
            roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1005, Short.MAX_VALUE)
                    .addGroup(roomPanelLayout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        roomPanelLayout.setVerticalGroup(
            roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE))
        );

        mainPanel.add(roomPanel, "panel1");

        jSplitPane2.setRightComponent(mainPanel);

        javax.swing.GroupLayout manageDataTabLayout = new javax.swing.GroupLayout(manageDataTab);
        manageDataTab.setLayout(manageDataTabLayout);
        manageDataTabLayout.setHorizontalGroup(
            manageDataTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageDataTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane2)
                .addContainerGap())
        );
        manageDataTabLayout.setVerticalGroup(
            manageDataTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageDataTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane2)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Manage Data", manageDataTab);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int selectedRow = this.showRoomTable.getSelectedRow();

        if (selectedRow != -1) {
            int roomId = (int) this.showRoomTable.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(null,
                "Are you sure to delete this room?",
                "Confirm",
                JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                this.roomController.handleRoomDeletion(roomId);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int selectedRow = this.showRoomTable.getSelectedRow();

        if (selectedRow != -1) {
            int roomId = (int) this.showRoomTable.getValueAt(selectedRow, 0);
            String roomNumber = this.showRoomTable.getValueAt(selectedRow, 1).toString();
            String roomType = this.showRoomTable.getValueAt(selectedRow, 2).toString();
            double price_per_night = (double) this.showRoomTable.getValueAt(selectedRow, 3);
            String status = this.showRoomTable.getValueAt(selectedRow, 4).toString();
            Room selectedRoom = new Room(roomId, roomNumber, roomType, price_per_night, status);
            new EditRoomGUI(selectedRoom, this.roomController).setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to edit.");
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new AddRoomGUI(this.roomController).setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int selectedRow = this.manageCustomerTable.getSelectedRow();
        if (selectedRow != -1) {
            int roomId = (int) this.manageCustomerTable.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure to delete this customer?",
                "Confirm",
                JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                this.customerController.handleCustomerDeletion(roomId);
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int selectedRow = this.manageCustomerTable.getSelectedRow();

        if (selectedRow != -1) {
            int customerId = (int) this.manageCustomerTable.getValueAt(selectedRow, 0);
            String customerFname = this.manageCustomerTable.getValueAt(selectedRow, 1).toString();
            String customerLname = this.manageCustomerTable.getValueAt(selectedRow, 2).toString();
            String email = this.manageCustomerTable.getValueAt(selectedRow, 3).toString();
            String phoneNumber = this.manageCustomerTable.getValueAt(selectedRow, 4).toString();
            Customer selectedCustomer = new Customer(customerId, customerFname, customerLname, email, phoneNumber);
            new EditCustomerGUI(selectedCustomer, this.customerController).setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to edit.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        new AddCustomerGUI(this.customerController).setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        CardLayout card = (CardLayout) this.mainPanel.getLayout();
        card.show(this.mainPanel, "panel2");
        this.customerController.refreshManageCustomerTable();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CardLayout card = (CardLayout) this.mainPanel.getLayout();
        card.show(this.mainPanel, "panel1");
        this.roomController.refreshManageRoomTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchRoomButtonActionPerformed
        JRadioButton[] radioButtons = { this.typeSingleButton, this.typeDoubleButton };

        for (JRadioButton button : radioButtons) {
            if (button.isSelected()) {
                this.roomController.handleSearchRoomAvailableByType(button.getText());
                break;
            }
        }
    }//GEN-LAST:event_searchRoomButtonActionPerformed

    private void selectRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectRoomButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = this.bookingRoomTable.getSelectedRow();
        
        if (selectedRow != -1) {
            int roomId = (int) this.bookingRoomTable.getModel().getValueAt(selectedRow, 0);
            String roomNumber = this.bookingRoomTable.getValueAt(selectedRow, 1).toString();
            double pricePerNight = Double.parseDouble(this.bookingRoomTable.getValueAt(selectedRow, 2).toString());
            String roomType = this.bookingRoomTable.getModel().getValueAt(selectedRow, 3).toString();
            String status = this.bookingRoomTable.getValueAt(selectedRow, 4).toString();
            
            this.roomSelected = new Room(roomId, roomNumber, roomType, pricePerNight, status);
//            System.out.println("RoomID = " + this.roomSelected.getRoomId() + "\n"
//                               + "RoomNumber = " + this.roomSelected.getRoomNumber() + "\n"
//                               + "PricePerNight = " + this.roomSelected.getRoomPrice() + "\n"
//                               + "RoomType = " + this.roomSelected.getRoomType() + "\n"
//                               + "Status = " + this.roomSelected.getStatus());
            
            this.jLabel7.setText(roomNumber);
            
            this.jLabel27.setText(roomNumber);
            this.jLabel28.setText(roomType);
            this.jLabel29.setText(String.valueOf(pricePerNight));
        }
    }//GEN-LAST:event_selectRoomButtonActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        if (this.roomSelected == null|| this.customerSelected == null) {
            this.showErrorMessage("Please select a customer and an available room first.");
        }
        
//        this.reservationController.handleReservation(customerSelected, roomSelected);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        int selectedRow = this.bookingCustomerTable.getSelectedRow();

        if (selectedRow != -1) {
            int customerId = (int) this.bookingCustomerTable.getModel().getValueAt(selectedRow, 0);
            String firstName = this.bookingCustomerTable.getValueAt(selectedRow, 1).toString();
            String lastName = this.bookingCustomerTable.getValueAt(selectedRow, 2).toString();
            String email = this.bookingCustomerTable.getValueAt(selectedRow, 3).toString();
            String phoneNumber = this.bookingCustomerTable.getValueAt(selectedRow, 4).toString();

            this.customerSelected = new Customer(customerId, firstName, lastName, email, phoneNumber);

            this.labelFirstName.setText(firstName);
            this.labelLastName.setText(lastName);
            this.labelEmail.setText(email);
            this.labelPhoneNumber.setText(phoneNumber);

        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to submit customer.");
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void searchCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCustomerButtonActionPerformed
        String firstNameFieldValue = this.firstNameField.getText();
        String lastNameFieldValue = this.lastNameField.getText();
        String emailFieldValue = this.emailFieldName.getText();
        String phoneNumberFieldValue = this.phoneNumberField.getText();

        this.customerController.handleCustomerSearching(firstNameFieldValue, lastNameFieldValue, emailFieldValue, phoneNumberFieldValue);
    }//GEN-LAST:event_searchCustomerButtonActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        new AddCustomerGUI(this.customerController).setVisible(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReservedRoomGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReservedRoomGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReservedRoomGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReservedRoomGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RoomController roomController = new RoomController();
                CustomerController customerController = new CustomerController();
               new ReservedRoomGUI(roomController, customerController).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bookingCustomerTable;
    private javax.swing.JTable bookingRoomTable;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel customerPanel;
    private javax.swing.JTextField emailFieldName;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JCalendar jCalendar1;
    private com.toedter.calendar.JCalendar jCalendar2;
    private com.toedter.calendar.JCalendar jCalendar3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelFirstName;
    private javax.swing.JLabel labelLastName;
    private javax.swing.JLabel labelPhoneNumber;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTable manageCustomerTable;
    private javax.swing.JPanel manageDataTab;
    private javax.swing.JTextField phoneNumberField;
    private javax.swing.JPanel roomBookingTab;
    private javax.swing.JPanel roomCheckInTab;
    private javax.swing.JPanel roomCheckOutTab;
    private javax.swing.JPanel roomPanel;
    private javax.swing.JButton searchCustomerButton;
    private javax.swing.JButton searchRoomButton;
    private javax.swing.JButton selectRoomButton;
    public javax.swing.JTable showRoomTable;
    private javax.swing.JRadioButton typeDoubleButton;
    private javax.swing.JRadioButton typeSingleButton;
    // End of variables declaration//GEN-END:variables
}
