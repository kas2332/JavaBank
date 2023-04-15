//Banking2
//Karn
//Upgraded Banking account

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

class Bank {
    final double startingBalance = 50.00;
    Random rand = new Random(); //helps set up a random int
    double balance; //creates an initial startingBalance of $50
    String FilePass, username, password, confirm, fullName, accountNumberString, transaction1, transaction2, transaction3;
    List<String> namesList = new ArrayList<>(), userNamesList = new ArrayList<>();
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
                Error("resetError");
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
                    Error("resetError"); //sends a generic error message
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
                    Error("resetError");
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

    public void changeBalance(int changeAmount, String descriptionP) {
        getInformation();
        double newBalance = balance + changeAmount;
        if (newBalance < 1) {
            Error("insufficientFunds");
            Successful("");
        } else {
            changeFileValue(String.valueOf(balance), String.valueOf(newBalance), descriptionP);
            Successful("Transaction Completed");
        }
    }

    public void transfer(int transferAmountP, int transfereeNameIndex) {
        String descriptionTransferer = "Transferred " + transferAmountP + " dollars to " + namesList.get(transfereeNameIndex);
        String descriptionTransferee = fullName + " transferred " + transferAmountP + " dollars";
        String storeUsersUsername = username;
        getInformation();
        double newBalance = balance + (-1 * transferAmountP);
        if (newBalance < 1) {
            Error("insufficientFunds");
            Successful("");
        } else {
            changeFileValue(String.valueOf(balance), String.valueOf(newBalance), descriptionTransferer);
            username = userNamesList.get(transfereeNameIndex);
            getInformation();
            newBalance = balance + transferAmountP;
            changeFileValue(String.valueOf(balance), String.valueOf(newBalance), descriptionTransferee);
            username = storeUsersUsername;
            getInformation();
            Successful("Transaction Completed");
        }
    }

    public void changeInformation(String newUsernameP, String newPasswordP, String newFullNameP) {
        if (!newPasswordP.equals("")) {
            changeFileValue(newPasswordP, 2);
        }
        if (!newFullNameP.equals(fullName) && !newFullNameP.equals("")) {
            changeFileValue(newFullNameP, 0);
        }
        if (!newUsernameP.equals(username) && !newUsernameP.equals("")) {
            File oldFileName = new File("JavaBankDir\\" + username + ".txt");
            File newFileName = new File("JavaBankDir\\" + newUsernameP + ".txt");
            if (newFileName.exists()) {
                Error("username taken");
            } else {
                try {
                    Files.move(oldFileName.toPath(), newFileName.toPath());
                    username = newUsernameP;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        Successful("");
    }

    public String removeExtension(Path pathP) {
        String fileName = pathP.toFile().getName();
        int pos = fileName.lastIndexOf(".");
        if (pos > 0 && pos < (fileName.length() - 1)) { // If '.' is not the first or last character.
            fileName = fileName.substring(0, pos);
        }
        return fileName;
    }

    public String[] getNamesList() {
        Path dir = Paths.get("JavaBankDir");
        namesList.clear();
        namesList.add("");
        userNamesList.clear();
        userNamesList.add("");
        try (Stream<Path> fileStream = Files.walk(dir)) {
            fileStream.forEach(path -> {
                if (!(path.toFile()).isDirectory()) {
                    if (!username.equals(removeExtension(path))) {
                        try {
                            namesList.add(Files.readAllLines(Paths.get(String.valueOf(path.toFile()))).get(0));
                            userNamesList.add(removeExtension(path));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });
            return namesList.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getInformation() {
        try {
            List<String> fileLines = Files.readAllLines(Paths.get("JavaBankDir\\" + username + ".txt"));
            int numLines = fileLines.size();
            fullName = fileLines.get(0).trim();
            accountNumberString = fileLines.get(1).trim();
            password = fileLines.get(2).trim();
            balance = getInterest();
            if (numLines > 4) {
                transaction1 = fileLines.get(4).trim();
                if (numLines > 5) {
                    transaction2 = fileLines.get(5).trim();
                    if (numLines > 6) {
                        transaction3 = fileLines.get(6).trim();
                    }
                }
            }
            if (transaction1 == null || transaction1.equals("")) {
                transaction1 = setTransactionToNA();
            }
            if (transaction2 == null || transaction2.equals("")) {
                transaction2 = setTransactionToNA();
            }
            if (transaction3 == null || transaction3.equals("")) {
                transaction3 = setTransactionToNA();
            }
        } catch (IOException e) {
            Error("resetError");
        }
    }

    public double getInterest() {
        double newBalance;
        long toSec = 0;
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
        DecimalFormat df = (DecimalFormat) nf;
        df.setMaximumFractionDigits(2);
        Path path = Paths.get("JavaBankDir\\" + username + ".txt");
        BasicFileAttributes attr;
        try {
            balance = getFileBalance();
            attr = Files.readAttributes(path, BasicFileAttributes.class);
            Duration res = Duration.between(attr.lastModifiedTime().toInstant(), Instant.now());
            toSec = res.getSeconds();
        } catch (Exception e) {
            System.out.println(2);
            Error("resetError");
        }
        //double j = (((((float) toSec / 60) / 60) / 24) / 365);
        double j = (((float) toSec / 60) / 60);
        newBalance = Double.parseDouble(df.format((float) balance * (0.1 * j) + balance).replace(",", ""));
        changeFileValue(String.valueOf(newBalance), 3);
        return newBalance;
    }

    public void changeFileValue(String newValue, int lineNumber) {
        String filePath = "JavaBankDir\\" + username + ".txt";
        try {
            Scanner sc = new Scanner(new File(filePath));
            StringBuilder buffer = new StringBuilder();
            while (sc.hasNextLine()) {
                buffer.append(sc.nextLine()).append(System.lineSeparator());
            }
            String fileContents = buffer.toString();
            String[] fileContentsArray = fileContents.split("\n");
            fileContentsArray[lineNumber] = newValue + "\n";
            sc.close();

            FileWriter writer = new FileWriter(filePath);
            for (String i : fileContentsArray) {
                writer.append(i);
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println(3);
            Error("resetError");
        }
    }

    public void changeFileValue(String originalValue, String newValue, String descriptionP) {
        String filePath = "JavaBankDir\\" + username + ".txt";
        LocalDateTime d = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy: HH:mm:ss");
        try {
            Scanner sc = new Scanner(new File(filePath));
            StringBuilder buffer = new StringBuilder();
            int lineNum = 0;
            while (sc.hasNextLine()) {
                buffer.append(sc.nextLine()).append(System.lineSeparator());
                if (lineNum == 3) {
                    buffer.append(d.format(dateFormatter)).append(descriptionP).append(System.lineSeparator());
                }
                lineNum++;
            }
            String fileContents = buffer.toString();
            sc.close();
            fileContents = fileContents.replaceAll(originalValue, newValue);
            FileWriter writer = new FileWriter(filePath);
            writer.append(fileContents);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println(4);
            Error("resetError");
        }
    }

    public double getFileBalance() {
        try {
            balance = Double.parseDouble(Files.readAllLines(Paths.get("JavaBankDir\\" + username + ".txt")).get(3));
        } catch (IOException e) {
            Error("resetError");
        }
        return balance;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String setTransactionToNA() {
        return "No Previous Transactions Available";
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
            case "resetError" -> {
                JOptionPane.showMessageDialog(null, "Sorry, something went wrong. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
            }
            case "null field" ->
                    JOptionPane.showMessageDialog(null, "Please fill all text fields.", "Error", JOptionPane.ERROR_MESSAGE);
            case "insufficientFunds" ->
                    JOptionPane.showMessageDialog(null, "Error, transaction would leave the account with insufficient funds.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Successful(String successfulMessage) {
        switch (successfulMessage) {
            case "Transaction Completed" ->
                    JOptionPane.showMessageDialog(null, "Transaction Successfully Completed.", "Alert", JOptionPane.WARNING_MESSAGE);
            case "change" ->
                    JOptionPane.showMessageDialog(null, "Account Information Changed Successfully.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        getInformation();
        tabbedPane.tabbedPane(username);
    }
}