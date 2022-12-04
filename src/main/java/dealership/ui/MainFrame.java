/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dealership.ui;

import dealership.controller.AccountHandler;
import dealership.controller.VehicleHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MenuScreen
     */
    public MainFrame() {
        initComponents();
        initInventory();

        if (AccountHandler.isLoggedIn()) {
            statusLabel.setText("Hi there, " + AccountHandler.getLoggedInName() + "!");
            accountButton.setText("Log Out");
            deleteAppointmentButton.setEnabled(true);
            if (AccountHandler.isEmployee()) {
                //remove appointments tab
                jTabbedPane.removeTabAt(1);
                appointmentAndSaleButton.setText("Conduct Sale");
                initSales();
            } else {
                //remove sales tab
                jTabbedPane.removeTabAt(2);
                appointmentAndSaleButton.setText("Schedule Test Drive");
                initAppointments();
            }
        } else {
            jTabbedPane.removeTabAt(1);
            jTabbedPane.removeTabAt(1);
            statusLabel.setText("Not Logged In");
        }
    }

    // Gets previous frame's location on screen
    public void getPreviousFrameLocation(Point previous) {
        this.setLocation(previous);
    }

    // Fill table for car inventory
    private void initInventory() {
        VehicleHandler.loadStylesIntoComboBox(styleFilterOption);
        VehicleHandler.loadMakesIntoComboBox(makeFilterOption);
        VehicleHandler.loadColorsIntoComboBox(colorFilterOption);

        inventoryTable.setModel(new DefaultTableModel(new Object[]{"Year", "Make", "Model", "Style", "Color", "Mileage", "Price"}, 0) {
            @Override
            //Prevent editing cells of the table
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        VehicleHandler.loadVehiclesIntoTable((DefaultTableModel) inventoryTable.getModel());

        inventoryTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        ((JLabel) inventoryTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);
        inventoryTable.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String sortBy = inventoryTable.getColumnName(inventoryTable.columnAtPoint(e.getPoint()));
                if (sortBy.equals("Price")) {
                    sortBy = "listing_price";
                } else {
                    sortBy = sortBy.toLowerCase();
                }
                VehicleHandler.getFilter().setSortBy(sortBy);
                VehicleHandler.loadVehiclesIntoTable((DefaultTableModel) inventoryTable.getModel());
            }
        });

        //inventoryTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        //inventoryTable.getColumnModel().getColumn(4).setPreferredWidth(40);
        //inventoryTable.getColumnModel().getColumn(5).setPreferredWidth(40);
        //inventoryTable.getColumnModel().getColumn(6).setPreferredWidth(40);
        inventoryTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        inventoryTable.getTableHeader().setResizingAllowed(false);
        inventoryTable.getTableHeader().setReorderingAllowed(false);
    }

    // Fill table for appointment table
    private void initAppointments() {
        appointmentTable.setModel(new DefaultTableModel(new Object[]{"Date", "Time", "Vehicle"}, 0) {
            @Override
            //Prevent editing cells of the table
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        AccountHandler.loadAppointmentsIntoTable((DefaultTableModel) appointmentTable.getModel());
        appointmentTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        ((JLabel) appointmentTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);
        appointmentTable.getColumnModel().getColumn(0).setPreferredWidth(appointmentTable.getWidth() / 4);
        appointmentTable.getColumnModel().getColumn(1).setPreferredWidth(appointmentTable.getWidth() / 4);
        appointmentTable.getColumnModel().getColumn(2).setPreferredWidth(appointmentTable.getWidth() / 2);
        appointmentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        appointmentTable.getTableHeader().setResizingAllowed(false);
        appointmentTable.getTableHeader().setReorderingAllowed(false);
    }

    private  void initSales() {
        salesTable.setModel(new DefaultTableModel(new Object[]{"Date", "Vehicle", "Customer", "Sale Amount", "Commission"}, 0) {
            @Override
            //Prevent editing cells of the table
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        AccountHandler.loadSalesIntoTable((DefaultTableModel) salesTable.getModel());
        salesTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        ((JLabel) salesTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);

        salesTable.getColumnModel().getColumn(0).setPreferredWidth(salesTable.getWidth() / 6);
        salesTable.getColumnModel().getColumn(1).setPreferredWidth(salesTable.getWidth() / 3);
        salesTable.getColumnModel().getColumn(2).setPreferredWidth(salesTable.getWidth() / 6);
        salesTable.getColumnModel().getColumn(3).setPreferredWidth(salesTable.getWidth() / 6);
        salesTable.getColumnModel().getColumn(4).setPreferredWidth(salesTable.getWidth() / 6);

        salesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        salesTable.getTableHeader().setResizingAllowed(false);
        salesTable.getTableHeader().setReorderingAllowed(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane = new javax.swing.JTabbedPane();
        jPanelInventory = new javax.swing.JPanel();
        inventoryScrollPane = new javax.swing.JScrollPane();
        inventoryTable = new javax.swing.JTable();
        appointmentAndSaleButton = new javax.swing.JButton();
        styleLabel = new javax.swing.JLabel();
        styleFilterOption = new javax.swing.JComboBox<>();
        makeLabel = new javax.swing.JLabel();
        makeFilterOption = new javax.swing.JComboBox<>();
        modelFilterOption = new javax.swing.JComboBox<>();
        modelLabel = new javax.swing.JLabel();
        colorFilterOption = new javax.swing.JComboBox<>();
        colorLabel = new javax.swing.JLabel();
        jPanelAppointments = new javax.swing.JPanel();
        appointmentScrollPane = new javax.swing.JScrollPane();
        appointmentTable = new javax.swing.JTable();
        deleteAppointmentButton = new javax.swing.JButton();
        jPanelSales = new javax.swing.JPanel();
        appointmentScrollPane1 = new javax.swing.JScrollPane();
        salesTable = new javax.swing.JTable();
        statusLabel = new javax.swing.JLabel();
        accountButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("🚗 Car Dealership");
        setResizable(false);
        setSize(new java.awt.Dimension(869, 489));

        jTabbedPane.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTabbedPane.setName(""); // NOI18N
        jTabbedPane.setOpaque(true);
        jTabbedPane.setPreferredSize(new java.awt.Dimension(700, 400));

        inventoryTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inventoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        inventoryTable.setShowHorizontalLines(true);
        inventoryScrollPane.setViewportView(inventoryTable);

        appointmentAndSaleButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        appointmentAndSaleButton.setText("Schedule Test Drive");
        appointmentAndSaleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appointmentAndSaleButtonActionPerformed(evt);
            }
        });

        styleLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        styleLabel.setText("Style");

        styleFilterOption.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        styleFilterOption.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Any" }));
        styleFilterOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                styleFilterOptionActionPerformed(evt);
            }
        });

        makeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        makeLabel.setText("Make");

        makeFilterOption.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        makeFilterOption.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Any" }));
        makeFilterOption.setName(""); // NOI18N
        makeFilterOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeFilterOptionActionPerformed(evt);
            }
        });

        modelFilterOption.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        modelFilterOption.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Any" }));
        modelFilterOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelFilterOptionActionPerformed(evt);
            }
        });

        modelLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        modelLabel.setText("Model");

        colorFilterOption.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        colorFilterOption.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Any" }));
        colorFilterOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorFilterOptionActionPerformed(evt);
            }
        });

        colorLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        colorLabel.setText("Color");

        javax.swing.GroupLayout jPanelInventoryLayout = new javax.swing.GroupLayout(jPanelInventory);
        jPanelInventory.setLayout(jPanelInventoryLayout);
        jPanelInventoryLayout.setHorizontalGroup(
            jPanelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInventoryLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inventoryScrollPane)
                    .addGroup(jPanelInventoryLayout.createSequentialGroup()
                        .addGroup(jPanelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(styleLabel)
                            .addComponent(styleFilterOption, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(makeLabel)
                            .addComponent(makeFilterOption, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modelLabel)
                            .addComponent(modelFilterOption, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelInventoryLayout.createSequentialGroup()
                                .addComponent(colorLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(colorFilterOption, 0, 167, Short.MAX_VALUE)))
                    .addGroup(jPanelInventoryLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(appointmentAndSaleButton)))
                .addGap(24, 24, 24))
        );
        jPanelInventoryLayout.setVerticalGroup(
            jPanelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInventoryLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(styleLabel)
                    .addComponent(makeLabel)
                    .addComponent(modelLabel)
                    .addComponent(colorLabel))
                .addGap(3, 3, 3)
                .addGroup(jPanelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(makeFilterOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(styleFilterOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelFilterOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(colorFilterOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(inventoryScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(appointmentAndSaleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jTabbedPane.addTab("Vehicle Inventory", null, jPanelInventory, "");

        appointmentTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        appointmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        appointmentScrollPane.setViewportView(appointmentTable);

        deleteAppointmentButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        deleteAppointmentButton.setLabel("Delete Appointment");
        deleteAppointmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAppointmentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAppointmentsLayout = new javax.swing.GroupLayout(jPanelAppointments);
        jPanelAppointments.setLayout(jPanelAppointmentsLayout);
        jPanelAppointmentsLayout.setHorizontalGroup(
            jPanelAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAppointmentsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteAppointmentButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(appointmentScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        jPanelAppointmentsLayout.setVerticalGroup(
            jPanelAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAppointmentsLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(appointmentScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(deleteAppointmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jTabbedPane.addTab("My Appointments", jPanelAppointments);

        salesTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        salesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        appointmentScrollPane1.setViewportView(salesTable);

        javax.swing.GroupLayout jPanelSalesLayout = new javax.swing.GroupLayout(jPanelSales);
        jPanelSales.setLayout(jPanelSalesLayout);
        jPanelSalesLayout.setHorizontalGroup(
            jPanelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSalesLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(appointmentScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanelSalesLayout.setVerticalGroup(
            jPanelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSalesLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(appointmentScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("My Sales", null, jPanelSales, "");

        statusLabel.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        statusLabel.setText("Not Logged In");
        statusLabel.setToolTipText("");

        accountButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        accountButton.setText("Log In");
        accountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(accountButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 521, Short.MAX_VALUE)
                .addComponent(statusLabel)
                .addGap(23, 23, 23))
            .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(accountButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane.getAccessibleContext().setAccessibleName("Tabs");
        jTabbedPane.getAccessibleContext().setAccessibleDescription("");

        getAccessibleContext().setAccessibleName("Car Dealership 🚗 ");
        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void accountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountButtonActionPerformed
        // TODO add your handling code here:
        if (AccountHandler.isLoggedIn()) {
            if (JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Log Out", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                AccountHandler.tryLogout();
            } else {
                return;
            }
        }
        LoginFrame login = new LoginFrame();
        Point location = this.getLocationOnScreen();
        location.translate(210, 100);
        login.getPreviousFrameLocation(location);
        login.setVisible(true);
        dispose();

    }//GEN-LAST:event_accountButtonActionPerformed

    private void styleFilterOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_styleFilterOptionActionPerformed
        VehicleHandler.getFilter().setStyle(String.valueOf(styleFilterOption.getSelectedItem()));
        VehicleHandler.loadVehiclesIntoTable((DefaultTableModel) inventoryTable.getModel());
    }//GEN-LAST:event_styleFilterOptionActionPerformed

    private void makeFilterOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeFilterOptionActionPerformed
        VehicleHandler.loadModelsIntoComboBox(modelFilterOption, String.valueOf(makeFilterOption.getSelectedItem()));
        VehicleHandler.getFilter().setMake(String.valueOf(makeFilterOption.getSelectedItem()));
        VehicleHandler.getFilter().setModel("Any");
        VehicleHandler.loadVehiclesIntoTable((DefaultTableModel) inventoryTable.getModel());
    }//GEN-LAST:event_makeFilterOptionActionPerformed

    private void modelFilterOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelFilterOptionActionPerformed
        VehicleHandler.getFilter().setModel(String.valueOf(modelFilterOption.getSelectedItem()));
        VehicleHandler.loadVehiclesIntoTable((DefaultTableModel) inventoryTable.getModel());
    }//GEN-LAST:event_modelFilterOptionActionPerformed

    private void colorFilterOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorFilterOptionActionPerformed
        VehicleHandler.getFilter().setColor(String.valueOf(colorFilterOption.getSelectedItem()));
        VehicleHandler.loadVehiclesIntoTable((DefaultTableModel) inventoryTable.getModel());
    }//GEN-LAST:event_colorFilterOptionActionPerformed

    private void appointmentAndSaleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appointmentAndSaleButtonActionPerformed
        if (!AccountHandler.isLoggedIn()) {
            JOptionPane.showMessageDialog(this, "You must log in first!",
                    "Not Logged In", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (inventoryTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Please click on a vehicle first.",
                    "No Vehicle Selected", JOptionPane.ERROR_MESSAGE);
            return;
        }
        VehicleHandler.selectVehicle(inventoryTable.getSelectedRow());

        if (AccountHandler.isEmployee()) {
            CreateSaleFrame sale1 = new CreateSaleFrame();
            sale1.getPreviousFrameLocation(this.getLocationOnScreen());
            sale1.setVisible(true);
            dispose();
        } else {
            if (AccountHandler.hasMadeAppointmentWithVehicle(VehicleHandler.getSelectedVehicleVin())) {
                JOptionPane.showMessageDialog(this, "You're already scheduled to test drive this vehicle!",
                        "Appointment Already Made", JOptionPane.ERROR_MESSAGE);
            } else {
                CreateAppointmentDialog makeAppt = new CreateAppointmentDialog(this, true, appointmentTable);
                makeAppt.setLocationRelativeTo(this);
                makeAppt.setVisible(true);
            }
        }
    }//GEN-LAST:event_appointmentAndSaleButtonActionPerformed

    private void deleteAppointmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAppointmentButtonActionPerformed
        if (appointmentTable.getSelectedRow() == -1)
            JOptionPane.showMessageDialog(this, "Please click on an appointment first.", "No Appointment Selected", JOptionPane.ERROR_MESSAGE);
        else {
            if(JOptionPane.showConfirmDialog(null, "Are you sure to you want to delete this appointment?", "Delete Appointment", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                AccountHandler.deleteAppointment(appointmentTable.getSelectedRow());
                AccountHandler.loadAppointmentsIntoTable((DefaultTableModel) appointmentTable.getModel());
                JOptionPane.showMessageDialog(this, "Appointment has been deleted.", "Appointment Deleted", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_deleteAppointmentButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accountButton;
    private javax.swing.JButton appointmentAndSaleButton;
    private javax.swing.JScrollPane appointmentScrollPane;
    private javax.swing.JScrollPane appointmentScrollPane1;
    private javax.swing.JTable appointmentTable;
    private javax.swing.JComboBox<String> colorFilterOption;
    private javax.swing.JLabel colorLabel;
    private javax.swing.JButton deleteAppointmentButton;
    private javax.swing.JScrollPane inventoryScrollPane;
    private javax.swing.JTable inventoryTable;
    private javax.swing.JPanel jPanelAppointments;
    private javax.swing.JPanel jPanelInventory;
    private javax.swing.JPanel jPanelSales;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JComboBox<String> makeFilterOption;
    private javax.swing.JLabel makeLabel;
    private javax.swing.JComboBox<String> modelFilterOption;
    private javax.swing.JLabel modelLabel;
    private javax.swing.JTable salesTable;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JComboBox<String> styleFilterOption;
    private javax.swing.JLabel styleLabel;
    // End of variables declaration//GEN-END:variables
}
