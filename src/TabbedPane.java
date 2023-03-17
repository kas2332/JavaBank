import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class TabbedPane extends JPanel {

    public static void main(String[] args) {
        tabbedPane();
    }

    public static void tabbedPane() {
        //Makes the base frame
        JFrame frame = new JFrame("TabbedPaneDemo");
        //Makes the tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        //Makes an object of the specific tab to make the panel
        JComponent Home = new Home();
        //Makes the tab and a quick key
        tabbedPane.addTab("Home", null, Home, "Welcome Home!");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_H);

        JComponent Deposit = new Deposit();
        tabbedPane.addTab("Deposit", null, Deposit, "Deposit money into your account");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_D);

        JComponent Withdraw = new Withdraw();
        tabbedPane.addTab("Withdraw", null, Withdraw, "Withdraw money from your account");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_W);

        JComponent Transfer = new Transfer();
        Transfer.setPreferredSize(new Dimension(410, 50));
        tabbedPane.addTab("Transfer", null, Transfer, "Transfer money from your account to someone else's account");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_T);

        JComponent Info = new Info();
        tabbedPane.addTab("Info", null, Info, "Get information on your account");
        tabbedPane.setMnemonicAt(4, KeyEvent.VK_I);

        //Add the tabbed pane to the frame.
        frame.add(tabbedPane);

        //Allows scrolling if tab length exceeds frame length
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        //Create and set up the window.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(tabbedPane);

        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}