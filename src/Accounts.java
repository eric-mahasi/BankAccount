import java.util.Scanner;

/**
 * Created by eric on 21/10/16.
 */
public class Accounts {
    private String firstName;
    private String lastName;
    private int accountNumber;

    public Accounts() {

    }

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


    public void createAccount() {
        Accounts ca = new Accounts();

        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome user.");
        System.out.println("Provide a few details to enable account creation priss");
        System.out.println("First name:");
        firstName = userInput.next();
        ca.setFirstName(firstName);

        System.out.println("Last name:");
        lastName = userInput.next();
        ca.setLastName(lastName);

        accountNumber = (int) (Math.random()*100 + 1);
        ca.setAccountNumber(accountNumber);

        System.out.println("Thank you. Your account number is : " + ca.getAccountNumber());
    }
}
