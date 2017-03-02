import java.util.Scanner;

/**
 * Created by eric on 21/10/16.
 */
//This class handles all the user data

public class Client {
    public static final double LIMIT = 10000;// the minimum amount an account can have
    private static Scanner userInput;
    private static double balance;
    private String firstName;
    private String lastName;
    private int accountNumber;

    public Client(Scanner input){
        userInput = input;
    }

    //method to deposit money into account
    public static void deposit() {
        System.out.println("Please enter the amount you want to deposit");
        double deposit = userInput.nextDouble();
        balance += deposit;
        System.out.println("Transaction completed\nAmount deposited: Ksh " + deposit);
        checkBalance();
    }

    //pretty self explanatory method
    public static void checkBalance() {
        System.out.println("Your account balance is: Ksh " + balance + "\n");
    }


    //This method handles basic user info and creates an account for them
    public void createAccount() {
        System.out.println("Welcome user.");
        System.out.println("Provide a few details to enable account creation priss");
        System.out.println("First name:");
        firstName = userInput.next();

        System.out.println("Last name:");
        lastName = userInput.next();

        accountNumber = (int) (Math.random() * 1000 + 1);//a random 3-digit number is chosen as the account number

        System.out.println("Thank you. Your account number is : " + accountNumber);

        System.out.println("Please make your initial deposit:");
        deposit();
    }

    //method to withdraw from account
    public void withdraw() {
        System.out.println("Please enter the amount you want to withdraw");
        double withdrawal = userInput.nextDouble();
        balance -= withdrawal;
        if (balance < LIMIT) {
            //this prevents the user from emptying his account
            System.out.println("Sorry, withdrawal limit exceeded");
            balance += withdrawal;
        } else {
            System.out.println("Transaction completed\nAmount withdrawn: Ksh " + withdrawal);
        }
        checkBalance();
    }
}
