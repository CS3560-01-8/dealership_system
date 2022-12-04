/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dealership.ui;

import dealership.controller.AccountHandler;
import dealership.controller.SaleHandler;
import dealership.controller.VehicleHandler;

import java.awt.*;
import javax.swing.*;

public class MakeSaleScreen1 extends javax.swing.JFrame {

    /**
     * Creates new form MakeSaleScreen1
     */
    public MakeSaleScreen1() {
        initComponents();
        initVehicleDetails();
        SaleHandler.loadEmployeesIntoList(panelEmployeeList);
    }

    public void initVehicleDetails() {
        textVehicle.setText(VehicleHandler.getSelectedVehicleDetails());
        textVIN.setText(VehicleHandler.getSelectedVehicleVin());
        textListingPrice.setText(VehicleHandler.getSelectedVehicleListingPrice());
    }
    
    // Gets previous frame's location on screen
    public void getPreviousFrameLocation(Point previous) {
        this.setLocation(previous);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        panelVehicleDetails = new javax.swing.JPanel();
        labelVehicle = new javax.swing.JLabel();
        labelListingPrice = new javax.swing.JLabel();
        labelVIN = new javax.swing.JLabel();
        textListingPrice = new javax.swing.JTextField();
        textVehicle = new javax.swing.JTextField();
        textVIN = new javax.swing.JTextField();
        panelEmployees = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        panelEmployeeList = new javax.swing.JPanel();
        panelSaleDetails = new javax.swing.JPanel();
        textCustomerEmail = new javax.swing.JTextField();
        labelCustomerEmail = new javax.swing.JLabel();
        textAgreedPrice = new javax.swing.JTextField();
        labelAgreedPrice = new javax.swing.JLabel();
        labelCardNumber = new javax.swing.JLabel();
        textCardNumber = new javax.swing.JTextField();

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 592, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 371, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Start New Sale");
        setAlwaysOnTop(true);
        setResizable(false);

        cancelButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.setToolTipText("Go back to login");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        submitButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        submitButton.setText("Submit");
        submitButton.setToolTipText("Go back to login");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        panelVehicleDetails.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vehicle Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        labelVehicle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelVehicle.setText("Vehicle");

        labelListingPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelListingPrice.setText("Listing Price");

        labelVIN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelVIN.setText("VIN");

        textListingPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textListingPrice.setEnabled(false);

        textVehicle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textVehicle.setEnabled(false);

        textVIN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textVIN.setEnabled(false);

        javax.swing.GroupLayout panelVehicleDetailsLayout = new javax.swing.GroupLayout(panelVehicleDetails);
        panelVehicleDetails.setLayout(panelVehicleDetailsLayout);
        panelVehicleDetailsLayout.setHorizontalGroup(
            panelVehicleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVehicleDetailsLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelVehicleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textVehicle)
                    .addGroup(panelVehicleDetailsLayout.createSequentialGroup()
                        .addGroup(panelVehicleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelVehicle)
                            .addComponent(labelVIN)
                            .addComponent(textVIN, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(panelVehicleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelListingPrice)
                            .addComponent(textListingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29))
        );
        panelVehicleDetailsLayout.setVerticalGroup(
            panelVehicleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVehicleDetailsLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(labelVehicle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textVehicle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(panelVehicleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelListingPrice)
                    .addComponent(labelVIN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelVehicleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textListingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textVIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelEmployees.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Other Sale Employees", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        panelEmployeeList.setLayout(new java.awt.GridBagLayout());
        jScrollPane.setViewportView(panelEmployeeList);

        javax.swing.GroupLayout panelEmployeesLayout = new javax.swing.GroupLayout(panelEmployees);
        panelEmployees.setLayout(panelEmployeesLayout);
        panelEmployeesLayout.setHorizontalGroup(
            panelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEmployeesLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        panelEmployeesLayout.setVerticalGroup(
            panelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmployeesLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        panelSaleDetails.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sale Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        textCustomerEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        labelCustomerEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelCustomerEmail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelCustomerEmail.setText("Customer Email");

        textAgreedPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        labelAgreedPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelAgreedPrice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelAgreedPrice.setText("Agreed Price");

        labelCardNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelCardNumber.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelCardNumber.setText("Card Number");

        textCardNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout panelSaleDetailsLayout = new javax.swing.GroupLayout(panelSaleDetails);
        panelSaleDetails.setLayout(panelSaleDetailsLayout);
        panelSaleDetailsLayout.setHorizontalGroup(
            panelSaleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSaleDetailsLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelSaleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSaleDetailsLayout.createSequentialGroup()
                        .addComponent(labelCustomerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelSaleDetailsLayout.createSequentialGroup()
                        .addGroup(panelSaleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textCustomerEmail)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSaleDetailsLayout.createSequentialGroup()
                                .addGroup(panelSaleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(panelSaleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelSaleDetailsLayout.createSequentialGroup()
                                        .addComponent(labelAgreedPrice)
                                        .addGap(0, 13, Short.MAX_VALUE))
                                    .addComponent(textAgreedPrice))))
                        .addGap(24, 24, 24))))
        );
        panelSaleDetailsLayout.setVerticalGroup(
            panelSaleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSaleDetailsLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(labelCustomerEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textCustomerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSaleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAgreedPrice)
                    .addComponent(labelCardNumber))
                .addGap(2, 2, 2)
                .addGroup(panelSaleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textAgreedPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(panelVehicleDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelSaleDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelVehicleDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(panelSaleDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        MainScreen inv = new MainScreen();
        inv.getPreviousFrameLocation(this.getLocationOnScreen());
        inv.setVisible(true);
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        if (textCustomerEmail.getText().isEmpty() || textCardNumber.getText().isEmpty() || textAgreedPrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter all sale details!", "Missing information", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //TODO more input validation

        if (!AccountHandler.customerExists(textCustomerEmail.getText())) {
            JOptionPane.showMessageDialog(this, "A customer with that email does not exist!", "Customer Not Found", JOptionPane.ERROR_MESSAGE);
            return;
        }

        SaleHandler.startSale(Float.parseFloat(textAgreedPrice.getText()),
                Float.parseFloat(textAgreedPrice.getText()) * 0.1f,textCardNumber.getText(), textCustomerEmail.getText(), SaleHandler.getEmployeesInSale(panelEmployeeList));

        MakeSaleScreen2 employeeSelect = new MakeSaleScreen2(this, true);
        employeeSelect.getPreviousFrameLocation(this.getLocationOnScreen());
        employeeSelect.setVisible(true);
    }//GEN-LAST:event_submitButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel labelAgreedPrice;
    private javax.swing.JLabel labelCardNumber;
    private javax.swing.JLabel labelCustomerEmail;
    private javax.swing.JLabel labelListingPrice;
    private javax.swing.JLabel labelVIN;
    private javax.swing.JLabel labelVehicle;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel panelEmployeeList;
    private javax.swing.JPanel panelEmployees;
    private javax.swing.JPanel panelSaleDetails;
    private javax.swing.JPanel panelVehicleDetails;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField textAgreedPrice;
    private javax.swing.JTextField textCardNumber;
    private javax.swing.JTextField textCustomerEmail;
    private javax.swing.JTextField textListingPrice;
    private javax.swing.JTextField textVIN;
    private javax.swing.JTextField textVehicle;
    // End of variables declaration//GEN-END:variables
}
