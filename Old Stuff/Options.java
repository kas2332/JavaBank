/*public class Options {
    public static void options() {
        System.out.println("What do you want to do?\nDeposit (1)\nWithdraw (2)\nTransfer (3)\nAccount Information (4)\nExit (0)");
        int option = scan.nextInt();
        scan.nextLine();
        try {
            if (option == 1) {
                deposit();
            } else if (option == 2) {
                withdraw();
            } else if (option == 3) {
                transfer();
            } else if (option == 4) {
                info();
            } else {
                System.out.println("Error: Invalid Number!");
                options();
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid Characters!");
            options();
        }
    }

    public static void deposit() {
        System.out.println("How much do you want to deposit?(Enter 0 to exit)");
        deposit = scan.nextDouble();
        if (deposit < 0) {
            System.out.println("Error: invalid number!");
            options();
        } else {
            try {
                startingBalance = 0;
                Double startingBalance = Double.parseDouble(Files.readAllLines(Paths.get("JavaBankDir\\" + username + ".txt")).get(3));
                OldBalance = GetInterest(startingBalance);
                Double NewBalance = OldBalance + deposit;
                String filePath = "JavaBankDir\\" + username + ".txt";
                String result = fileToString(filePath);
                //System.out.println("Contents of the file: "+result);
                //Replacing the word with desired one
                result = result.replaceAll(String.valueOf(startingBalance), String.valueOf(NewBalance));
                //Rewriting the contents of the file
                PrintWriter writer = new PrintWriter(filePath);
                writer.append(result);
                writer.flush();
                System.out.println("Successful!\nCurrent Balance: " + NewBalance);
                options();
            } catch (Exception e) {
                System.out.println("Sorry, something went wrong :(\n" + e);
                options();
            }
        }
    }

    public static void withdraw() {
        System.out.println("How much do you want to withdraw?(Enter 0 to exit)");
        withdraw = scan.nextDouble();
        scan.nextLine();
        if (withdraw < 0) {
            System.out.println("Error: invalid number!");
            options();
        } else {
            try {
                startingBalance = 0;
                Double startingBalance = Double.parseDouble(Files.readAllLines(Paths.get("JavaBankDir\\" + username + ".txt")).get(3));
                OldBalance = GetInterest(startingBalance);

                if (withdraw > OldBalance) {
                    System.out.println("Error: invalid funds!");
                    options();
                } else {
                    Double NewBalance = OldBalance - withdraw;
                    String filePath = "JavaBankDir\\" + username + ".txt";
                    String result = fileToString(filePath);
                    //System.out.println("Contents of the file: "+result);
                    //Replacing the word with desired one
                    result = result.replaceAll(String.valueOf(startingBalance), String.valueOf(NewBalance));
                    //Rewriting the contents of the file
                    PrintWriter writer = new PrintWriter(filePath);
                    writer.append(result);
                    writer.flush();
                    System.out.println("Successful!\nCurrent Balance: " + NewBalance);
                    options();
                }
            } catch (Exception e) {
                System.out.println("Sorry, something went wrong :(\n" + e);
                options();
            }
        }
    }

    public static void transfer() {
        System.out.println("Enter username of account to transfer.(Enter 0 to exit)");
        String TrsUsername = scan.nextLine();

        try {
            if (!(new File("JavaBankDir\\" + TrsUsername + ".txt").exists())) {
                System.out.println("Error: Account with this username does not exist!");
                options();
            } else {
                System.out.println("Enter account number to transfer.(Enter 0 to exit)");
                int TempNumber = scan.nextInt();
                int FileNumber = Integer.parseInt(Files.readAllLines(Paths.get("JavaBankDir\\" + TrsUsername + ".txt")).get(1));

                if (TempNumber != FileNumber) {
                    System.out.println("Error: Incorrect number!");
                    options();
                } else {
                    System.out.println("How much do you want to transfer?(Enter 0 to exit)");
                    withdraw = scan.nextDouble();
                    scan.nextLine();

                    if (withdraw < 0) {
                        System.out.println("Error: invalid number!");
                        options();
                    } else {
                        try {
                            startingBalance = 0;
                            Double startingBalance = Double.parseDouble(Files.readAllLines(Paths.get("JavaBankDir\\" + username + ".txt")).get(3));
                            OldBalance = GetInterest(startingBalance);

                            if (withdraw > OldBalance) {
                                System.out.println("Error: invalid funds!");
                                options();
                            } else {
                                Double NewBalance = OldBalance - withdraw;
                                String filePath = "JavaBankDir\\" + username + ".txt";
                                String result = fileToString(filePath);
                                //Replacing the word with desired one
                                result = result.replaceAll(String.valueOf(startingBalance), String.valueOf(NewBalance));
                                //Rewriting the contents of the file
                                PrintWriter writer = new PrintWriter(filePath);
                                writer.append(result);
                                writer.flush();

                                startingBalance = Double.parseDouble(Files.readAllLines(Paths.get("JavaBankDir\\" + username + ".txt")).get(3));
                                OldBalance = GetInterest(startingBalance);
                                Double TrsNewBalance = OldBalance + withdraw;
                                filePath = "JavaBankDir\\" + username + ".txt";
                                result = fileToString(filePath);
                                //Replacing the word with desired one
                                result = result.replaceAll(String.valueOf(OldBalance), String.valueOf(TrsNewBalance));
                                writer = new PrintWriter(filePath);
                                writer.append(result);
                                writer.flush();
                                System.out.println("Successful!\nYour Current Balance: " + NewBalance + "\nTheir Current Balance: " + TrsNewBalance);
                                options();
                            }
                        } catch (Exception e) {
                            System.out.println("Sorry, something went wrong :(\n" + e);
                            options();
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Sorry, something went wrong :(\n" + e);
            options();
        }
    }

    public static void info() {
        try {
            for (int i = 0; i < 3; i++) {
                info = Files.readAllLines(Paths.get("JavaBankDir\\" + username + ".txt")).get(i);
                System.out.println(info);
            }

            startingBalance = Double.parseDouble(Files.readAllLines(Paths.get("JavaBankDir\\" + username + ".txt")).get(3));
            OldBalance = GetInterest(startingBalance);
            System.out.println(OldBalance);
            options();
        } catch (IOException e) {
            System.out.println("Sorry, something went wrong :(");
        }
        options();
    }*/

   /* public static String fileToString(String filePath) throws Exception {
        String input;
        Scanner sc = new Scanner(new File(filePath));
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) {
            input = sc.nextLine();
            input = (input + "\n");
            sb.append(input);
        }
        return sb.toString();
    }

    public static double GetInterest(double startingBalance) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        Path path = Paths.get("JavaBankDir\\" + username + ".txt");
        BasicFileAttributes attr;
        long toSec = 0;
        try {
            attr = Files.readAttributes(path, BasicFileAttributes.class);
            Duration res = Duration.between(attr.lastModifiedTime().toInstant(), Instant.now());
            toSec = res.getSeconds();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Sorry, something went wrong. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        double j = (((((float) toSec / 60) / 60) / 24) / 365);
        double total = Double.parseDouble(df.format((float) startingBalance * (1.1 * j)));
        startingBalance = startingBalance + total;
        return startingBalance;
    }
}
*/