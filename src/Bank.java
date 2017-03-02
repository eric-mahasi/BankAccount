import java.util.Scanner;

/**
 * Created by eric on 21/10/16.
 * This program is about a bank account
 * It has the basic functionality of a bank account
 */

//This class is the driver
//It displays the welcome message to the user and handles all the objects from the other classes

public class Bank {
    private static Scanner userInput;
    private static Client client;
    //private static Records record = new Records();

    // This method offers the user with some choices
    // It also keeps displaying those choices until the user enters a valid one

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
                client.withdraw();
                break;
            case 2:
                client.deposit();
                break;
            case 3:
                client.checkBalance();
                break;
            case 4:
                userInput.close();
                System.exit(0);
            default:
                System.err.println("Invalid choice bana");
                break;
        }
        displayWelcomeMessage();
    }

    public static void main(String[] args) {
        userInput = new Scanner(System.in);
        client = new Client(userInput);

        client.createAccount();
        //record.loadFile();
        //record.addRecord();
        //record.closeFile();
        displayWelcomeMessage();
    }
}
