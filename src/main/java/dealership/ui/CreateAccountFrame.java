/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dealership.ui;

import dealership.controller.AccountHandler;
import java.awt.Point;
import javax.swing.JOptionPane;

/**
 * @author krist
 */
public class CreateAccountFrame extends javax.swing.JFrame {


    /**
     * Creates new form CreateAccount
     */
    public CreateAccountFrame() {
        initComponents();
        this.getRootPane().setDefaultButton(createAccountButton);
    }

    public void getPreviousFrameLocation(Point previous) {
        this.setLocation(previous);
    }

    // Find missing information and create message dialog box;
    private boolean checkForMissingInfo() {
        boolean anyMissing = false;
        String message = "Please enter ";
        String[] missing = new String[8];
        int index = 0;
        if (emailInput.getText().equals("")) {
            missing[index] = "email";
            index++;
            anyMissing = true;
        }
        if (String.valueOf(passwordInput.getPassword()).equals("")) {
            missing[index] = "password";
            index++;
            anyMissing = true;
        }
        if (firstNameInput.getText().equals("")) {
            missing[index] = "first name";
            index++;
            anyMissing = true;
        }
        if (lastNameInput.getText().equals("")) {
            missing[index] = "last name";
            index++;
            anyMissing = true;
        }
        if (phoneInput.getText().equals("")) {
            missing[index] = "phone number";
            index++;
            anyMissing = true;
        }
        if (streetInput.getText().equals("")) {
            missing[index] = "street";
            index++;
            anyMissing = true;
        }
        if (cityInput.getText().equals("")) {
            missing[index] = "city";
            index++;
            anyMissing = true;
        }
        if (zipInput.getText().equals("")) {
            missing[index] = "zip code";
            index++;
            anyMissing = true;
        }
        if (anyMissing) {
            if (missing[missing.length - 1] == null) {
                String firstLetter = missing[0].substring(0, 1);
                switch (firstLetter) {
                    case "a":
                    case "e":
                    case "i":
                    case "o":
                    case "u":
                        message = message + "an ";
                        break;
                    default:
                        message = message + "a ";
                }
                if (missing[1] == null)
                    message = message + missing[0] + ".";
                else if (missing[2] == null)
                    message = message + missing[0] + " and " + missing[1] + ".";
                else {
                    int i = 0;
                    while (missing[i] != null) {
                        if (missing[i + 1] == null)
                            message = message + "and " + missing[i] + ".";
                        else
                            message = message + missing[i] + ", ";
                        i++;
                    }
                }
            } else {
                message = message + "information into the boxes.";
            }
            JOptionPane.showMessageDialog(this, message, "Missing information", JOptionPane.ERROR_MESSAGE);
        }
        return anyMissing;
    }

    private boolean isValidEmail(String email) {
        if (!email.matches("[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}")) {
            JOptionPane.showMessageDialog(this, "Email is not in the right format. Please retype email.", "Format Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean isValidName(String firstName, String lastName) {
        if (!firstName.matches("^(?=.{1,40}$)[a-zA-Z]+(?:[-'\\s][a-zA-Z]+)*$")) {
            JOptionPane.showMessageDialog(this, "First name contains numbers and/or symbols. Please retype first name.", "Format Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!lastName.matches("^(?=.{1,40}$)[a-zA-Z]+(?:[-'\\s][a-zA-Z]+)*$")) {
            JOptionPane.showMessageDialog(this, "Last name contains numbers and/or symbols. Please retype last name.", "Format Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private boolean isValidZip(String zip) {
        if (!zip.matches("\\d{5}")) {
            JOptionPane.showMessageDialog(this, "Zip code is not in right format.Please retype zip code.", "Format Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private boolean isValidPhoneNo(String phoneNo) {
        if (!phoneNo.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Phone number is not in right format. Please retype phone number.", "Format Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelButton = new javax.swing.JButton();
        createAccountButton = new javax.swing.JButton();
        jPanelAccountDetails = new javax.swing.JPanel();
        lastNameLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        streetLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        passwordInput = new javax.swing.JPasswordField();
        emailInput = new javax.swing.JTextField();
        cityInput = new javax.swing.JTextField();
        zipLabel = new javax.swing.JLabel();
        lastNameInput = new javax.swing.JTextField();
        firstNameInput = new javax.swing.JTextField();
        stateInput = new javax.swing.JComboBox<>();
        emailLabel = new javax.swing.JLabel();
        stateLabel = new javax.swing.JLabel();
        streetInput = new javax.swing.JTextField();
        phoneInput = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        zipInput = new javax.swing.JTextField();
        cityLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("🚗 Create Account");
        setResizable(false);

        cancelButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.setToolTipText("Create account");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        createAccountButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        createAccountButton.setToolTipText("Create account");
        createAccountButton.setLabel("Create");
        createAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountButtonActionPerformed(evt);
            }
        });

        jPanelAccountDetails.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Account Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14)))); // NOI18N

        lastNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lastNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lastNameLabel.setText("Last Name");

        firstNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        firstNameLabel.setText("First Name");

        streetLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        streetLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        streetLabel.setText("Street Address");
        streetLabel.setToolTipText("");

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        passwordLabel.setText("Password");

        passwordInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        emailInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cityInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        zipLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        zipLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        zipLabel.setText("ZIP");

        lastNameInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        firstNameInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        stateInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        stateInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CA", "AL", "AK", "AZ", "AR", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" }));

        emailLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emailLabel.setText("Email");

        stateLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        stateLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        stateLabel.setText("State");

        streetInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        phoneInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        phoneLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        phoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        phoneLabel.setText("Phone");

        zipInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cityLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cityLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cityLabel.setText("City");

        javax.swing.GroupLayout jPanelAccountDetailsLayout = new javax.swing.GroupLayout(jPanelAccountDetails);
        jPanelAccountDetails.setLayout(jPanelAccountDetailsLayout);
        jPanelAccountDetailsLayout.setHorizontalGroup(
            jPanelAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAccountDetailsLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAccountDetailsLayout.createSequentialGroup()
                        .addGroup(jPanelAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(emailLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordLabel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAccountDetailsLayout.createSequentialGroup()
                        .addGroup(jPanelAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelAccountDetailsLayout.createSequentialGroup()
                                .addGroup(jPanelAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelAccountDetailsLayout.createSequentialGroup()
                                        .addComponent(cityLabel)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cityInput))
                                .addGap(16, 16, 16)
                                .addGroup(jPanelAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(stateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(stateLabel))
                                .addGap(16, 16, 16)
                                .addGroup(jPanelAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(zipInput, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(zipLabel)))
                            .addComponent(streetInput, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelAccountDetailsLayout.createSequentialGroup()
                                .addComponent(streetLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanelAccountDetailsLayout.createSequentialGroup()
                                .addGroup(jPanelAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(emailInput, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passwordInput, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelAccountDetailsLayout.createSequentialGroup()
                                        .addGroup(jPanelAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelAccountDetailsLayout.createSequentialGroup()
                                                .addComponent(firstNameInput, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                .addGap(16, 16, 16))
                                            .addGroup(jPanelAccountDetailsLayout.createSequentialGroup()
                                                .addComponent(firstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)))
                                        .addGroup(jPanelAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lastNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lastNameLabel))))
                                .addGap(16, 16, 16)
                                .addGroup(jPanelAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phoneLabel)
                                    .addComponent(phoneInput, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(24, 24, 24))))
        );
        jPanelAccountDetailsLayout.setVerticalGroup(
            jPanelAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAccountDetailsLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(emailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanelAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(lastNameLabel)
                    .addComponent(phoneLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(streetLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(streetInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanelAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityLabel)
                    .addComponent(stateLabel)
                    .addComponent(zipLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stateInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zipInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(createAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanelAccountDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanelAccountDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void createAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountButtonActionPerformed
        if (!checkForMissingInfo()) {
            if (isValidEmail(emailInput.getText()) && isValidName(firstNameInput.getText(), lastNameInput.getText()) && isValidPhoneNo(phoneInput.getText()) && isValidZip(zipInput.getText())) {
                if (AccountHandler.createCustomerAccount(emailInput.getText(),
                        String.valueOf(passwordInput.getPassword()),
                        firstNameInput.getText(),
                        lastNameInput.getText(),
                        phoneInput.getText(),
                        streetInput.getText() + ", " + cityInput.getText() + " " + stateInput.getSelectedItem() + ", " + zipInput.getText())) {
                    JOptionPane.showMessageDialog(this, "Your account has been created.",
                            "Account Created", JOptionPane.INFORMATION_MESSAGE);
                    LoginFrame login = new LoginFrame();
                    login.getPreviousFrameLocation(this.getLocationOnScreen());
                    login.setVisible(true);
                    dispose();
                } else
                    JOptionPane.showMessageDialog(this, "An account already exists with that email!", "Email Taken", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_createAccountButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        LoginFrame login = new LoginFrame();
        login.getPreviousFrameLocation(this.getLocationOnScreen());
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField cityInput;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JButton createAccountButton;
    private javax.swing.JTextField emailInput;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField firstNameInput;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JPanel jPanelAccountDetails;
    private javax.swing.JTextField lastNameInput;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField phoneInput;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JComboBox<String> stateInput;
    private javax.swing.JLabel stateLabel;
    private javax.swing.JTextField streetInput;
    private javax.swing.JLabel streetLabel;
    private javax.swing.JTextField zipInput;
    private javax.swing.JLabel zipLabel;
    // End of variables declaration//GEN-END:variables
}
