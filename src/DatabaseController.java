/**
 * This class is used to access the database (which is just a series of text files)
 * Created by Harjee on 2017-11-16.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DatabaseController {

    private BufferedReader fileInput = null;

    public DatabaseController()
    {
    }

    public void isBugInDB(Bug checkedBug)
    {
        boolean exists = false;

        try {
            fileInput = new BufferedReader(new FileReader("./Data/bug.txt"));
        }
        catch(IOException e) {
            System.out.println("Error occurred while trying to open bug.txt");
        }

        String input;

        // Check to see if this bug already exists in the system or not
        try {
            while ((input = fileInput.readLine()) != null) {
                if((input.contains(checkedBug.getName())) || (input.contains(checkedBug.getDescription())))
                {
                    exists = true;
                    break;
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while trying to read from the bug.txt file");
        }

        if(exists)
        {
            System.out.println("Sorry! This bug already exists in our system!");
        }

        // Add it to the DB if it's not already in there
        else
        {
            addBugToDB(checkedBug);
        }
    }

    public void addBugToDB(Bug bugAdded)
    {

    }

    public void removeBugFromDB(int bugID)
    {

    }

    public void modifyBugInDB(int bugID)
    {

    }

    public void isProductInDB(Product prodChecked)
    {

    }

    public void addProductToDB(Product prodAdded)
    {

    }

    public void removeProductFromDB(int prodID)
    {

    }

    public void modifyProductInDB(int prodID, String updateInfo)
    {

    }

    public void isDeveloperInDB(Developer checkedDev)
    {

    }

    public void addDeveloperToDB(Developer addedDev)
    {

    }

    public void removeDeveloperFromDB(int developerID)
    {

    }

    public void modifyDeveloperInDB(int developerID, String updateInfo)
    {

    }

    public boolean verifyDeveloperLogin(String username, String password)
    {
        try {
            fileInput = new BufferedReader(new FileReader("./Data/devLogin.txt"));
        }
        catch(IOException e) {
            System.out.println("Error occurred while trying to open devLogin.txt");
        }



        return false;
    }

    public boolean verifyManagerLogin(String username, String password)
    {
        try {
            fileInput = new BufferedReader(new FileReader("./Data/managerLogin.txt"));
        }
        catch(IOException e) {
            System.out.println("Error occurred while trying to open managerLogin.txt");
        }

        String input;

        // Find this manager in the database
        try {
            while ((input = fileInput.readLine()) != null) {
                String[] parsed = input.split("\t");

                if(parsed[0].equals(username) && parsed[1].equals(password))
                {
                    return true;
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while trying to read from the managerLogin.txt file");
        }

        return false;
    }
}
