//Banking2
//Karn
//Upgraded Banking account

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Random;

class Bank {
    Random rand = new Random(); //helps set up a random int
    double balance = 50.00; //creates an initial balance of $50
    String FilePass;
    boolean dirMade;
    Intro intro = new Intro();

    public static void main(String[] args) {
        Bnka bank = new Bank();
        bank.CheckMakeDir();
    }

    public void CheckMakeDir() {    //Sets up a directory
        if (!(new File("JavaBankDir").exists())) {    //checks to see if there is a directory to store account information
            dirMade = (new File("JavaBankDir")).mkdir(); //creates a directory
            if (!dirMade) {
                Error("dirError");
            }
        }
        intro.intro();    //pulls up the intro jframe
    }

    public void signUp(String username, String password, String confirm, String fullName) { //checks to see if the given information can create an account
        if (new File("JavaBankDir\\" + username + ".txt").exists()) {    //checks to see if there is an account with that username
            Error("username taken");    //sends an error message method that the username is already taken
            intro.intro();    //pulls up the intro jframe
        } else if (!Objects.equals(password, confirm)) {    //checks to see if the password and confirm password fields match
            Error("password mismatch");    //sends an error message method that the passwords do not match
            intro.intro();    //pulls up the intro jframe
        } else {
            try {
                Writer w1 = new FileWriter("JavaBankDir/" + username + ".txt");    //makes a .txt file for that person
                w1.write(fullName + "\n" + String.format("%06d", rand.nextInt(999999)) + "\n" + password + "\n" + balance);    //writes the person's information
                w1.close();    //closes the writer
                tabbedPane.tabbedPane();    //pulls up the main jframe
            } catch (IOException e) {    //If I can't write in a file/make a file
                Error("error"); //sends a generic error message
                intro.intro();  //pulls up intro jframe
            }
        }
    }

    public void logIn(String username, String password) {    //checks to see if the person can log in
        if (!(new File("JavaBankDir\\" + username + ".txt").exists())) {    //checks to see if that username does not exist
            Error("incorrect username");    //sends an error message that the username does not exist
            intro.intro();  //pulls up the intro jframe
        } else {    //checks if password is right
            try {
                FilePass = Files.readAllLines(Paths.get("JavaBankDir\\" + username + ".txt")).get(2); //pulls up the third line of the text file which is the password
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (!password.equals(FilePass)) { //checks if the passwords match
                Error("incorrect password"); //sends an error message that the password(/username) is incorrect
                intro.intro();  //pulls up the intro jframe
            } else {
                tabbedPane.tabbedPane();  //pulls up the main jframe
            }
        }

    }

    public void Error(String errorMessage) { //pulls up error messages
        switch (errorMessage) {
            case "nonexistent username" ->
                    JOptionPane.showMessageDialog(null, "Error, account does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
            case "incorrect password", "incorrect username" ->
                    JOptionPane.showMessageDialog(null, "Error, username or password does not match.", "Error", JOptionPane.ERROR_MESSAGE);
            case "username taken" ->
                    JOptionPane.showMessageDialog(null, "Sorry, that username has already been taken.", "Error", JOptionPane.ERROR_MESSAGE);
            case "password mismatch" ->
                    JOptionPane.showMessageDialog(null, "Error, passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
            case "error" ->
                    JOptionPane.showMessageDialog(null, "Sorry, something went wrong. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
            case "dirError" ->
                    JOptionPane.showMessageDialog(null, "Sorry, something went wrong. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(-1);
        }
    }
}
