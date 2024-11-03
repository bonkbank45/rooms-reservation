package com.mycompany.reservedroom.views;

/**
 *
 * @author thana
 */
import com.mycompany.reservedroom.controllers.CustomerController;
import com.mycompany.reservedroom.controllers.ReservationController;
import com.mycompany.reservedroom.controllers.RoomController;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import models.customer.Customer;
import models.reservation.ReservationInfomation;
import models.room.Room;

public class ReservedRoomGUI extends javax.swing.JFrame {

    private final RoomController roomController;
    private final CustomerController customerController;
    private final ReservationController reservationController;

    private Customer customerSelected;
    private Room roomSelected;

    private Date selectedCheckInDate;
    private Date selectedCheckOutDate;

    /**
     * Creates new form ReservedRoomGUI
     *
     * @param roomController
     * @param customerController
     * @param reservationController
     */
    public ReservedRoomGUI(RoomController roomController, CustomerController customerController, ReservationController reservationController) {
        initComponents();
        this.roomController = roomController;
        this.roomController.setView(this);

        this.customerController = customerController;
        this.customerController.setView(this);
        this.customerController.refreshManageCustomerTable();

        this.reservationController = reservationController;
        this.reservationController.setView(this);
        
        this.reservationController.refreshCheckInTable();
        this.reservationController.refreshCheckOutTable();
        this.roomController.refreshManageRoomTable();
        this.customerController.refreshManageCustomerTable();

        TableColumnModel roomCcolumnModel = reservationRoomTable.getColumnModel();
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

    public void resetRoomSelected() {
        this.roomSelected = null;
    }

    public void resetRoomTable() {
        DefaultTableModel table = (DefaultTableModel) this.reservationRoomTable.getModel();
        table.setRowCount(0);
    }

    public void resetRoomSelectedLabel() {
        this.jLabel7.setText("Your selected room");
        this.jLabel27.setText("none");
        this.jLabel28.setText("none");
        this.jLabel29.setText("none");
    }

    public String getSelectedRoomType() {
        JRadioButton[] radioButtons = {this.typeSingleButton, this.typeDoubleButton};

        for (JRadioButton button : radioButtons) {
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return "Single";
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
        return this.reservationRoomTable.getModel();
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

    public void updateReservationCustomerTable(List<Customer> customers) {
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
//        if (customers.isEmpty()) {
//            showErrorMessage("No customers found matching the criteria.");
//        }
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

    public void updateReservationRoomTable(List<Room> rooms) {
        DefaultTableModel model = (DefaultTableModel) reservationRoomTable.getModel();
        model.setRowCount(0);
        for (Room room : rooms) {
            model.addRow(new Object[]{
                room.getRoomId(),
                room.getRoomNumber(),
                room.getRoomPrice(),
                room.getRoomType(),
                room.getStatus(),});
        }
    }
    
    public void updateCheckInTable(List<ReservationInfomation> reservations) {
        DefaultTableModel model = (DefaultTableModel) checkInRoomTable.getModel();
        model.setRowCount(0);
        for (ReservationInfomation reservation : reservations) {
            model.addRow(new Object[] {
                reservation.getReservationId(),
                reservation.getCustomerFirstName(),
                reservation.getCustomerEmail(),
                reservation.getRoomNumber(),
                reservation.getCheckInDate(),
                reservation.getCheckOutDate(),
                reservation.getReservationDate(),
                reservation.getReservationStatus(),
            });
        }
    }
    
    public void updateCheckOutTable(List<ReservationInfomation> reservations) {
        DefaultTableModel model = (DefaultTableModel) checkOutRoomTable.getModel();
        model.setRowCount(0);
        for (ReservationInfomation reservation : reservations) {
            model.addRow(new Object[] {
                reservation.getReservationId(),
                reservation.getCustomerFirstName(),
                reservation.getCustomerEmail(),
                reservation.getRoomNumber(),
                reservation.getCheckInDate(),
                reservation.getCheckOutDate(),
                reservation.getReservationDate(),
                reservation.getReservationStatus(),
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
        reservationRoomTable = new javax.swing.JTable();
        selectRoomButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        submitReservationButton = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        checkInLabel = new javax.swing.JLabel();
        checkOutLabel = new javax.swing.JLabel();
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
        addNewCustomerResButton = new javax.swing.JButton();
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
        selectCustomerButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        selectedCustomerLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        checkInCalendar = new com.toedter.calendar.JCalendar();
        checkOutCalendar = new com.toedter.calendar.JCalendar();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        submitDateButton = new javax.swing.JButton();
        roomCheckInTab = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        checkInRoomTable = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        submitCheckInButton = new javax.swing.JButton();
        cancelReservationButton = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        roomCheckOutTab = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        checkOutRoomTable = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        submitCheckOutButton = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        manageDataTab = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        showRoomsManageButton = new javax.swing.JButton();
        showCustomersManageButton = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        customerPanel = new javax.swing.JPanel();
        addCustomerManageButton = new javax.swing.JButton();
        editCustomerButton = new javax.swing.JButton();
        deleteCustomerButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        manageCustomerTable = new javax.swing.JTable();
        roomPanel = new javax.swing.JPanel();
        addRoomButton = new javax.swing.JButton();
        editRoomButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        showRoomTable = new javax.swing.JTable();
        deleteRoomButton = new javax.swing.JButton();
        refreshManageRoomButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Room Reservation Program");

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        roomBookingTab.setBackground(new java.awt.Color(255, 255, 255));
        roomBookingTab.setMaximumSize(new java.awt.Dimension(1080, 1920));

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

        reservationRoomTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(reservationRoomTable);
        if (reservationRoomTable.getColumnModel().getColumnCount() > 0) {
            reservationRoomTable.getColumnModel().getColumn(0).setResizable(false);
            reservationRoomTable.getColumnModel().getColumn(1).setResizable(false);
            reservationRoomTable.getColumnModel().getColumn(2).setResizable(false);
            reservationRoomTable.getColumnModel().getColumn(3).setResizable(false);
            reservationRoomTable.getColumnModel().getColumn(4).setResizable(false);
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

        submitReservationButton.setText("Submit Reservation");
        submitReservationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitReservationButtonActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText(" Summary");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("Date Information");

        jLabel30.setText("Check-In Date :");

        jLabel31.setText("Check-Out Date :");

        checkInLabel.setForeground(new java.awt.Color(255, 0, 0));
        checkInLabel.setText("Select your Check-In Date.");

        checkOutLabel.setForeground(new java.awt.Color(255, 0, 51));
        checkOutLabel.setText("Select your Check-Out Date.");

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
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(checkInLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(checkOutLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))))
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
                    .addComponent(checkInLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(checkOutLabel))
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
                        .addGap(273, 273, 273))
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(451, 451, 451)
                .addComponent(submitReservationButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(submitReservationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 5, true));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("<html><u>Search Customer</u></html>");

        addNewCustomerResButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addNewCustomerResButton.setText("Add New Customer");
        addNewCustomerResButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewCustomerResButtonActionPerformed(evt);
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

        selectCustomerButton.setText("Select");
        selectCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCustomerButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Customer :");

        selectedCustomerLabel.setForeground(new java.awt.Color(255, 0, 51));
        selectedCustomerLabel.setText("Your selected customer");

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
                                .addComponent(selectCustomerButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectedCustomerLabel)))
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
                    .addComponent(selectCustomerButton)
                    .addComponent(jLabel3)
                    .addComponent(selectedCustomerLabel))
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
                        .addComponent(addNewCustomerResButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addNewCustomerResButton)
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

        submitDateButton.setText("Submit Date");
        submitDateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitDateButtonActionPerformed(evt);
            }
        });

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
                            .addComponent(checkInCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkOutCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(9, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submitDateButton)
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
                        .addComponent(checkOutCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkInCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitDateButton)
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
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
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
                .addContainerGap(9808, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Adding Room Reservation", roomBookingTab);

        checkInRoomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Reservation ID", "First Name", "Email", "Room Number", "Check-In Date", "Check-Out Date", "Reservation Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(checkInRoomTable);

        submitCheckInButton.setText("Check-In Room");
        submitCheckInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitCheckInButtonActionPerformed(evt);
            }
        });

        cancelReservationButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelReservationButton.setForeground(new java.awt.Color(255, 0, 0));
        cancelReservationButton.setText("Cancel Reservation");
        cancelReservationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelReservationButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(submitCheckInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(cancelReservationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cancelReservationButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(submitCheckInButton, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel14.setText("Room Reservation Information");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                                .addGap(864, 864, 864))
                            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(3, 3, 3))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 3566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout roomCheckInTabLayout = new javax.swing.GroupLayout(roomCheckInTab);
        roomCheckInTab.setLayout(roomCheckInTabLayout);
        roomCheckInTabLayout.setHorizontalGroup(
            roomCheckInTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomCheckInTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roomCheckInTabLayout.setVerticalGroup(
            roomCheckInTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomCheckInTabLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6820, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Room Check-In", roomCheckInTab);

        checkOutRoomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Reservation ID", "First Name", "Email", "Room Number", "Check-In Date", "Check-Out Date", "Reservation Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(checkOutRoomTable);

        submitCheckOutButton.setText("Check-Out Room");
        submitCheckOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitCheckOutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(submitCheckOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(submitCheckOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel33.setText("Room Check-In Information");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                        .addGap(864, 864, 864))
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane8))
                .addGap(3, 3, 3))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 3566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout roomCheckOutTabLayout = new javax.swing.GroupLayout(roomCheckOutTab);
        roomCheckOutTab.setLayout(roomCheckOutTabLayout);
        roomCheckOutTabLayout.setHorizontalGroup(
            roomCheckOutTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomCheckOutTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roomCheckOutTabLayout.setVerticalGroup(
            roomCheckOutTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomCheckOutTabLayout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6820, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Room Check-Out", roomCheckOutTab);

        jSplitPane2.setDividerLocation(150);

        showRoomsManageButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        showRoomsManageButton.setText("Rooms");
        showRoomsManageButton.setName("Add Room"); // NOI18N
        showRoomsManageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRoomsManageButtonActionPerformed(evt);
            }
        });

        showCustomersManageButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        showCustomersManageButton.setText("Customers");
        showCustomersManageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showCustomersManageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(showRoomsManageButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(showCustomersManageButton, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(showRoomsManageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showCustomersManageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10376, Short.MAX_VALUE))
        );

        jSplitPane2.setLeftComponent(jPanel3);

        mainPanel.setLayout(new java.awt.CardLayout());

        customerPanel.setAutoscrolls(true);

        addCustomerManageButton.setText("Add Customer");
        addCustomerManageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustomerManageButtonActionPerformed(evt);
            }
        });

        editCustomerButton.setText("Edit Customer");
        editCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCustomerButtonActionPerformed(evt);
            }
        });

        deleteCustomerButton.setText("Delete Customer");
        deleteCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCustomerButtonActionPerformed(evt);
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
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1238, Short.MAX_VALUE)
                    .addGroup(customerPanelLayout.createSequentialGroup()
                        .addComponent(addCustomerManageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editCustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteCustomerButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        customerPanelLayout.setVerticalGroup(
            customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCustomerManageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editCustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteCustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 10481, Short.MAX_VALUE))
        );

        mainPanel.add(customerPanel, "panel2");

        roomPanel.setAutoscrolls(true);

        addRoomButton.setText("Add Room");
        addRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRoomButtonActionPerformed(evt);
            }
        });

        editRoomButton.setText("Edit Room");
        editRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRoomButtonActionPerformed(evt);
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

        deleteRoomButton.setText("Delete Room");
        deleteRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRoomButtonActionPerformed(evt);
            }
        });

        refreshManageRoomButton.setText("Refresh");
        refreshManageRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshManageRoomButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roomPanelLayout = new javax.swing.GroupLayout(roomPanel);
        roomPanel.setLayout(roomPanelLayout);
        roomPanelLayout.setHorizontalGroup(
            roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1238, Short.MAX_VALUE)
                    .addGroup(roomPanelLayout.createSequentialGroup()
                        .addComponent(addRoomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editRoomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteRoomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshManageRoomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        roomPanelLayout.setVerticalGroup(
            roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addRoomButton, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                        .addComponent(refreshManageRoomButton))
                    .addComponent(editRoomButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteRoomButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 10481, Short.MAX_VALUE))
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

    private void deleteRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRoomButtonActionPerformed
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
    }//GEN-LAST:event_deleteRoomButtonActionPerformed

    private void editRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRoomButtonActionPerformed
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

    }//GEN-LAST:event_editRoomButtonActionPerformed

    private void addRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRoomButtonActionPerformed
        new AddRoomGUI(this.roomController).setVisible(true);
    }//GEN-LAST:event_addRoomButtonActionPerformed

    private void deleteCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCustomerButtonActionPerformed
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
    }//GEN-LAST:event_deleteCustomerButtonActionPerformed

    private void editCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCustomerButtonActionPerformed
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
    }//GEN-LAST:event_editCustomerButtonActionPerformed

    private void addCustomerManageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustomerManageButtonActionPerformed
        new AddCustomerGUI(this.customerController).setVisible(true);
    }//GEN-LAST:event_addCustomerManageButtonActionPerformed

    private void showCustomersManageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showCustomersManageButtonActionPerformed
        CardLayout card = (CardLayout) this.mainPanel.getLayout();
        card.show(this.mainPanel, "panel2");
    }//GEN-LAST:event_showCustomersManageButtonActionPerformed

    private void showRoomsManageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showRoomsManageButtonActionPerformed
        CardLayout card = (CardLayout) this.mainPanel.getLayout();
        card.show(this.mainPanel, "panel1");
    }//GEN-LAST:event_showRoomsManageButtonActionPerformed

    private void searchRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchRoomButtonActionPerformed
        JRadioButton[] radioButtons = {this.typeSingleButton, this.typeDoubleButton};

        for (JRadioButton button : radioButtons) {
            if (button.isSelected()) {
                this.roomController.handleSearchRoomAvailableByType(button.getText());
                break;
            }
        }
    }//GEN-LAST:event_searchRoomButtonActionPerformed

    private void selectRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectRoomButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = this.reservationRoomTable.getSelectedRow();

        if (selectedRow != -1) {
            int roomId = (int) this.reservationRoomTable.getModel().getValueAt(selectedRow, 0);
            String roomNumber = this.reservationRoomTable.getValueAt(selectedRow, 1).toString();
            double pricePerNight = Double.parseDouble(this.reservationRoomTable.getValueAt(selectedRow, 2).toString());
            String roomType = this.reservationRoomTable.getModel().getValueAt(selectedRow, 3).toString();
            String status = this.reservationRoomTable.getValueAt(selectedRow, 4).toString();

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
        } else {
            this.showInfoMessage("Please select a row to submit room.");
        }
    }//GEN-LAST:event_selectRoomButtonActionPerformed

    private void submitReservationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitReservationButtonActionPerformed
        if (this.roomSelected == null || this.customerSelected == null) {
            this.showErrorMessage("Please select a customer and an available room first.");
            return;
        }

        if (this.selectedCheckInDate == null & this.selectedCheckOutDate == null) {
            this.showErrorMessage("Please select Check-In date and Check-Out date first.");
            return;
        }

        this.reservationController.handleMakeReservation(this.customerSelected.getCustomerId(), this.roomSelected.getRoomId(), this.selectedCheckInDate, this.selectedCheckOutDate);
    }//GEN-LAST:event_submitReservationButtonActionPerformed

    private void selectCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCustomerButtonActionPerformed
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

            this.selectedCustomerLabel.setText(firstName);
        } else {
            this.showInfoMessage("Please select a row to submit customer.");
        }
    }//GEN-LAST:event_selectCustomerButtonActionPerformed

    private void searchCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCustomerButtonActionPerformed
        String firstNameFieldValue = this.firstNameField.getText();
        String lastNameFieldValue = this.lastNameField.getText();
        String emailFieldValue = this.emailFieldName.getText();
        String phoneNumberFieldValue = this.phoneNumberField.getText();

        this.customerController.handleCustomerSearching(firstNameFieldValue, lastNameFieldValue, emailFieldValue, phoneNumberFieldValue);
    }//GEN-LAST:event_searchCustomerButtonActionPerformed

    private void addNewCustomerResButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewCustomerResButtonActionPerformed
        new AddCustomerGUI(this.customerController).setVisible(true);
    }//GEN-LAST:event_addNewCustomerResButtonActionPerformed

    private void submitDateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitDateButtonActionPerformed
        this.selectedCheckInDate = this.checkInCalendar.getDate();
        this.selectedCheckOutDate = this.checkOutCalendar.getDate();

        Date today = this.getTodayDate();

        if (this.selectedCheckInDate == null || this.selectedCheckOutDate == null) {
            this.showInfoMessage("Please select both check-in and check-out dates.");
            return;
        }
        if (this.selectedCheckInDate.before(today)) {
            this.showErrorMessage("Check-in date can't be before today.");
            this.resetDateLabel();
            this.resetDate();
            return;
        }
        if (this.selectedCheckOutDate.before(selectedCheckInDate)) {
            this.showErrorMessage("Check-in date must be before check-out date.");
            this.resetDateLabel();
            this.resetDate();
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.checkInLabel.setText(dateFormat.format(this.selectedCheckInDate));
        this.checkOutLabel.setText(dateFormat.format(this.selectedCheckOutDate));
    }//GEN-LAST:event_submitDateButtonActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
//        this.reservationController.refreshCheckInTable();
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void submitCheckInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitCheckInButtonActionPerformed
        int selectedRow = this.checkInRoomTable.getSelectedRow();

        if (selectedRow != -1) {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Are you sure to Check-In this Reservation?",
                    "Confirm",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                this.reservationController.handleMakeCheckIn((int) this.checkInRoomTable.getValueAt(selectedRow, 0));
            }
        } else {
            this.showInfoMessage("Please select a row to submit check-in.");
        }
    }//GEN-LAST:event_submitCheckInButtonActionPerformed

    private void submitCheckOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitCheckOutButtonActionPerformed
        int selectedRow = this.checkOutRoomTable.getSelectedRow();

        if (selectedRow != -1) {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Are you sure to Check-Out this Reservation?",
                    "Confirm",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                this.reservationController.handleMakeCheckOut(
                        (int) this.checkOutRoomTable.getValueAt(selectedRow, 0), 
                        this.checkOutRoomTable.getValueAt(selectedRow, 3).toString());
            }
        } else {
            this.showInfoMessage("Please select a row to submit check-out.");
        }
    }//GEN-LAST:event_submitCheckOutButtonActionPerformed

    private void refreshManageRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshManageRoomButtonActionPerformed
        this.roomController.refreshManageRoomTable();
    }//GEN-LAST:event_refreshManageRoomButtonActionPerformed

    private void cancelReservationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelReservationButtonActionPerformed
        int selectedRow = this.checkInRoomTable.getSelectedRow();
        if (selectedRow != -1) {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Are you sure to cancel this reservation?",
                    "Confirm",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                this.reservationController.handleMakeCancel(
                        (int) this.checkInRoomTable.getValueAt(selectedRow, 0), 
                        this.checkInRoomTable.getValueAt(selectedRow, 3).toString());
            }
        } else {
            this.showInfoMessage("Please select a row to cancel reservation");
        }
    }//GEN-LAST:event_cancelReservationButtonActionPerformed

    private Date getTodayDate() {
        Calendar todayCalendar = Calendar.getInstance();
        todayCalendar.set(Calendar.HOUR_OF_DAY, 0);
        todayCalendar.set(Calendar.MINUTE, 0);
        todayCalendar.set(Calendar.SECOND, 0);
        todayCalendar.set(Calendar.MILLISECOND, 0);
        return todayCalendar.getTime();
    }

    private void resetDate() {
        this.selectedCheckInDate = null;
        this.selectedCheckOutDate = null;
    }

    private void resetDateLabel() {
        this.checkInLabel.setText("Init date");
        this.checkOutLabel.setText("Init date");
    }

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
                ReservationController reservationController = new ReservationController();
                new ReservedRoomGUI(roomController, customerController, reservationController).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCustomerManageButton;
    private javax.swing.JButton addNewCustomerResButton;
    private javax.swing.JButton addRoomButton;
    private javax.swing.JTable bookingCustomerTable;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelReservationButton;
    private com.toedter.calendar.JCalendar checkInCalendar;
    private javax.swing.JLabel checkInLabel;
    private javax.swing.JTable checkInRoomTable;
    private com.toedter.calendar.JCalendar checkOutCalendar;
    private javax.swing.JLabel checkOutLabel;
    private javax.swing.JTable checkOutRoomTable;
    private javax.swing.JPanel customerPanel;
    private javax.swing.JButton deleteCustomerButton;
    private javax.swing.JButton deleteRoomButton;
    private javax.swing.JButton editCustomerButton;
    private javax.swing.JButton editRoomButton;
    private javax.swing.JTextField emailFieldName;
    private javax.swing.JTextField firstNameField;
    private com.toedter.calendar.JCalendar jCalendar1;
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
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
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
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
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
    private javax.swing.JButton refreshManageRoomButton;
    private javax.swing.JTable reservationRoomTable;
    private javax.swing.JPanel roomBookingTab;
    private javax.swing.JPanel roomCheckInTab;
    private javax.swing.JPanel roomCheckOutTab;
    private javax.swing.JPanel roomPanel;
    private javax.swing.JButton searchCustomerButton;
    private javax.swing.JButton searchRoomButton;
    private javax.swing.JButton selectCustomerButton;
    private javax.swing.JButton selectRoomButton;
    private javax.swing.JLabel selectedCustomerLabel;
    private javax.swing.JButton showCustomersManageButton;
    public javax.swing.JTable showRoomTable;
    private javax.swing.JButton showRoomsManageButton;
    private javax.swing.JButton submitCheckInButton;
    private javax.swing.JButton submitCheckOutButton;
    private javax.swing.JButton submitDateButton;
    private javax.swing.JButton submitReservationButton;
    private javax.swing.JRadioButton typeDoubleButton;
    private javax.swing.JRadioButton typeSingleButton;
    // End of variables declaration//GEN-END:variables
}
