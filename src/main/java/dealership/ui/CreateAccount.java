/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dealership.ui;
;
import dealership.controller.AccountHandler;
import java.awt.Point;
import javax.swing.JOptionPane;

/**
 *
 * @author krist
 */
public class CreateAccount extends javax.swing.JFrame {

    
    /**
     * Creates new form CreateAccount
     */
    public CreateAccount() {
        initComponents();
    }
    
    // Gets previous frame's location on screen
    public void getPreviousFrameLocation(Point previous) {
        this.setLocation(previous);
    }
    
    // Find missing information and create message dialog box;
    private void checkForMissingInfo() {
        boolean anyMissing = false;
        String message = "Please enter ";
        String[] missing = new String[7];
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
        if (zipInput.getText().equals("")) {
            missing[index] = "zip code";
            index++;
            anyMissing = true;
        }
        if (!anyMissing) {
            if (AccountHandler.createCustomerAccount(emailInput.getText(),
                        String.valueOf(passwordInput.getPassword()),
                        firstNameInput.getText(),
                        lastNameInput.getText(),
                        phoneInput.getText(),
                        streetInput.getText() + " " + stateInput.getSelectedItem() + ", " + zipInput.getText())) {
                JOptionPane.showMessageDialog(this, "Your account has been created.",
                        "Account Created", JOptionPane.INFORMATION_MESSAGE);
                AccountHandler.tryLogin(emailInput.getText(), String.valueOf(passwordInput.getPassword()));
                MainScreen ms = new MainScreen();
                ms.getPreviousFrameLocation(this.getLocationOnScreen());
                ms.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "An account already exists with that email!",
                        "Email Taken", JOptionPane.ERROR_MESSAGE);
            }
            AccountHandler.createCustomerAccount(emailInput.getText(),
                String.valueOf(passwordInput.getPassword()),
                firstNameInput.getText(),
                lastNameInput.getText(),
                phoneInput.getText(),
                streetInput.getText() + " " + stateInput.getSelectedItem() + ", " + zipInput.getText());
        } else {
            if (missing[missing.length - 1] == null) {
                String firstLetter = missing[0].substring(0,1);
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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        createAccountLabel = new javax.swing.JLabel();
        userInputPanel = new javax.swing.JPanel();
        emailLabel = new javax.swing.JLabel();
        emailInput = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordInput = new javax.swing.JPasswordField();
        firstNameLabel = new javax.swing.JLabel();
        firstNameInput = new javax.swing.JTextField();
        zipLabel = new javax.swing.JLabel();
        lastNameInput = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        phoneInput = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        zipInput = new javax.swing.JTextField();
        stateInput = new javax.swing.JComboBox<>();
        streetLabel = new javax.swing.JLabel();
        stateLabel = new javax.swing.JLabel();
        streetInput = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        makeAccountButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Car Dealership");
        jPanel1.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 205, 49));

        createAccountLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        createAccountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        createAccountLabel.setText("Create Account");
        jPanel1.add(createAccountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 168, 41));

        userInputPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emailLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        emailLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        emailLabel.setText("Email");
        userInputPanel.add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 55, -1));

        emailInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userInputPanel.add(emailInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 209, -1));

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        passwordLabel.setText("Password");
        userInputPanel.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        passwordInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userInputPanel.add(passwordInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 209, -1));

        firstNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        firstNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        firstNameLabel.setText("First Name");
        userInputPanel.add(firstNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, -1));

        firstNameInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userInputPanel.add(firstNameInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 209, -1));

        zipLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        zipLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        zipLabel.setText("ZIP");
        userInputPanel.add(zipLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, -1, -1));

        lastNameInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userInputPanel.add(lastNameInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 209, -1));

        lastNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lastNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lastNameLabel.setText("Last Name");
        userInputPanel.add(lastNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        phoneInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userInputPanel.add(phoneInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 209, -1));

        phoneLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        phoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        phoneLabel.setText("Phone #");
        userInputPanel.add(phoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        zipInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userInputPanel.add(zipInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 70, -1));

        stateInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        stateInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CA", "AL", "AK", "AZ", "AR", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" }));
        userInputPanel.add(stateInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        streetLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        streetLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        streetLabel.setText("Street");
        userInputPanel.add(streetLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        stateLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        stateLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        stateLabel.setText("State");
        userInputPanel.add(stateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        streetInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userInputPanel.add(streetInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 209, -1));

        addressLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addressLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        addressLabel.setText("Address");
        userInputPanel.add(addressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, -1, -1));

        makeAccountButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        makeAccountButton.setText("Create Account");
        makeAccountButton.setToolTipText("Create account");
        makeAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeAccountButtonActionPerformed(evt);
            }
        });
        userInputPanel.add(makeAccountButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 170, 47));

        cancelButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.setToolTipText("Go back to login");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        userInputPanel.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 170, 47));

        jPanel1.add(userInputPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 470, 320));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void makeAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeAccountButtonActionPerformed
        checkForMissingInfo();
    }//GEN-LAST:event_makeAccountButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        LoginScreen login = new LoginScreen();
        login.getPreviousFrameLocation(this.getLocationOnScreen());
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel createAccountLabel;
    private javax.swing.JTextField emailInput;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField firstNameInput;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lastNameInput;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JButton makeAccountButton;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField phoneInput;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JComboBox<String> stateInput;
    private javax.swing.JLabel stateLabel;
    private javax.swing.JTextField streetInput;
    private javax.swing.JLabel streetLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel userInputPanel;
    private javax.swing.JTextField zipInput;
    private javax.swing.JLabel zipLabel;
    // End of variables declaration//GEN-END:variables
}
