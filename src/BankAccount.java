import java.util.Scanner;

/**
 * Created by eric on 21/10/16.
 * This program is about a bank account
 * It has the basic functionality of a bank account
 * Also multiple users and multiple accounts
 */
public class BankAccount {
    //These are some variables
    private static Scanner userInput = new Scanner(System.in);
    private static BankAccount ba = new BankAccount();
    private static double balance;
    private static double deposit;
    private static double withdrawal;


    public BankAccount() {
        balance = 10000;//by default, the minimal amount of money in the account
    }

    //method to withdraw from account
    public static void withdraw() {
        System.out.println("Please enter the amount you want to withdraw");
        withdrawal = userInput.nextDouble();
        ba.setWithdrawal(withdrawal);
        if (withdrawal >= ba.getBalance()) {
            //this prevents the user from emptying his account
            System.out.println("Sorry, withdrawal limit exceeded");
            System.exit(0);
        } else {
            balance -= withdrawal;
            ba.setBalance(balance);
        }
        System.out.println("Transaction completed\nAmount withdrawn: Ksh " + ba.getWithdrawal());
        checkBalance();
    }

    //method to deposit money into account
    public static void deposit() {
        System.out.println("Please enter the amount you want to deposit");
        deposit = userInput.nextDouble();
        ba.setDeposit(deposit);
        balance += deposit;
        ba.setBalance(balance);
        System.out.println("Transaction completed\nAmount deposited: Ksh " + ba.getDeposit());
        checkBalance();
    }

    //pretty self explanatory method
    public static void checkBalance() {
        System.out.println("Your account balance is: Ksh " + ba.getBalance());
    }

    /***
     * This method offers the user with some choices
     * It also keeps displaying those choices until the user enters a valid one
     */
    public static void displayWelcomeMessage() {
        int choice;
        System.out.println("Please select an action" +
                "\n1.Withdraw" +
                "\n2.Deposit" +
                "\n3.Check Balance" +
                "\n4.Exit");
        choice = userInput.nextInt();


        switch (choice) {
            case 1:
                withdraw();
                break;
            case 2:
                deposit();
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Invalid choice bana");
                break;
        }
        displayWelcomeMessage();
    }

    public static void main(String[] args) {
        Accounts ca = new Accounts();
        Records re = new Records();

        re.createFile();
        re.loadFile();
        re.addRecord();
//        re.closeFile();
        //ca.createAccount();

       // re.readFile();
        re.closeFile();
        displayWelcomeMessage();
        userInput.close();
    }

    //getter and setter methods
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(double withdrawal) {
        this.withdrawal = withdrawal;
    }
}
