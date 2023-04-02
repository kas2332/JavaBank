import javax.swing.*;
import java.awt.*;

public class Intro extends javax.swing.JFrame {
    static Intro intro = new Intro();
    String username, password, confirm, fullName;
    Bank bank = new Bank();

    public static void main(String[] args) {
        intro.intro();
    }

    public void intro() {

        /* Set the Nimbus look and feel */
        //<editor-fold default-state="collapsed" desc=" Look and feel setting code (optional) ">
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Intro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */


        JFrame frame = new JFrame();

        JPanel LogInPanel = new javax.swing.JPanel();
        JLabel LogInUsernameText = new javax.swing.JLabel();
        JLabel LogInPasswordText = new javax.swing.JLabel();
        JButton LogInButton = new javax.swing.JButton();
        JTextField LogInUsernameField = new javax.swing.JTextField();
        JPasswordField LogInPasswordField = new javax.swing.JPasswordField();
        JPanel SignUpPanel = new javax.swing.JPanel();
        JButton SignUpButton = new javax.swing.JButton();
        JPasswordField SignUpPasswordField = new javax.swing.JPasswordField();
        JLabel SignUpPasswordText = new javax.swing.JLabel();
        JLabel SignUpUsernameText = new javax.swing.JLabel();
        JTextField SignUpUsernameField = new javax.swing.JTextField();
        JTextField FullNameField = new javax.swing.JTextField();
        JLabel FullNameText = new javax.swing.JLabel();
        JLabel ConfirmText = new javax.swing.JLabel();
        JPasswordField ConfirmField = new javax.swing.JPasswordField();
        JPanel WelcomePanel = new javax.swing.JPanel();
        JLabel WelcomeText = new javax.swing.JLabel();

        Font font = new Font("Comic Sans MS", Font.PLAIN, 12);

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new java.awt.Dimension(500, 500));
        frame.setResizable(false);

        LogInPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Log In", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, font)); // NOI18N
        LogInPanel.setPreferredSize(new java.awt.Dimension(215, 295));

        LogInUsernameText.setFont(font); // NOI18N
        LogInUsernameText.setText("Username");

        LogInPasswordText.setFont(font); // NOI18N
        LogInPasswordText.setText("Password");

        LogInButton.setFont(font); // NOI18N
        LogInButton.setText("Log In");
        LogInButton.addActionListener(e -> {
            username = LogInUsernameField.getText();
            //noinspection deprecation
            password = LogInPasswordField.getText();
            bank.logIn(username, password);
            frame.dispose();
        });

        javax.swing.GroupLayout LogInPanelLayout = new javax.swing.GroupLayout(LogInPanel);
        LogInPanel.setLayout(LogInPanelLayout);
        LogInPanelLayout.setHorizontalGroup(
                LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(LogInPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(LogInUsernameText)
                                        .addComponent(LogInPasswordText))
                                .addGap(18, 18, 18)
                                .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(LogInUsernameField, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                        .addComponent(LogInPasswordField))
                                .addContainerGap())
                        .addGroup(LogInPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LogInButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LogInPanelLayout.setVerticalGroup(
                LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(LogInPanelLayout.createSequentialGroup()
                                .addContainerGap(73, Short.MAX_VALUE)
                                .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(LogInUsernameText)
                                        .addComponent(LogInUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(LogInPasswordText)
                                        .addComponent(LogInPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LogInButton)
                                .addContainerGap(102, Short.MAX_VALUE))
        );

        SignUpPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sign Up", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, font)); // NOI18N
        SignUpPanel.setPreferredSize(new java.awt.Dimension(215, 295));

        SignUpButton.setFont(font); // NOI18N
        SignUpButton.setText("Sign Up");
        SignUpButton.addActionListener(e -> {
            username = SignUpUsernameField.getText();
            //noinspection deprecation
            password = SignUpPasswordField.getText();
            //noinspection deprecation
            confirm = ConfirmField.getText();
            fullName = FullNameField.getText();
            bank.signUp(username, password, confirm, fullName);
            frame.dispose();
        });

        SignUpPasswordText.setFont(font); // NOI18N
        SignUpPasswordText.setText("Password");

        SignUpUsernameText.setFont(font); // NOI18N
        SignUpUsernameText.setText("Username");

        FullNameText.setFont(font); // NOI18N
        FullNameText.setText("Full Name");

        ConfirmText.setFont(font); // NOI18N
        ConfirmText.setText("Confirm");

        javax.swing.GroupLayout SignUpPanelLayout = new javax.swing.GroupLayout(SignUpPanel);
        SignUpPanel.setLayout(SignUpPanelLayout);
        SignUpPanelLayout.setHorizontalGroup(
                SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(SignUpPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(SignUpPanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(SignUpButton)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(SignUpPanelLayout.createSequentialGroup()
                                                .addComponent(ConfirmText)
                                                .addGap(18, 18, 18)
                                                .addComponent(ConfirmField)
                                                .addContainerGap())
                                        .addGroup(SignUpPanelLayout.createSequentialGroup()
                                                .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SignUpPanelLayout.createSequentialGroup()
                                                                .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(SignUpUsernameText)
                                                                        .addComponent(SignUpPasswordText))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(SignUpUsernameField, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                                                        .addComponent(SignUpPasswordField)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SignUpPanelLayout.createSequentialGroup()
                                                                .addComponent(FullNameText)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(FullNameField)))
                                                .addContainerGap())))
        );
        SignUpPanelLayout.setVerticalGroup(
                SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(SignUpPanelLayout.createSequentialGroup()
                                .addContainerGap(7, Short.MAX_VALUE)
                                .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(FullNameText)
                                        .addComponent(FullNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(SignUpUsernameText)
                                        .addComponent(SignUpUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(SignUpPasswordText)
                                        .addComponent(SignUpPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ConfirmText)
                                        .addComponent(ConfirmField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addComponent(SignUpButton)
                                .addContainerGap(72, Short.MAX_VALUE))
        );

        WelcomePanel.setName(""); // NOI18N

        WelcomeText.setFont(font); // NOI18N
        WelcomeText.setText("Welcome!");

        javax.swing.GroupLayout WelcomePanelLayout = new javax.swing.GroupLayout(WelcomePanel);
        WelcomePanel.setLayout(WelcomePanelLayout);
        WelcomePanelLayout.setHorizontalGroup(
                WelcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(WelcomePanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(WelcomeText)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        WelcomePanelLayout.setVerticalGroup(
                WelcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(WelcomePanelLayout.createSequentialGroup()
                                .addContainerGap(84, Short.MAX_VALUE)
                                .addComponent(WelcomeText)
                                .addContainerGap(85, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(WelcomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(LogInPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(SignUpPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(WelcomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(LogInPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(SignUpPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        frame.pack();
        frame.setLocationRelativeTo(null);  //centers the jframe in the screen
        frame.setVisible(true);
    }
}
