//Banking2
//Karn
//Upgraded Banking account

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

class Bank {
    final double startingBalance = 50.00;
    Random rand = new Random(); //helps set up a random int
    double balance; //creates an initial startingBalance of $50
    String FilePass, username, password, confirm, fullName, accountNumberString, transaction1, transaction2, transaction3;
    Intro intro = new Intro();
    TabbedPane tabbedPane = new TabbedPane();

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.CheckMakeDir();
    }

    public void CheckMakeDir() {    //Sets up a directory
        if (!(new File("JavaBankDir").exists())) {    //checks to see if there is a directory to store account information
            boolean dirMade = (new File("JavaBankDir")).mkdir(); //creates a directory
            if (!dirMade) {
                Error("dirError");
            }
        }
        intro.intro();    //pulls up the intro jframe
    }

    public void signUp(String usernameP, String passwordP, String confirmP, String fullNameP) { //checks to see if the given information can create an account
        if (usernameP.equals("") || passwordP.equals("") || confirmP.equals("") || fullNameP.equals("")) {
            Error("null field");
            intro.intro();
        } else {
            username = usernameP;
            password = passwordP;
            confirm = confirmP;
            fullName = fullNameP;
            if (new File("JavaBankDir\\" + username + ".txt").exists()) {    //checks to see if there is an account with that username
                Error("username taken");    //sends an error message method that the username is already taken
                intro.intro();    //pulls up the intro jframe
            } else if (!Objects.equals(password, confirm)) {    //checks to see if the password and confirm password fields match
                Error("password mismatch");    //sends an error message method that the passwords do not match
                intro.intro();    //pulls up the intro jframe
            } else {
                try {
                    accountNumberString = String.format("%06d", rand.nextInt(999999));
                    balance = startingBalance;
                    Writer w1 = new FileWriter("JavaBankDir/" + username + ".txt");    //makes a .txt file for that person
                    w1.write(fullName + "\n" + accountNumberString + "\n" + password + "\n" + startingBalance);    //writes the person's information
                    w1.close();    //closes the writer
                    getInformation();
                    tabbedPane.tabbedPane(username);    //pulls up the main jframe
                } catch (IOException e) {    //If I can't write in a file/make a file
                    Error("error"); //sends a generic error message
                    intro.intro();  //pulls up intro jframe
                }
            }
        }
    }

    public void logIn(String usernameP, String passwordP) { //checks to see if the person can log in
        if (usernameP.equals("") || passwordP.equals("")) {
            Error("null field");
            intro.intro();
        } else {
            username = usernameP;
            password = passwordP;
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
                    getInformation();
                    tabbedPane.tabbedPane(username);    //pulls up the main jframe
                }
            }
        }
    }

    public void deposit(int depositAmount) {
        String filePath = "JavaBankDir\\" + username + ".txt";
        try {
            getInformation();
            double newBalance = balance + depositAmount;
            // input the file content to the StringBuffer "input"
            BufferedReader file = new BufferedReader(new FileReader(filePath));
            StringBuilder inputBuffer = new StringBuilder();
            String line;
            while ((line = file.readLine()) != null) {
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }
            file.close();
            String inputStr = inputBuffer.toString();

            // logic to replace lines in the string (could use regex here to be generic)
            inputStr = inputStr.replace(Double.toString(balance), Double.toString(newBalance));

            // display the new file for debugging

            // write the new string with the replaced line OVER the same file
            FileOutputStream fileOut = new FileOutputStream(filePath);
            fileOut.write(inputStr.getBytes());
            fileOut.close();
            Successful("deposit");
        } catch (Exception e) {
            Error("error");
        }
    }

    public void getInformation() {
        try {
            List<String> fileLines = Files.readAllLines(Paths.get("JavaBankDir\\" + username + ".txt"));
            int numLines = fileLines.size();
            fullName = fileLines.get(0);
            accountNumberString = fileLines.get(1);
            password = fileLines.get(2);
            balance = getInterest();
            if (numLines > 4) {
                transaction1 = fileLines.get(4);
                if (numLines > 5) {
                    transaction2 = fileLines.get(5);
                    if (numLines > 6) {
                        transaction3 = fileLines.get(6);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public double getInterest() {
        double newBalance;
        long toSec = 0;
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        Path path = Paths.get("JavaBankDir\\" + username + ".txt");
        BasicFileAttributes attr;
        try {
            balance = getFileBalance();
            attr = Files.readAttributes(path, BasicFileAttributes.class);
            Duration res = Duration.between(attr.lastModifiedTime().toInstant(), Instant.now());
            toSec = res.getSeconds();
        } catch (Exception e) {
            Error("error");
        }
        //double j = (((((float) toSec / 60) / 60) / 24) / 365);
        double j = ((((float) toSec / 60) / 60) / 24);
        newBalance = Double.parseDouble(df.format((float) balance * (0.1 * j) + balance));
        changeBalance(String.valueOf(newBalance));
        return newBalance;
    }

    public void changeBalance(String newBalanceP) {
        String filePath = "JavaBankDir\\" + username + ".txt";
        try {
            balance = getFileBalance();
            Scanner sc = new Scanner(new File(filePath));
            StringBuilder buffer = new StringBuilder();
            while (sc.hasNextLine()) {
                buffer.append(sc.nextLine()).append(System.lineSeparator());
            }
            String fileContents = buffer.toString();
            System.out.println("Contents of the file: " + fileContents);
            sc.close();
            fileContents = fileContents.replaceAll(String.valueOf(balance), newBalanceP);
            FileWriter writer = new FileWriter(filePath);
            System.out.println("new data: " + fileContents);
            writer.append(fileContents);
            writer.flush();
        } catch (Exception e) {
            Error("error");
        }
    }

    public double getFileBalance() {
        try {
            balance = Double.parseDouble(Files.readAllLines(Paths.get("JavaBankDir\\" + username + ".txt")).get(3));
        } catch (IOException e) {
            Error("error");
        }
        return balance;
    }

    public void setUsername(String username) {
        this.username = username;
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
            case "dirError" -> {
                JOptionPane.showMessageDialog(null, "Sorry, something went wrong. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
            }
            case "null field" ->
                    JOptionPane.showMessageDialog(null, "Please fill all text fields.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Successful(String successfulMessage) {
        switch (successfulMessage) {
            case "deposit" -> {
                JOptionPane.showMessageDialog(null, "Successfully Deposited.", "Alert", JOptionPane.WARNING_MESSAGE);
                getInformation();
                tabbedPane.tabbedPane(username);
            }
            case "withdraw" -> {
                JOptionPane.showMessageDialog(null, "Successfully Withdrawn.", "Alert", JOptionPane.WARNING_MESSAGE);
                getInformation();
                tabbedPane.tabbedPane(username);
            }
            case "transfer" -> {
                JOptionPane.showMessageDialog(null, "Successfully Transferred.", "Alert", JOptionPane.WARNING_MESSAGE);
                getInformation();
                tabbedPane.tabbedPane(username);
            }
            case "change" -> {
                JOptionPane.showMessageDialog(null, "Successfully Changed.", "Alert", JOptionPane.WARNING_MESSAGE);
                getInformation();
                tabbedPane.tabbedPane(username);
            }
        }
    }
}