/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dealership.ui;

import dealership.access.AccountDB;

import java.awt.Point;
import javax.swing.JOptionPane;

import static java.lang.String.valueOf;

/**
 *
 * @author krist
 */
public class LoginScreen extends javax.swing.JFrame {

    
    /**
     * Creates new form LoginScreen
     */
    public LoginScreen() {
        initComponents();
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

        jPanel1 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        createAccountLabel = new javax.swing.JLabel();
        userInputPanel = new javax.swing.JPanel();
        emailLabel = new javax.swing.JLabel();
        emailInput = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordInput = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        cancelButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        createAccountButton = new javax.swing.JButton();
        optionalLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Car Dealership");
        jPanel1.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 205, 49));

        createAccountLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        createAccountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        createAccountLabel.setText("Login");
        jPanel1.add(createAccountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 120, 41));

        userInputPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emailLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        emailLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        emailLabel.setText("Email");
        userInputPanel.add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 6, 55, -1));

        emailInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userInputPanel.add(emailInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 209, -1));

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        passwordLabel.setText("Password");
        userInputPanel.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 44, -1, -1));

        passwordInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userInputPanel.add(passwordInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 44, 209, -1));

        loginButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        userInputPanel.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 198, 47));

        jPanel1.add(userInputPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 440, 140));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 255, 10));

        cancelButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel1.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 90, 40));

        createAccountButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        createAccountButton.setText("Create Account");
        createAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountButtonActionPerformed(evt);
            }
        });

        optionalLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        optionalLabel.setText("Or");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(optionalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createAccountButton)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optionalLabel)
                    .addComponent(createAccountButton))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 170, 40));

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

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        if (emailInput.getText().equals("") && valueOf(passwordInput.getPassword()).equals(""))
            JOptionPane.showMessageDialog(this, "Please enter an email and password.", "Missing information", JOptionPane.ERROR_MESSAGE);
        else if (emailInput.getText().equals("") && !valueOf(passwordInput.getPassword()).equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter email.", "Missing information", JOptionPane.ERROR_MESSAGE);
        }
        else if (!emailInput.getText().equals("") && valueOf(passwordInput.getPassword()).equals(""))
            JOptionPane.showMessageDialog(this, "Please enter password.", "Missing information", JOptionPane.ERROR_MESSAGE);
        else {
            if(AccountDB.checkPass(emailInput.getText(), valueOf(passwordInput.getPassword())))
                JOptionPane.showMessageDialog(this, "Login success!", "log in", JOptionPane.ERROR_MESSAGE);
            else
                JOptionPane.showMessageDialog(this, "Login failed! Please check your email or password", "log in fail", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        MainScreen ms = new MainScreen();
        ms.getPreviousFrameLocation(this.getLocationOnScreen());
        ms.setVisible(true);
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void createAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountButtonActionPerformed
        // TODO add your handling code here:
        CreateAccount ca = new CreateAccount();
        ca.getPreviousFrameLocation(this.getLocationOnScreen());
        ca.setVisible(true);
        dispose();
    }//GEN-LAST:event_createAccountButtonActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton createAccountButton;
    private javax.swing.JLabel createAccountLabel;
    private javax.swing.JTextField emailInput;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel optionalLabel;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel userInputPanel;
    // End of variables declaration//GEN-END:variables
}
