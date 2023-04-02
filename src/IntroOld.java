//Generated by GuiGenie - Copyright (c) 2004 Mario Awad.
//Home Page http://guigenie.cjb.net - Check often for new versions!

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntroOld extends JPanel implements ActionListener {
    static String username, password, confirm, fullName;
    static Bank bank = new Bank();

    public static void introOld() {
        //creates a jframe
        JFrame frame = new JFrame("Intro");

        //construct components
        JLabel welcomeText = new JLabel("Welcome to Java Bank", SwingConstants.CENTER);
        JLabel logInText = new JLabel("Log In", SwingConstants.CENTER);
        JLabel signUpText = new JLabel("Sign Up", SwingConstants.CENTER);
        JLabel usernameLogInText = new JLabel("Username", SwingConstants.CENTER);
        JLabel passwordLogInText = new JLabel("Password", SwingConstants.CENTER);
        JLabel usernameSignUpText = new JLabel("Username", SwingConstants.CENTER);
        JLabel fullNameText = new JLabel("Full Name", SwingConstants.CENTER);
        JLabel passwordSignUpText = new JLabel("Password", SwingConstants.CENTER);
        JLabel confirmPasswordText = new JLabel("Confirm Password", SwingConstants.CENTER);
        JTextField usernameLogInField = new JTextField(5);
        JTextField usernameSignUpField = new JTextField(5);
        JPasswordField passwordLogInField = new JPasswordField(5);
        JPasswordField passwordSignUpField = new JPasswordField(5);
        JPasswordField confirmField = new JPasswordField(5);
        JTextField fullNameField = new JTextField(5);
        JButton logInButton = new JButton("Log In");
        JButton signUpButton = new JButton("Sign Up");

        //add components
        frame.add(welcomeText);
        frame.add(logInText);
        frame.add(signUpText);
        frame.add(usernameLogInText);
        frame.add(passwordLogInText);
        frame.add(usernameSignUpText);
        frame.add(fullNameText);
        frame.add(passwordSignUpText);
        frame.add(confirmPasswordText);
        frame.add(usernameLogInField);
        frame.add(usernameSignUpField);
        frame.add(passwordLogInField);
        frame.add(passwordSignUpField);
        frame.add(confirmField);
        frame.add(fullNameField);
        frame.add(logInButton);
        frame.add(signUpButton);

        //set component bounds (only needed by Absolute Positioning)
        welcomeText.setBounds(220, 125, 150, 25);
        logInText.setBounds(90, 207, 100, 25);
        signUpText.setBounds(360, 207, 50, 25);
        usernameLogInText.setBounds(90, 257, 100, 25);
        passwordLogInText.setBounds(90, 332, 100, 25);
        usernameSignUpText.setBounds(405, 257, 100, 25);
        fullNameText.setBounds(270, 257, 100, 25);
        passwordSignUpText.setBounds(270, 332, 100, 25);
        confirmPasswordText.setBounds(393, 332, 125, 25);
        usernameLogInField.setBounds(90, 282, 100, 25);
        usernameSignUpField.setBounds(405, 282, 100, 25);
        passwordLogInField.setBounds(90, 357, 100, 25);
        passwordSignUpField.setBounds(270, 357, 100, 25);
        confirmField.setBounds(405, 357, 100, 25);
        fullNameField.setBounds(270, 282, 100, 25);
        logInButton.setBounds(90, 407, 100, 25);
        signUpButton.setBounds(360, 407, 100, 25);

        //sets up jframe
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //makes the frame close when the x button is clicked?
        frame.getContentPane().add(new IntroOld());    //IDK what this does
        frame.pack();   //IDK what this does
        frame.setSize(584, 612);    //sets the size of the jframe
        frame.setLocationRelativeTo(null);  //centers the jframe in the screen
        frame.setLayout(null);  //IDK what this does
        frame.setVisible(true); //makes the jframe visible

        //adds action listeners to the buttons
        logInButton.addActionListener(e -> {
            username = usernameLogInField.getText();
            //noinspection deprecation
            password = passwordLogInField.getText();
            bank.logIn(username, password);
            frame.dispose();
        });
        signUpButton.addActionListener(e -> {
            username = usernameSignUpField.getText();
            //noinspection deprecation
            password = passwordSignUpField.getText();
            //noinspection deprecation
            confirm = confirmField.getText();
            fullName = fullNameField.getText();
            bank.signUp(username, password, confirm, fullName);
            frame.dispose();
        });
    }

    public static void main(String[] args) {
        introOld();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
