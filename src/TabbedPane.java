import javax.swing.*;
import java.awt.*;

public class TabbedPane {
    //import variables
    String username = "kass", fullName = "fullName", accountNumber = "000000", transaction1 = "1", transaction2 = "2", transaction3 = "3";
    double balance = 101;
    String[] namesArray;
    //export variables
    int depositAmount, withdrawAmount, transferAmount, transfereeNameIndex;
    String newFullName, newUsername, newPassword, tranfereeName;

    public static void main(String[] args) {
        TabbedPane tabbedPane = new TabbedPane();
        tabbedPane.tabbedPane(tabbedPane.username);
    }

    public void tabbedPane(String usernameP) {
        Bank bank = new Bank();
        this.username = usernameP;
        bank.setUsername(username);
        bank.getInformation();
        this.fullName = bank.fullName;
        this.accountNumber = bank.accountNumberString;
        this.balance = bank.balance;
        this.transaction1 = String.valueOf(bank.transaction1);
        this.transaction2 = String.valueOf(bank.transaction2);
        this.transaction3 = String.valueOf(bank.transaction3);
        this.namesArray = bank.getNamesList();

        //<editor-fold desc="Set the Nimbus look and feel">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TabbedPane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //Create font
        Font font = new Font("Comic Sans MS", Font.PLAIN, 12);

        //Create Frame
        JFrame frame = new JFrame("Java Bank");

        //<editor-fold desc="Start declaring components of JFrame">
        JTabbedPane TabbedPane = new javax.swing.JTabbedPane();
        JPanel HomeTab = new javax.swing.JPanel();
        JPanel WelcomePane = new javax.swing.JPanel();
        JLabel VariableWelcomeText = new javax.swing.JLabel();
        JPanel ButtonPane = new javax.swing.JPanel();
        JButton DepositButton = new javax.swing.JButton();
        JButton WithdrawButton = new javax.swing.JButton();
        JButton TransferButton = new javax.swing.JButton();
        JButton InfoButton = new javax.swing.JButton();
        JPanel DepositTab = new javax.swing.JPanel();
        JPanel DepositQuestionPanel = new javax.swing.JPanel();
        JLabel DepositQuestionText = new javax.swing.JLabel();
        JPanel DepositSliderPanel = new javax.swing.JPanel();
        JSlider DepositSlider = new javax.swing.JSlider();
        JButton DepositConfirmButton = new javax.swing.JButton();
        JLabel VariableDepositText = new javax.swing.JLabel();
        JPanel WithdrawTab = new javax.swing.JPanel();
        JPanel WithdrawQuestionPanel = new javax.swing.JPanel();
        JLabel WithdrawQuestionText = new javax.swing.JLabel();
        JPanel WithdrawPanel = new javax.swing.JPanel();
        JSlider WithdrawSlider = new javax.swing.JSlider();
        JButton WithdrawConfirmButton = new javax.swing.JButton();
        JLabel VariableWithdrawText = new javax.swing.JLabel();
        JPanel TransferTab = new javax.swing.JPanel();
        JPanel TransferQuestionPanel = new javax.swing.JPanel();
        JLabel TransferQuestionText = new javax.swing.JLabel();
        JPanel TransferPanel = new javax.swing.JPanel();
        JSlider TransferSlider = new javax.swing.JSlider();
        JLabel VariableTransferText1 = new javax.swing.JLabel();
        JPanel TransfereeNamePanel = new javax.swing.JPanel();
        JLabel TransfereeNameText = new javax.swing.JLabel();
        JComboBox<String> TransfereeComboBox = new javax.swing.JComboBox<>();
        JButton TransferConfirmButton = new javax.swing.JButton();
        JPanel AccountTab = new javax.swing.JPanel();
        JPanel AccountPanel = new javax.swing.JPanel();
        JLabel UsernameText = new javax.swing.JLabel();
        JLabel FullNameText = new javax.swing.JLabel();
        JLabel NewPasswordText = new javax.swing.JLabel();
        JLabel AccountNumberText = new javax.swing.JLabel();
        JTextField VariableUsernameField = new javax.swing.JTextField();
        JTextField VariableFullNameText = new javax.swing.JTextField();
        JPasswordField NewPasswordField = new javax.swing.JPasswordField();
        JLabel VariableAccountNumber = new javax.swing.JLabel();
        JButton ChangeButton = new javax.swing.JButton();
        JPanel TransactionsPanel = new javax.swing.JPanel();
        JLabel Transactions1Text = new javax.swing.JLabel();
        JLabel Transaction2Text = new javax.swing.JLabel();
        JLabel Transaction3Text = new javax.swing.JLabel();
        JLabel AccountText = new javax.swing.JLabel();
        JButton LogOutButton = new javax.swing.JButton();
        //</editor-fold>

        //Sets Frame behaviors
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(true);

        TabbedPane.setFont((font));

        //<editor-fold desc="Home Tab Code">
        HomeTab.setFont((font));
        WelcomePane.setFont((font));
        VariableWelcomeText.setFont((font));
        VariableWelcomeText.setText("Welcome " + fullName);

        //<editor-fold desc="DO NOT TOUCH, WelcomePaneLayout">
        javax.swing.GroupLayout WelcomePaneLayout = new javax.swing.GroupLayout(WelcomePane);
        WelcomePane.setLayout(WelcomePaneLayout);
        WelcomePaneLayout.setHorizontalGroup(
                WelcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WelcomePaneLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(VariableWelcomeText)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        WelcomePaneLayout.setVerticalGroup(
                WelcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(WelcomePaneLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(VariableWelcomeText)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        //</editor-fold>

        ButtonPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, font));// NOI18N
        ButtonPane.setFont((font));

        DepositButton.setFont((font));
        DepositButton.setText("Deposit");
        DepositButton.addActionListener(e -> TabbedPane.setSelectedIndex(1));

        WithdrawButton.setFont((font));
        WithdrawButton.setText("Withdraw");
        WithdrawButton.addActionListener(e -> TabbedPane.setSelectedIndex(2));

        TransferButton.setFont((font));
        TransferButton.setText("Transfer");
        TransferButton.addActionListener(e -> TabbedPane.setSelectedIndex(3));

        InfoButton.setFont((font));
        InfoButton.setText("Account");
        InfoButton.addActionListener(e -> TabbedPane.setSelectedIndex(4));

        //<editor-fold desc="DO NOT TOUCH, ButtonPaneLayout">
        javax.swing.GroupLayout ButtonPaneLayout = new javax.swing.GroupLayout(ButtonPane);
        ButtonPane.setLayout(ButtonPaneLayout);
        ButtonPaneLayout.setHorizontalGroup(
                ButtonPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ButtonPaneLayout.createSequentialGroup()
                                .addContainerGap(14, Short.MAX_VALUE)
                                .addComponent(DepositButton)
                                .addGap(18, 18, 18)
                                .addComponent(WithdrawButton)
                                .addGap(18, 18, 18)
                                .addComponent(TransferButton)
                                .addGap(18, 18, 18)
                                .addComponent(InfoButton)
                                .addContainerGap(13, Short.MAX_VALUE))
        );
        ButtonPaneLayout.setVerticalGroup(
                ButtonPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ButtonPaneLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(ButtonPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(DepositButton)
                                        .addComponent(WithdrawButton)
                                        .addComponent(TransferButton)
                                        .addComponent(InfoButton))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        //</editor-fold>

        //<editor-fold desc="DO NOT TOUCH, HomeTabLayout">
        javax.swing.GroupLayout HomeTabLayout = new javax.swing.GroupLayout(HomeTab);
        HomeTab.setLayout(HomeTabLayout);
        HomeTabLayout.setHorizontalGroup(
                HomeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HomeTabLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(HomeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ButtonPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(WelcomePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        HomeTabLayout.setVerticalGroup(
                HomeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HomeTabLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(WelcomePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(ButtonPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        //</editor-fold>

        TabbedPane.addTab("Home", HomeTab);
        //</editor-fold>

        //<editor-fold desc="Deposit Tab Code">
        DepositTab.setFont((font));

        DepositQuestionPanel.setFont((font));

        DepositQuestionText.setFont((font));
        DepositQuestionText.setText("How much do you want to Deposit?");

        //<editor-fold desc="DO NOT TOUCH, DepositQuestionPaneLayout">
        javax.swing.GroupLayout DepositQuestionPanelLayout = new javax.swing.GroupLayout(DepositQuestionPanel);
        DepositQuestionPanel.setLayout(DepositQuestionPanelLayout);
        DepositQuestionPanelLayout.setHorizontalGroup(
                DepositQuestionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DepositQuestionPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DepositQuestionText)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DepositQuestionPanelLayout.setVerticalGroup(
                DepositQuestionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DepositQuestionPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DepositQuestionText)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        //</editor-fold>

        DepositSliderPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Deposit", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, font));// NOI18N
        DepositSliderPanel.setFont((font));

        DepositSlider.setFont((font));
        DepositSlider.setMaximum((int) Math.round(balance));
        DepositSlider.setMajorTickSpacing((int) Math.round(balance / 10d));
        DepositSlider.setMinorTickSpacing((int) Math.round(balance / 20d));
        DepositSlider.setPaintLabels(true);
        DepositSlider.setPaintTicks(true);
        DepositSlider.setValue((int) Math.round(balance));

        DepositConfirmButton.setFont((font));
        DepositConfirmButton.setText("Confirm");
        DepositConfirmButton.addActionListener(e -> {
            depositAmount = DepositSlider.getValue();
            bank.setUsername(username);
            //bank.setBalance(balance);
            frame.dispose();
            bank.changeBalance(depositAmount, "\tDeposited " + depositAmount + " dollars");
        });

        VariableDepositText.setFont((font));
        VariableDepositText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        VariableDepositText.setText("$" + (int) Math.round(balance));

        DepositSlider.addChangeListener(e -> VariableDepositText.setText("$" + DepositSlider.getValue()));

        //<editor-fold desc="DO NOT TOUCH, DepositSliderPanelLayout">
        javax.swing.GroupLayout DepositSliderPanelLayout = new javax.swing.GroupLayout(DepositSliderPanel);
        DepositSliderPanel.setLayout(DepositSliderPanelLayout);
        DepositSliderPanelLayout.setHorizontalGroup(
                DepositSliderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DepositSliderPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(DepositSliderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(DepositSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                                        .addGroup(DepositSliderPanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(DepositConfirmButton)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(VariableDepositText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        DepositSliderPanelLayout.setVerticalGroup(
                DepositSliderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DepositSliderPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(VariableDepositText)
                                .addGap(18, 18, 18)
                                .addComponent(DepositSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(DepositConfirmButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        //</editor-fold>

        //<editor-fold desc="DO NOT TOUCH, DepositTabLayout">
        javax.swing.GroupLayout DepositTabLayout = new javax.swing.GroupLayout(DepositTab);
        DepositTab.setLayout(DepositTabLayout);
        DepositTabLayout.setHorizontalGroup(
                DepositTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DepositTabLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(DepositTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DepositTabLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(DepositQuestionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(DepositSliderPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        DepositTabLayout.setVerticalGroup(
                DepositTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DepositTabLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(DepositQuestionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(DepositSliderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        //</editor-fold>

        TabbedPane.addTab("Deposit", DepositTab);
        //</editor-fold>

        //<editor-fold desc="Withdraw Tab Code">
        WithdrawTab.setFont((font));

        WithdrawQuestionPanel.setFont((font));

        WithdrawQuestionText.setFont((font));
        WithdrawQuestionText.setText("How much do you want to withdraw?");

        //<editor-fold desc="DO NOT TOUCH, WithdrawQuestionPanelLayout">
        javax.swing.GroupLayout WithdrawQuestionPanelLayout = new javax.swing.GroupLayout(WithdrawQuestionPanel);
        WithdrawQuestionPanel.setLayout(WithdrawQuestionPanelLayout);
        WithdrawQuestionPanelLayout.setHorizontalGroup(
                WithdrawQuestionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(WithdrawQuestionPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(WithdrawQuestionText)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        WithdrawQuestionPanelLayout.setVerticalGroup(
                WithdrawQuestionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(WithdrawQuestionPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(WithdrawQuestionText)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        //</editor-fold>

        WithdrawPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Withdraw", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, font));// NOI18N
        WithdrawPanel.setFont((font));

        WithdrawSlider.setFont((font));
        WithdrawSlider.setMaximum((int) Math.round(balance));
        WithdrawSlider.setMajorTickSpacing((int) Math.round(balance / 10d));
        WithdrawSlider.setMinorTickSpacing((int) Math.round(balance / 20d));
        WithdrawSlider.setPaintLabels(true);
        WithdrawSlider.setPaintTicks(true);
        WithdrawSlider.setValue((int) Math.round(balance));

        WithdrawConfirmButton.setFont((font));
        WithdrawConfirmButton.setText("Confirm");
        WithdrawConfirmButton.addActionListener(e -> {
            withdrawAmount = (WithdrawSlider.getValue() * -1);
            bank.setUsername(username);
            //bank.setBalance(balance);
            frame.dispose();
            bank.changeBalance(withdrawAmount, "\tWithdrew " + (-1 * withdrawAmount) + " dollars");
        });

        VariableWithdrawText.setFont((font));
        VariableWithdrawText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        VariableWithdrawText.setText("$" + (int) Math.round(balance));

        WithdrawSlider.addChangeListener(e -> VariableWithdrawText.setText("$" + WithdrawSlider.getValue()));

        //<editor-fold desc="DO NOT TOUCH, WithdrawPanelLayout">
        javax.swing.GroupLayout WithdrawPanelLayout = new javax.swing.GroupLayout(WithdrawPanel);
        WithdrawPanel.setLayout(WithdrawPanelLayout);
        WithdrawPanelLayout.setHorizontalGroup(
                WithdrawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WithdrawPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(WithdrawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(VariableWithdrawText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, WithdrawPanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(WithdrawConfirmButton)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(WithdrawSlider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE))
                                .addContainerGap())
        );
        WithdrawPanelLayout.setVerticalGroup(
                WithdrawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(WithdrawPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(VariableWithdrawText)
                                .addGap(18, 18, 18)
                                .addComponent(WithdrawSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(WithdrawConfirmButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        //</editor-fold>

        //<editor-fold desc="DO NOT TOUCH, WithdrawTabLayout">
        javax.swing.GroupLayout WithdrawTabLayout = new javax.swing.GroupLayout(WithdrawTab);
        WithdrawTab.setLayout(WithdrawTabLayout);
        WithdrawTabLayout.setHorizontalGroup(
                WithdrawTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(WithdrawTabLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(WithdrawTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(WithdrawTabLayout.createSequentialGroup()
                                                .addGap(0, 131, Short.MAX_VALUE)
                                                .addComponent(WithdrawQuestionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 131, Short.MAX_VALUE))
                                        .addComponent(WithdrawPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        WithdrawTabLayout.setVerticalGroup(
                WithdrawTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(WithdrawTabLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(WithdrawQuestionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(WithdrawPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(140, Short.MAX_VALUE))
        );
        //</editor-fold>

        TabbedPane.addTab("Withdraw", WithdrawTab);
        //</editor-fold>

        //<editor-fold desc="Transfer Tab Code">
        TransferTab.setFont((font));

        TransferQuestionPanel.setFont((font));

        TransferQuestionText.setFont((font));
        TransferQuestionText.setText("How much do you want to Transfer?");

        //<editor-fold desc="DO NOT TOUCH, TransferQuestionPanelLayout">
        javax.swing.GroupLayout TransferQuestionPanelLayout = new javax.swing.GroupLayout(TransferQuestionPanel);
        TransferQuestionPanel.setLayout(TransferQuestionPanelLayout);
        TransferQuestionPanelLayout.setHorizontalGroup(
                TransferQuestionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(TransferQuestionPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TransferQuestionText)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TransferQuestionPanelLayout.setVerticalGroup(
                TransferQuestionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(TransferQuestionPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TransferQuestionText)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        //</editor-fold>

        TransferPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transfer Amount", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, font));// NOI18N
        TransferPanel.setFont((font));

        TransferSlider.setFont((font));
        TransferSlider.setMaximum((int) Math.round(balance));
        TransferSlider.setMajorTickSpacing((int) Math.round(balance / 10d));
        TransferSlider.setMinorTickSpacing((int) Math.round(balance / 20d));
        TransferSlider.setPaintLabels(true);
        TransferSlider.setPaintTicks(true);
        TransferSlider.setValue((int) Math.round(balance));


        VariableTransferText1.setFont((font));
        VariableTransferText1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        VariableTransferText1.setText("$" + (int) Math.round(balance));

        TransferSlider.addChangeListener(e -> VariableTransferText1.setText("$" + TransferSlider.getValue()));

        //<editor-fold desc="DO NOT TOUCH, TransferPanelLayout">
        javax.swing.GroupLayout TransferPanelLayout = new javax.swing.GroupLayout(TransferPanel);
        TransferPanel.setLayout(TransferPanelLayout);
        TransferPanelLayout.setHorizontalGroup(
                TransferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TransferPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(TransferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(VariableTransferText1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TransferSlider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        TransferPanelLayout.setVerticalGroup(
                TransferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(TransferPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(VariableTransferText1)
                                .addGap(18, 18, 18)
                                .addComponent(TransferSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        //</editor-fold>

        TransfereeNamePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transferee Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, font));// NOI18N
        TransfereeNamePanel.setFont((font));

        TransfereeNameText.setFont((font));
        TransfereeNameText.setText("Transferee's Full Name");

        TransfereeComboBox.setFont((font));

        BoundsPopupMenuListener listener = new BoundsPopupMenuListener();
        TransfereeComboBox.addPopupMenuListener(listener);

        TransfereeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(namesArray));

        //<editor-fold desc="DO NOT TOUCH, TransfereeNamePanelLayout">
        javax.swing.GroupLayout TransfereeNamePanelLayout = new javax.swing.GroupLayout(TransfereeNamePanel);
        TransfereeNamePanel.setLayout(TransfereeNamePanelLayout);
        TransfereeNamePanelLayout.setHorizontalGroup(
                TransfereeNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(TransfereeNamePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(TransfereeNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(TransfereeNamePanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(TransfereeNameText)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(TransfereeComboBox, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addContainerGap())
        );
        TransfereeNamePanelLayout.setVerticalGroup(
                TransfereeNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(TransfereeNamePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(TransfereeNameText)
                                .addGap(18, 18, 18)
                                .addComponent(TransfereeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        //</editor-fold>

        TransferConfirmButton.setFont((font));
        TransferConfirmButton.setText("Confirm");
        TransferConfirmButton.addActionListener(e -> {
            transferAmount = TransferSlider.getValue();
            transfereeNameIndex = TransfereeComboBox.getSelectedIndex();
            tranfereeName = namesArray[transfereeNameIndex];
            frame.dispose();
            bank.transfer(transferAmount, transfereeNameIndex);
        });

        //<editor-fold desc="DO NOT TOUCH, TransferTabLayout">
        javax.swing.GroupLayout TransferTabLayout = new javax.swing.GroupLayout(TransferTab);
        TransferTab.setLayout(TransferTabLayout);
        TransferTabLayout.setHorizontalGroup(
                TransferTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(TransferTabLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(TransferTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(TransferTabLayout.createSequentialGroup()
                                                .addGap(0, 128, Short.MAX_VALUE)
                                                .addComponent(TransferQuestionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 135, Short.MAX_VALUE))
                                        .addComponent(TransferPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(TransferTabLayout.createSequentialGroup()
                                                .addComponent(TransfereeNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, Short.MAX_VALUE)
                                                .addComponent(TransferConfirmButton)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        TransferTabLayout.setVerticalGroup(
                TransferTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(TransferTabLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(TransferQuestionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(TransferPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(TransferTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(TransferTabLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(TransfereeNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(TransferTabLayout.createSequentialGroup()
                                                .addGap(60, 60, 60)
                                                .addComponent(TransferConfirmButton)))
                                .addContainerGap(68, Short.MAX_VALUE))
        );
        //</editor-fold>

        TabbedPane.addTab("Transfer", TransferTab);
        //</editor-fold>

        //<editor-fold desc="Account Tab Code">
        AccountTab.setFont((font));

        AccountPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Change and View Account Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, font));// NOI18N

        UsernameText.setFont((font));
        UsernameText.setText("Username");

        FullNameText.setFont((font));
        FullNameText.setText("FullName");

        NewPasswordText.setFont((font));
        NewPasswordText.setText("New Password");

        AccountNumberText.setFont((font));
        AccountNumberText.setText("Account Number");

        VariableUsernameField.setFont((font));
        VariableUsernameField.setText(username);

        VariableFullNameText.setFont((font));
        VariableFullNameText.setText(fullName);

        NewPasswordField.setFont((font));

        VariableAccountNumber.setFont((font));
        VariableAccountNumber.setText(accountNumber);

        ChangeButton.setFont(font);
        ChangeButton.setText("Change");
        ChangeButton.addActionListener(e -> {
            newUsername = VariableUsernameField.getText();
            newFullName = VariableFullNameText.getText();
            //noinspection deprecation
            newPassword = NewPasswordField.getText();
            //Change account information
            System.out.println("New username: " + newUsername + "\tNew full name: " + newFullName + "\tNew password: " + newPassword);
        });

        //<editor-fold desc="DO NOT TOUCH, AccountPanelLayout">
        javax.swing.GroupLayout AccountPanelLayout = new javax.swing.GroupLayout(AccountPanel);
        AccountPanel.setLayout(AccountPanelLayout);
        AccountPanelLayout.setHorizontalGroup(
                AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AccountPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(AccountPanelLayout.createSequentialGroup()
                                                .addGroup(AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(UsernameText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(FullNameText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(VariableUsernameField, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                                        .addComponent(VariableFullNameText))
                                                .addGap(18, 18, 18)
                                                .addGroup(AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(AccountNumberText)
                                                        .addComponent(NewPasswordText))
                                                .addGap(18, 18, 18)
                                                .addGroup(AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(NewPasswordField)
                                                        .addComponent(VariableAccountNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AccountPanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(ChangeButton)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        AccountPanelLayout.setVerticalGroup(
                AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AccountPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(UsernameText)
                                        .addComponent(NewPasswordText)
                                        .addComponent(VariableUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(NewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(FullNameText)
                                        .addComponent(AccountNumberText)
                                        .addComponent(VariableFullNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(VariableAccountNumber))
                                .addGap(18, 18, 18)
                                .addComponent(ChangeButton))
        );
        //</editor-fold>

        TransactionsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Previous Transactions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, font));// NOI18N

        Transactions1Text.setFont((font));
        Transactions1Text.setText(transaction1);

        Transaction2Text.setFont((font));
        Transaction2Text.setText(transaction2);

        Transaction3Text.setFont((font));
        Transaction3Text.setText(transaction3);

        //<editor-fold desc="DO NOT TOUCH, TransactionsPanelLayout">
        javax.swing.GroupLayout TransactionsPanelLayout = new javax.swing.GroupLayout(TransactionsPanel);
        TransactionsPanel.setLayout(TransactionsPanelLayout);
        TransactionsPanelLayout.setHorizontalGroup(
                TransactionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(TransactionsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(TransactionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Transactions1Text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Transaction2Text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Transaction3Text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        TransactionsPanelLayout.setVerticalGroup(
                TransactionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(TransactionsPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Transactions1Text)
                                .addGap(18, 18, 18)
                                .addComponent(Transaction2Text)
                                .addGap(18, 18, 18)
                                .addComponent(Transaction3Text)
                                .addContainerGap())
        );
        //</editor-fold>

        AccountText.setFont((font));
        AccountText.setText("View Account and Transaction Information");

        LogOutButton.setFont((font));
        LogOutButton.setText("Log Out");
        LogOutButton.addActionListener(e -> {
            bank.setUsername("null");
            frame.dispose();
            Intro intro = new Intro();
            intro.intro();

        });

        //<editor-fold desc="DO NOT TOUCH, AccountTabLayout">
        javax.swing.GroupLayout AccountTabLayout = new javax.swing.GroupLayout(AccountTab);
        AccountTab.setLayout(AccountTabLayout);
        AccountTabLayout.setHorizontalGroup(
                AccountTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AccountTabLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(AccountTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(AccountPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TransactionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(AccountTabLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(AccountText)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AccountTabLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(LogOutButton)))
                                .addContainerGap())
        );
        AccountTabLayout.setVerticalGroup(
                AccountTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AccountTabLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LogOutButton)
                                .addGap(21, 21, 21)
                                .addComponent(AccountText)
                                .addGap(25, 25, 25)
                                .addComponent(AccountPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TransactionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        //</editor-fold>

        TabbedPane.addTab("Account", AccountTab);
        //</editor-fold>

        //<editor-fold desc="DO NOT TOUCH, GroupLayout">
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        //</editor-fold>

        frame.pack();
        frame.setLocationRelativeTo(null);  //centers the jframe in the screen
        frame.setVisible(true);
    }
}