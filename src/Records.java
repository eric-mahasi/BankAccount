import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

/**
 * Created by eric on 21/10/16.
 */
//This is the class that deals with storing the user's data to a text file
public class Records {
    private static final int TRIALS = 3; // number of times a user can get to enter an account number
    private Scanner userInput;
    private Client client;

    public Records(Scanner input, Client client){
        userInput = input;
        this.client = client;
        System.out.println("Welcome user.");

        while(true){
            System.out.println("Select an option:" +
                "\n1.New User" +
                "\n2.Existing User");

            try{
                int option = userInput.nextInt();
                if (option == 1 || option == 2){
                    switch (option){
                        case 1:
                            this.client.createAccount();
                            break;
                        case 2:
                            getUserRecord();
                            break;
                    }
                }
                break;
            } catch(InputMismatchException e){
                System.err.println("Please choose between option 1 and 2");
                userInput.next();
            }
        }
    }

    public void getUserRecord() {
        int round = 1;
        String account;
        while (round <= TRIALS) {
            System.out.println("Enter your account number: ");
            try {
                account = userInput.next();
                Path path = Paths.get("accounts",account + ".txt");
                loadFile(path);
                System.out.println(" ");
                System.out.println("Welcome "
                    + client.getFirstName()
                    + " " + client.getLastName());
                break;
            } catch(FileNotFoundException e) {
                System.err.println("Account not found.");
            } catch(IOException e) {
                System.err.println("An error occured in opening the file.");
            }
            System.out.println("Try again.");
            round++;
        }

    }

    //This opens the file and enables it for data entry
    public void loadFile(Path path) throws IOException{
        try (Scanner scanner = new Scanner(path)){
            for (int i = 0; i <= 4; ++i){
                if (scanner.hasNext()){
                    String line = scanner.next();
                    switch (i) {
                        case 0:
                            client.setAccountNumber(Integer.parseInt(line));
                            break;
                        case 1:
                            client.setFirstName(line);
                            break;
                        case 2:
                            client.setLastName(line);
                            break;
                        case 3:
                            client.setBalance(Double.parseDouble(line));
                            break;
                    }
                }
            }
        } catch(IOException e){
            throw e;
        }
    }

    //Adding user data into the text file
    /*public void addRecord() {
        Client client = new Client();
        try {
            input = new Scanner(String.valueOf(Client.class));
        } catch (Exception e) {
            System.err.println("The file couldn't be found");
        }
        while (input.hasNext()) {
            try {
                client.getAccountNumber();
                // client.setFirstName(input.next());
                //client.setLastName(input.next());
                // client.setBalance(input.nextDouble());
                if (true) {
                    //writing a new record
                    formatter.format("%s %s %d %.2f \n", client.getFirstName(), client.getLastName(), client.getAccountNumber(), client.getBalance());
                } else {
                    //some message related to the condition
                }
            } catch (FormatterClosedException formatterClosedException) {
                System.err.println("Error writing to file");
            }
        }
    }*/
}
