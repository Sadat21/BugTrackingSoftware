/**
 * This class is used to access the database (which is just a series of text files)
 * Created by Harjee on 2017-11-16.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseController {

    private BufferedReader fileInput;
    static private int bugID = 1;
    static private int devID = 1;
    static private int prodID = 1;
    static private int managerID = 1;

    static int getBugID() { return bugID; }

    static int getDevID() { return devID; }

    static int getProdID() { return prodID; }

    static int getManagerID() { return managerID; }

    public boolean isBugInDB(Bug checkedBug)
    {

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
                    System.out.println("Sorry! This bug already exists in our system!");
                    return true;
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while trying to read from the bug.txt file");
            return false;
        }

        return false;
    }

    public void addBugToDB(Bug bugAdded)
    {
        if(isBugInDB(bugAdded) == true)
        {
            System.out.println("Bug Adding failed!");
            return;
        }

        String input = "";

        Integer ID = getBugID();
        bugID++;

        input += ID.toString();

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        input += sdf.format(new Date());

        input += "Undetermined";
        input += "Undetermined";
        input += "Unresolved";
        input += "Bug_Unassigned";
        input += "Still_Unresolved";

        try {
            Files.write(Paths.get("./Data/bug.txt"), input.getBytes(), StandardOpenOption.APPEND);
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while writing the bug to the database");
        }
    }

    public void removeBugFromDB(int bugID)
    {

    }

    public String modifyBugInDB(int bugID, String beingUpdated, int position)
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
        File tempFile = new File("./Data/bug_temp.txt");
    }

    public String modifyProductInDB(int prodID, String updateInfo, int position)
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
        File tempFile = new File("./Data/bug_temp.txt");
    }

    public String modifyDeveloperInDB(int developerID, String updateInfo, int position)
    {

    }

    // Traverses the bug file and returns a string with all bug info
    public String returnAllBugs()
    {
        try {
            fileInput = new BufferedReader(new FileReader("./Data/bug.txt"));
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while trying to open bug.txt in returnAllBugs()");
        }

        String info = "";
        String temp;
        try
        {
            while((temp = fileInput.readLine()) != null)
            {
                info += temp;
                info += "\n";
            }
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while reading in returnAllBugs()");
            return null;
        }

        return info;
    }

    /**
     * Returns all bugs assigned to a developer
     * @param prodID
     * @return
     */
    public String returnAllProductBugs(int prodID)
    {
        try {
            fileInput = new BufferedReader(new FileReader("./Data/bug.txt"));
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while trying to open bug.txt in returnAssignedBugs()");
        }

        String info = "";
        String temp;
        try
        {
            while((temp = fileInput.readLine()) != null)
            {
                Integer i = new Integer(prodID);
                String [] arr = temp.split("\t");

                // If the bug's dev ID == the argument id, add it to the return string
                if(arr[1].equals(i.toString()))
                {
                    info += temp;
                    info += "\n";
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while reading in returnAssignedBugs()");
            return null;
        }

        return info;
    }

    // Used to
    public String[] productNameIDPair()
    {
        try {
            fileInput = new BufferedReader(new FileReader("./Data/product.txt"));
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while trying to open bug.txt in productNameIDPair()");
        }

        String info = "";
        String temp;

        // Sends the product name and ID, in that order
        try
        {
            while((temp = fileInput.readLine()) != null)
            {
                String [] arr = temp.split("\t");
                info += arr[1] + "_" +arr[0] + "\t";
            }
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while reading in productNameIDPair()");
            return null;
        }

        String [] rv = info.split("\t");

        return rv;
    }

    public String[] browseAssignedBugs(int devID)
    {
        try {
            fileInput = new BufferedReader(new FileReader("./Data/bug.txt"));
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while trying to open bug.txt in ()");
        }

        Integer ID = new Integer(devID);

        String input = "";
        String rv = "";

        try
        {
            while((input = fileInput.readLine()) != null)
            {
                String [] arr = input.split("\t");
                if(arr[6].equals(ID.toString()))
                {
                    rv += input;
                    rv += "~";
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while reading in productNameIDPair()");
            return null;
        }

        String[] returnArr = rv.split("~");
        
        return returnArr;
    }
}
