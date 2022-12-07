/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dealership.ui;

import dealership.controller.SaleHandler;
import dealership.object.Sale;

import javax.swing.*;
import java.awt.*;

public class ConfirmSaleDialog extends javax.swing.JDialog {

    /**
     * Creates new form MakeSaleScreen2
     */
    private final Frame parent;

    public ConfirmSaleDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        initComponents();
        initSaleDetails();
        this.getRootPane().setDefaultButton(buttonConfirm);
    }

    private void initSaleDetails() {
        Sale pendingSale = SaleHandler.getSale();
        textVehicle.setText(pendingSale.getVehicle().toString());
        textVIN.setText(pendingSale.getVehicle().getVin());
        textCustomerName.setText(pendingSale.getCustomer().getName());
        textCardNumber.setText(pendingSale.getCardNumber());
        textAddress.setText(pendingSale.getCustomer().getAddress());
        textPhoneNumber.setText(pendingSale.getCustomer().getPhoneNum());
        textAgreedPrice.setText(String.format("$%.2f", pendingSale.getAgreedPrice()));
        textTax.setText(String.format("$%.2f", pendingSale.getTax()));
        textTotal.setText(String.format("$%.2f", (pendingSale.getAgreedPrice() + pendingSale.getTax())));
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

        saleDetails = new javax.swing.JPanel();
        labelVehicle = new javax.swing.JLabel();
        labeAgreedPrice = new javax.swing.JLabel();
        labelVIN = new javax.swing.JLabel();
        textAgreedPrice = new javax.swing.JTextField();
        textVehicle = new javax.swing.JTextField();
        textVIN = new javax.swing.JTextField();
        textTax = new javax.swing.JTextField();
        labelTax = new javax.swing.JLabel();
        textTotal = new javax.swing.JTextField();
        labelTotal = new javax.swing.JLabel();
        textCardNumber = new javax.swing.JTextField();
        labelCustomerName = new javax.swing.JLabel();
        textCustomerName = new javax.swing.JTextField();
        labelCustomerName1 = new javax.swing.JLabel();
        textAddress = new javax.swing.JTextField();
        labelCustomerName2 = new javax.swing.JLabel();
        labelCustomerName3 = new javax.swing.JLabel();
        textPhoneNumber = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        buttonConfirm = new javax.swing.JButton();

        setTitle("🚗 Finalize Sale");
        setResizable(false);

        saleDetails.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sale Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        labelVehicle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelVehicle.setText("Vehicle");

        labeAgreedPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labeAgreedPrice.setText("Agreed Price");

        labelVIN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelVIN.setText("VIN");

        textAgreedPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textAgreedPrice.setEnabled(false);

        textVehicle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textVehicle.setEnabled(false);

        textVIN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textVIN.setEnabled(false);

        textTax.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textTax.setEnabled(false);

        labelTax.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTax.setText("Tax (10%)");

        textTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textTotal.setEnabled(false);

        labelTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTotal.setText("Total");

        textCardNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textCardNumber.setEnabled(false);
        textCardNumber.setMinimumSize(new java.awt.Dimension(65, 26));

        labelCustomerName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelCustomerName.setText("Customer Name");
        labelCustomerName.setToolTipText("");

        textCustomerName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textCustomerName.setEnabled(false);
        textCustomerName.setPreferredSize(new java.awt.Dimension(65, 26));

        labelCustomerName1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelCustomerName1.setText("Customer Card Number");
        labelCustomerName1.setToolTipText("");

        textAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textAddress.setEnabled(false);

        labelCustomerName2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelCustomerName2.setText("Customer Address");
        labelCustomerName2.setToolTipText("");

        labelCustomerName3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelCustomerName3.setText("Customer Phone");
        labelCustomerName3.setToolTipText("");

        textPhoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textPhoneNumber.setEnabled(false);

        javax.swing.GroupLayout saleDetailsLayout = new javax.swing.GroupLayout(saleDetails);
        saleDetails.setLayout(saleDetailsLayout);
        saleDetailsLayout.setHorizontalGroup(
            saleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(saleDetailsLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(saleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(saleDetailsLayout.createSequentialGroup()
                        .addGroup(saleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelVehicle)
                            .addComponent(labelCustomerName))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(saleDetailsLayout.createSequentialGroup()
                        .addGroup(saleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(saleDetailsLayout.createSequentialGroup()
                                .addGroup(saleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(saleDetailsLayout.createSequentialGroup()
                                        .addGroup(saleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labeAgreedPrice)
                                            .addComponent(textAgreedPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(24, 24, 24)
                                        .addGroup(saleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textTax, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelTax)))
                                    .addComponent(textAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelCustomerName2))
                                .addGap(24, 24, 24)
                                .addGroup(saleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textTotal)
                                    .addComponent(textPhoneNumber)
                                    .addGroup(saleDetailsLayout.createSequentialGroup()
                                        .addGroup(saleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelTotal)
                                            .addComponent(labelCustomerName3))
                                        .addGap(0, 17, Short.MAX_VALUE))))
                            .addGroup(saleDetailsLayout.createSequentialGroup()
                                .addGroup(saleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textVehicle)
                                    .addComponent(textCustomerName, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                                .addGap(24, 24, 24)
                                .addGroup(saleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(saleDetailsLayout.createSequentialGroup()
                                        .addGroup(saleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelCustomerName1)
                                            .addComponent(textVIN, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelVIN))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(textCardNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(24, 24, 24))))
        );
        saleDetailsLayout.setVerticalGroup(
            saleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(saleDetailsLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(saleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelVehicle)
                    .addComponent(labelVIN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(saleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textVIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textVehicle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(saleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCustomerName)
                    .addComponent(labelCustomerName1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(saleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(saleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCustomerName2)
                    .addComponent(labelCustomerName3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(saleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(saleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labeAgreedPrice)
                    .addComponent(labelTax)
                    .addComponent(labelTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(saleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textAgreedPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        labelTax.getAccessibleContext().setAccessibleName("Tax (10%)");
        labelTax.getAccessibleContext().setAccessibleDescription("");

        cancelButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.setToolTipText("");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        buttonConfirm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonConfirm.setText("Confirm");
        buttonConfirm.setToolTipText("");
        buttonConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(saleDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(buttonConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(saleDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmActionPerformed
        SaleHandler.finalizeSale();
        JOptionPane.showMessageDialog(this, "Sale completed!", "Sale Complete", JOptionPane.INFORMATION_MESSAGE);
        MainFrame inv = new MainFrame();
        inv.getPreviousFrameLocation(parent.getLocationOnScreen());
        inv.setVisible(true);
        dispose();
        parent.dispose();
    }//GEN-LAST:event_buttonConfirmActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonConfirm;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel labeAgreedPrice;
    private javax.swing.JLabel labelCustomerName;
    private javax.swing.JLabel labelCustomerName1;
    private javax.swing.JLabel labelCustomerName2;
    private javax.swing.JLabel labelCustomerName3;
    private javax.swing.JLabel labelTax;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelVIN;
    private javax.swing.JLabel labelVehicle;
    private javax.swing.JPanel saleDetails;
    private javax.swing.JTextField textAddress;
    private javax.swing.JTextField textAgreedPrice;
    private javax.swing.JTextField textCardNumber;
    private javax.swing.JTextField textCustomerName;
    private javax.swing.JTextField textPhoneNumber;
    private javax.swing.JTextField textTax;
    private javax.swing.JTextField textTotal;
    private javax.swing.JTextField textVIN;
    private javax.swing.JTextField textVehicle;
    // End of variables declaration//GEN-END:variables
}
