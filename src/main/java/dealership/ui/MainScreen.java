/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dealership.ui;

import dealership.controller.AccountHandler;
import dealership.controller.AppointmentHandler;
import dealership.controller.VehicleHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainScreen extends javax.swing.JFrame {

    /**
     * Creates new form MenuScreen
     */
    public MainScreen() {
        initComponents();
        initInventory();
        initAppointments();
        VehicleHandler.loadStylesIntoComboBox(styleFilterOption);
        VehicleHandler.loadMakesIntoComboBox(makeFilterOption);
        VehicleHandler.loadColorsIntoComboBox(colorFilterOption);
        if (AccountHandler.isLoggedIn()) {
            statusLabel.setText("Hi there, " + AccountHandler.getLoggedInName() + "!");
            accountButton.setText("Account");
            deleteAppointmentButton.setEnabled(true);
            if (AccountHandler.isEmployee())
                appointmentAndSaleButton.setText("Conduct Sale");
            else
                appointmentAndSaleButton.setText("Schedule Test Drive");
        } else {
            statusLabel.setText("Not Logged In");
            deleteAppointmentButton.setEnabled(false);
        }
    }
    
    // Gets previous frame's location on screen
    public void getPreviousFrameLocation(Point previous) {
        this.setLocation(previous);
    }

    // Fill table for car inventory
    private void initInventory() {
        inventoryTable.setModel(new DefaultTableModel(new Object[] {"Year", "Make", "Model", "Style", "Color", "Mileage", "Price"}, 0) {
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

        inventoryTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        inventoryTable.getColumnModel().getColumn(4).setPreferredWidth(40);
        inventoryTable.getColumnModel().getColumn(5).setPreferredWidth(40);
        inventoryTable.getColumnModel().getColumn(6).setPreferredWidth(40);
        inventoryTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        inventoryTable.getTableHeader().setResizingAllowed(false);
        inventoryTable.getTableHeader().setReorderingAllowed(false);
    }
    
    // Fill table for appointment table
    private void initAppointments() {
        if (AccountHandler.isEmployee()) {
            appointmentTable.setModel(new DefaultTableModel(new Object[] {"Customer Email", "Date/Time", "Vin"}, 0) {
                @Override
                //Prevent editing cells of the table
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });
            AppointmentHandler.loadAllAppointmentsIntoTable((DefaultTableModel) appointmentTable.getModel());
        } else {
            appointmentTable.setModel(new DefaultTableModel(new Object[] {"Date/Time", "Vin"}, 0) {
                @Override
                //Prevent editing cells of the table
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });
            AppointmentHandler.loadAppointmentsIntoTable((DefaultTableModel) appointmentTable.getModel());
        }
        appointmentTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        ((JLabel) appointmentTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);
        //appointmentTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        //appointmentTable.getColumnModel().getColumn(4).setPreferredWidth(40);
        appointmentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        appointmentTable.getTableHeader().setResizingAllowed(false);
        appointmentTable.getTableHeader().setReorderingAllowed(false);
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
        jPanelFilter = new javax.swing.JPanel();
        makeFilterOption = new javax.swing.JComboBox<>();
        makeLabel = new javax.swing.JLabel();
        modelFilterOption = new javax.swing.JComboBox<>();
        modelLabel = new javax.swing.JLabel();
        colorLabel = new javax.swing.JLabel();
        colorFilterOption = new javax.swing.JComboBox<>();
        styleLabel = new javax.swing.JLabel();
        styleFilterOption = new javax.swing.JComboBox<>();
        inventoryScrollPane = new javax.swing.JScrollPane();
        inventoryTable = new javax.swing.JTable();
        statusLabel = new javax.swing.JLabel();
        accountButton = new javax.swing.JButton();
        appointmentAndSaleButton = new javax.swing.JButton();
        jPanelAppointments = new javax.swing.JPanel();
        appointmentScrollPane = new javax.swing.JScrollPane();
        appointmentTable = new javax.swing.JTable();
        deleteAppointmentButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("🚗 Car Dealership");

        jTabbedPane.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTabbedPane.setName(""); // NOI18N
        jTabbedPane.setOpaque(true);

        jPanelFilter.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filter Results", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanelFilter.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        makeFilterOption.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        makeFilterOption.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Any" }));
        makeFilterOption.setName(""); // NOI18N
        makeFilterOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeFilterOptionActionPerformed(evt);
            }
        });

        makeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        makeLabel.setText("Make");

        modelFilterOption.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        modelFilterOption.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Any" }));
        modelFilterOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelFilterOptionActionPerformed(evt);
            }
        });

        modelLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        modelLabel.setText("Model");

        colorLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        colorLabel.setText("Color");

        colorFilterOption.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        colorFilterOption.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Any", "New", "Used" }));
        colorFilterOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorFilterOptionActionPerformed(evt);
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

        javax.swing.GroupLayout jPanelFilterLayout = new javax.swing.GroupLayout(jPanelFilter);
        jPanelFilter.setLayout(jPanelFilterLayout);
        jPanelFilterLayout.setHorizontalGroup(
            jPanelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFilterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(makeFilterOption, 0, 112, Short.MAX_VALUE)
                    .addComponent(modelFilterOption, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(colorFilterOption, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelFilterLayout.createSequentialGroup()
                        .addGroup(jPanelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modelLabel)
                            .addComponent(colorLabel)
                            .addComponent(styleLabel)
                            .addComponent(makeLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(styleFilterOption, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelFilterLayout.setVerticalGroup(
            jPanelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFilterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(styleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(styleFilterOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makeFilterOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modelLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modelFilterOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(colorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(colorFilterOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        inventoryTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inventoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        inventoryTable.setShowHorizontalLines(true);
        inventoryScrollPane.setViewportView(inventoryTable);

        statusLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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

        appointmentAndSaleButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        appointmentAndSaleButton.setText("Schedule Test Drive");
        appointmentAndSaleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appointmentAndSaleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelInventoryLayout = new javax.swing.GroupLayout(jPanelInventory);
        jPanelInventory.setLayout(jPanelInventoryLayout);
        jPanelInventoryLayout.setHorizontalGroup(
            jPanelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInventoryLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInventoryLayout.createSequentialGroup()
                        .addComponent(accountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInventoryLayout.createSequentialGroup()
                        .addGroup(jPanelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelInventoryLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(statusLabel))
                            .addGroup(jPanelInventoryLayout.createSequentialGroup()
                                .addComponent(jPanelFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inventoryScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInventoryLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(appointmentAndSaleButton)))))
                        .addGap(16, 16, 16))))
        );
        jPanelInventoryLayout.setVerticalGroup(
            jPanelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInventoryLayout.createSequentialGroup()
                .addGroup(jPanelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelInventoryLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanelFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelInventoryLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(statusLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inventoryScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(16, 16, 16)
                .addGroup(jPanelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(appointmentAndSaleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        deleteAppointmentButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        deleteAppointmentButton.setText("Delete");
        deleteAppointmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAppointmentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAppointmentsLayout = new javax.swing.GroupLayout(jPanelAppointments);
        jPanelAppointments.setLayout(jPanelAppointmentsLayout);
        jPanelAppointmentsLayout.setHorizontalGroup(
            jPanelAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAppointmentsLayout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addGroup(jPanelAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deleteAppointmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appointmentScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanelAppointmentsLayout.setVerticalGroup(
            jPanelAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAppointmentsLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(appointmentScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteAppointmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("My Appointments", jPanelAppointments);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            EditAccountScreen edit = new EditAccountScreen();
            edit.getPreviousFrameLocation(this.getLocationOnScreen());
            edit.setVisible(true);
            dispose();
        } else {
            LoginScreen login = new LoginScreen();
            login.getPreviousFrameLocation(this.getLocationOnScreen());
            login.setVisible(true);
            dispose();
        }
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
        if (AccountHandler.isEmployee()) {
            MakeSaleScreen1 sale1 = new MakeSaleScreen1();
            sale1.getPreviousFrameLocation(this.getLocationOnScreen());
            sale1.setVisible(true);
            dispose();
        } else {
            if (!AccountHandler.isLoggedIn()) {
                JOptionPane.showMessageDialog(this, "You must log in before scheduling a test drive!", "Not Logged In", JOptionPane.ERROR_MESSAGE);
            } else if (inventoryTable.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Please click on a vehicle first.", "No Vehicle Selected!", JOptionPane.ERROR_MESSAGE);
            } else {
                VehicleHandler.selectVehicle(inventoryTable.getSelectedRow());
                MakeAppointment makeAppt = new MakeAppointment(this, true);
                makeAppt.setLocationRelativeTo(this);
                makeAppt.setVisible(true);
            }
        }
    }//GEN-LAST:event_appointmentAndSaleButtonActionPerformed

    private void deleteAppointmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAppointmentButtonActionPerformed
        // TODO add your handling code here:
        if (appointmentTable.getSelectedRow() == -1) 
            JOptionPane.showMessageDialog(this, "Please click on an appointment.", "No Appointment Selected", JOptionPane.ERROR_MESSAGE);
        else {
                AppointmentHandler.selectAppointment(appointmentTable.getSelectedRow());
                AppointmentHandler.removeAppointmentFromTable((DefaultTableModel) appointmentTable.getModel());
                JOptionPane.showMessageDialog(this, "Appointment has been deleted.", "Appointment Deleted", JOptionPane.INFORMATION_MESSAGE);
                initAppointments();
        }
    }//GEN-LAST:event_deleteAppointmentButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accountButton;
    private javax.swing.JButton appointmentAndSaleButton;
    private javax.swing.JScrollPane appointmentScrollPane;
    private javax.swing.JTable appointmentTable;
    private javax.swing.JComboBox<String> colorFilterOption;
    private javax.swing.JLabel colorLabel;
    private javax.swing.JButton deleteAppointmentButton;
    private javax.swing.JScrollPane inventoryScrollPane;
    private javax.swing.JTable inventoryTable;
    private javax.swing.JPanel jPanelAppointments;
    private javax.swing.JPanel jPanelFilter;
    private javax.swing.JPanel jPanelInventory;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JComboBox<String> makeFilterOption;
    private javax.swing.JLabel makeLabel;
    private javax.swing.JComboBox<String> modelFilterOption;
    private javax.swing.JLabel modelLabel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JComboBox<String> styleFilterOption;
    private javax.swing.JLabel styleLabel;
    // End of variables declaration//GEN-END:variables
}
