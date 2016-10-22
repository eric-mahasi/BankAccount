import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Created by eric on 21/10/16.
 */
public class Records extends Accounts {
    public Records() {

    }

    private Formatter formatter;
    private Scanner fileReader;

    public void createFile() {
        try {
            formatter = new Formatter("accounts.txt");
        } catch (Exception e) {
            System.out.println("Sorry, file not found");
        }
    }

    public void loadFile() {
        try {
            fileReader = new Scanner(new File("ourFile.txt"));
        } catch (Exception e) {
            System.out.println("The file couldn't be found");
        }
    }

    public void readFile() {
        while (fileReader.hasNext()) {
            String a = fileReader.next();
            String b = fileReader.next();
            String c = fileReader.next();
        }
        System.out.format("%s %s re.addRecord();%s \n", " a, b ,c");
    }

    public void addRecord() {
        Accounts ca = new Accounts();
        ca.createAccount();
        formatter.format("%s %s %s \n", ca.getFirstName(), ca.getLastName(), ca.getAccountNumber());
    }

    public void closeFile() {
        formatter.close();
        //fileReader.close();
    }

}
