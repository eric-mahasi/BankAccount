import java.util.Scanner;

/**
 * Created by eric on 21/10/16.
 */
//This is the class that deals with storing the user's data to a text file
public class Records {
    private Scanner userInput;
    private Client client;

    public Records(Scanner input, Client client){
        userInput = input;
        this.client = client
        System.out.println("Welcome user.");

        do{
            System.out.println("Select an option:" +
                "\n1.New User" +
                "\n2.Existing User");
            try{
                switch (userInput.nextInt()){
                    case 1:
                        this.client.createAccount();
                        break;
                    case 2:
                        getUserRecord();
                        break;
                }
            break;
            } catch(InputMismatchException e){
                System.err.println("Please choose between option 1 and 2.");
                continue;
            }
        }while(true);
    }

    public void getUserRecord(){

    }

    /*//This opens the file and enables it for data entry
    public void loadFile() {
        try {
            formatter = new Formatter("accounts.txt");//opening the file
        } catch (Exception e) {
            System.err.println("Error while creating or opening the file");
            System.exit(1);
        }
    }*/

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
