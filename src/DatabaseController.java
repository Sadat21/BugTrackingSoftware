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
            System.out.println("Error occurred while trying to read from the loginInfo.txt file");
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

    public boolean verifyLogin(String username, String password)
    {
        fileInput
        return false;
    }
}
