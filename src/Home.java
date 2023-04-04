import javax.swing.*;
import java.awt.*;

public class Home extends javax.swing.JFrame {
    String username;

    public static void main(String[] args) {
        Home home = new Home();
        home.home();
    }

    public void home() {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //Set up the JFrame

        //Create font
        Font font = new Font("Comic Sans MS", Font.PLAIN, 12);
        //Create Frame
        JFrame frame = new JFrame("Java Bank"); //create JFrame and set title
        //Start create panels, texts, and fields
        JPanel welcomePane = new JPanel();
        JLabel variableWelcomeText = new JLabel();
        JPanel buttonPane = new JPanel();
        JButton depositButton = new JButton();
        JButton withdrawButton = new JButton();
        JButton transferButton = new JButton();
        JButton infoButton = new JButton();
        //Sets Frame behaviors
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new java.awt.Dimension(500, 500));
        frame.setResizable(true);

        //Log In Panel formatting
        variableWelcomeText.setFont(font);
        variableWelcomeText.setText("Welcome " + username);

        javax.swing.GroupLayout WelcomePaneLayout = new javax.swing.GroupLayout(welcomePane);
        welcomePane.setLayout(WelcomePaneLayout);
        WelcomePaneLayout.setHorizontalGroup(
                WelcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WelcomePaneLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(variableWelcomeText)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        WelcomePaneLayout.setVerticalGroup(
                WelcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(WelcomePaneLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(variableWelcomeText)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        depositButton.setText("Deposit");
        depositButton.setFont(font);
        //depositButton.addActionListener(evt -> DepositButtonActionPerformed(evt));

        withdrawButton.setText("Withdraw");
        withdrawButton.setFont(font);
        //withdrawButton.addActionListener(evt -> WithdrawButtonActionPerformed(evt));

        transferButton.setText("Transfer");
        transferButton.setFont(font);

        infoButton.setText("Account Information");
        transferButton.setFont(font);

        javax.swing.GroupLayout ButtonPaneLayout = new javax.swing.GroupLayout(buttonPane);
        buttonPane.setLayout(ButtonPaneLayout);
        ButtonPaneLayout.setHorizontalGroup(
                ButtonPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ButtonPaneLayout.createSequentialGroup()
                                .addContainerGap(9, Short.MAX_VALUE)
                                .addComponent(depositButton)
                                .addGap(18, 18, 18)
                                .addComponent(withdrawButton)
                                .addGap(18, 18, 18)
                                .addComponent(transferButton)
                                .addGap(18, 18, 18)
                                .addComponent(infoButton)
                                .addContainerGap(9, Short.MAX_VALUE))
        );
        ButtonPaneLayout.setVerticalGroup(
                ButtonPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ButtonPaneLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(ButtonPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(depositButton)
                                        .addComponent(withdrawButton)
                                        .addComponent(transferButton)
                                        .addComponent(infoButton))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(32, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(buttonPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(welcomePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(143, Short.MAX_VALUE)
                                .addComponent(welcomePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(150, 150, 150)
                                .addComponent(buttonPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(144, Short.MAX_VALUE))
        );

        frame.pack();
        frame.setLocationRelativeTo(null);  //centers the jframe in the screen
        frame.setVisible(true);
    }
}