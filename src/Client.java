import java.util.Scanner;

/**
 * Created by eric on 21/10/16.
 */
//This class handles all the user data

public class Client {
    private static double balance;
    private static double deposit;
    private static double withdrawal;
    private static Scanner userInput = new Scanner(System.in);
    private static Client client = new Client();
    //private static Bank ba = new Bank();
    private String firstName;
    private String lastName;
    private int accountNumber;

    public Client() {
        balance = 10000;//by default, the minimal amount of money in the account
    }

    //This constructor will be used to pass data into an object to store the data to a file
    public Client(int acctNo, String first, String last, double bal) {
        setFirstName(first);
        setAccountNumber(acctNo);
        setLastName(last);
        setBalance(bal);
    }

    //method to deposit money into account
    public static void deposit() {
        System.out.println("Please enter the amount you want to deposit");
        deposit = userInput.nextDouble();
        client.setDeposit(deposit);
        balance += deposit;
        client.setBalance(balance);
        System.out.println("Transaction completed\nAmount deposited: Ksh " + client.getDeposit());
        checkBalance();
    }

    //pretty self explanatory method
    public static void checkBalance() {
        System.out.println("Your account balance is: Ksh " + client.getBalance() + "\n");
    }

    //getter and setter methods
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

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

    //This method handles basic user info and creates an account for them
    public void createAccount() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome user.");
        System.out.println("Provide a few details to enable account creation priss");
        System.out.println("First name:");
        firstName = userInput.next();
        client.setFirstName(firstName);

        System.out.println("Last name:");
        lastName = userInput.next();
        client.setLastName(lastName);

        accountNumber = (int) (Math.random() * 1000 + 1);//a random 3-digit number is chosen as the account number
        client.setAccountNumber(accountNumber);

        System.out.println("Thank you. Your account number is : " + client.getAccountNumber());

    }

    //method to withdraw from account
    public void withdraw() {
        System.out.println("Please enter the amount you want to withdraw");
        withdrawal = userInput.nextDouble();
        client.setWithdrawal(withdrawal);
        if (withdrawal >= client.getBalance()) {
            //this prevents the user from emptying his account
            System.out.println("Sorry, withdrawal limit exceeded");
            System.exit(0);
        } else {
            balance -= withdrawal;
            client.setBalance(balance);
        }
        System.out.println("Transaction completed\nAmount withdrawn: Ksh " + client.getWithdrawal());
        checkBalance();
    }
}
