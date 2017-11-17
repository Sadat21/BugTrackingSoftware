import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Harjee on 2017-11-16.
 */
public class Login {

    private static Login onlyInstance;
    private ArrayList<String> usernames;
    private ArrayList<String> passwords;
    private ArrayList<String> userStatus;

    /**
     * Initializes Login's fields. Reads from a file called 'login.txt', and reads all of the informaton
     * in the file into the proper arraylists.
     */
    private Login()
    {
        usernames = new ArrayList<>();
        passwords = new ArrayList<>();
        userStatus = new ArrayList<>();

        BufferedReader fileInput = null;

        try {
            fileInput = new BufferedReader(new FileReader("./Data/login.txt"));
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while trying to open login.txt");
        }

        String temp = "";
        try
        {
            while((temp = fileInput.readLine()) != null)
            {
                String [] arr = temp.split("\t");

                usernames.add(arr[0]);
                passwords.add(arr[1]);
                userStatus.add(arr[2]);
            }
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while reading from login.txt");
        }
    }

    public static Login getOnlyInstance()
    {
        if(onlyInstance == null)
        {
            onlyInstance = new Login();
        }

        return onlyInstance;
    }

    /**
     * Verifies whether the login exists
     * @param username
     * @param password
     * @param status
     * @return verified - A boolean indicating whether or not login was successful
     */
    public boolean verifyLogin(String username, String password, String status)
    {
        boolean verified = false;
        for(int i = 0; i < usernames.size(); i++)
        {
            if(username.equals(usernames.get(i)) && password.equals(passwords.get(i)) && status.equals(userStatus.get(i)))
            {
                verified = true;
                break;
            }
        }

        return verified;
    }
}
