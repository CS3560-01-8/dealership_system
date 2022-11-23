package dealership;

import dealership.access.AppointmentDB;
import dealership.controller.AccountHandler;
import dealership.controller.AppointmentHandler;
import dealership.db.DatabaseConnector;
import dealership.object.Customer;
import dealership.ui.MainScreen;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide your MYSQL password as the first command line argument.");
            System.exit(1);
        }
        DatabaseConnector.createConnection(args[0]);

        //Example query
        /*ResultSet rs = DatabaseConnector.executeQuery("SELECT * FROM sale");
        System.out.println("Sales Table:");
        try {
            while (rs.next()) {
                for (int i = 1; i < rs.getMetaData().getColumnCount(); i++) {
                    System.out.print(rs.getString(i) + " ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        //test appointment
        //AppointmentHandler.makeAppointment("bringe4@naver.com", "1C6RD7GP5CS629292", "2022-11-18 01:36:00");

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        new MainScreen().setVisible(true);
    }

}
