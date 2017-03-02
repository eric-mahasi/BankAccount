import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.Scanner;

/**
 * Created by eric on 21/10/16.
 */
//This is the class that deals with storing the user's(s') data to a text file
public class Records extends Client {
    private static Client cl = new Client();
    private Formatter formatter;
    private Scanner input;
    public Records() {
    }

    //This opens the file and enables it for data entry
    public void loadFile() {
        try {
            formatter = new Formatter("accounts.txt");//opening the file
        } catch (Exception e) {
            System.err.println("Error while creating or opening the file");
            System.exit(1);
        }
    }

    //Adding user data into the text file
    public void addRecord() {
        Client cl = new Client();
        try {
            input = new Scanner(String.valueOf(Client.class));
        } catch (Exception e) {
            System.err.println("The file couldn't be found");
        }
        while (input.hasNext()) {
            try {
                cl.getAccountNumber();
                // cl.setFirstName(input.next());
                //cl.setLastName(input.next());
                // cl.setBalance(input.nextDouble());
                if (true) {
                    //writing a new record
                    formatter.format("%s %s %d %.2f \n", cl.getFirstName(), cl.getLastName(), cl.getAccountNumber(), cl.getBalance());
                } else {
                    //some message related to the condition
                }
            } catch (FormatterClosedException formatterClosedException) {
                System.err.println("Error writing to file");
            }
        }
    }

    public void closeFile() {
        if (formatter != null) {
            formatter.close();
        }
    }
}
