package dealership;

import com.formdev.flatlaf.FlatDarkLaf;
import dealership.db.DatabaseConnector;
import dealership.ui.MainFrame;
import javax.swing.*;

public class Main {

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        if (args.length == 0) {
            System.out.println("Please provide your MYSQL password as the first command line argument.");
            System.exit(1);
        }

        DatabaseConnector.createConnection(args[0]);
        UIManager.setLookAndFeel(new FlatDarkLaf());
        new MainFrame().setVisible(true);
    }

}
