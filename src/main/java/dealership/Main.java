package dealership;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import dealership.db.DatabaseConnector;
import dealership.ui.MainScreen;
import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        if (args.length == 0) {
            System.out.println("Please provide your MYSQL password as the first command line argument.");
            System.exit(1);
        }

        DatabaseConnector.createConnection(args[0]);
        if (LocalTime.now().isAfter(LocalTime.of(18, 0)) || LocalTime.now().isBefore(LocalTime.of(4, 0))) {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } else {
            UIManager.setLookAndFeel(new FlatLightLaf());
        }
        new MainScreen().setVisible(true);
    }

}
