/**
 * This class is used to access the database (which is just a series of text files)
 * Created by Harjee on 2017-11-16.
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseController {

    private BufferedReader fileInput;
    private File file;
    static private int bugID = 1000;
    static private int devID = 1000;
    static private int prodID = 1000;
    static private int managerID = 1000;

    static int getBugID() { return bugID; }
    static int getDevID() { return devID; }
    static int getProdID() { return prodID; }
    static int getManagerID() { return managerID; }


    public boolean isBugInDB(Bug checkedBug)
    {
        try {
            file = new File ("./Data/bug.txt");
            fileInput = new BufferedReader(new FileReader(file));
        }
        catch(IOException e) {
            System.out.println("Error occurred while trying to open bug.txt in isBugInDB()");
        }

        String input;

        // Check to see if this bug already exists in the system or not
        try {
            while ((input = fileInput.readLine()) != null) {
                if((input.contains(checkedBug.getName())) || (input.contains(checkedBug.getDescription())))
                {
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


    public boolean addBugToDB(Bug bugAdded)
    {
        if(isBugInDB(bugAdded) == true)
        {
            System.out.println("Bug already exists in the DB!");
            return false;
        }

        String input = "";

        Integer ID = getBugID();
        bugID++;

        input += ID.toString();

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        input += sdf.format(new Date()) + "\t";

        input += "Undetermined" + "\t";
        input += "Undetermined" + "\t";
        input += "Unresolved" + "\t";
        input += "Bug_Unassigned" + "\t";
        input += "Still_Unresolved" + "\t";
        //TODO: This needs to be the product ID ***********************************************
        //input +=

        try {
            Files.write(Paths.get("./Data/bug.txt"), input.getBytes(), StandardOpenOption.APPEND);
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while adding the bug to the database");
            return false;
        }

        return true;
    }

    /**
     * This method is used to remove a bug from the database. It can also be used to remove all bugs associated
     * with a product if the product is removed from the database.
     * @param generalID: Either bugID or productID
     * @param position: The position of the ID in the database (Determines whether bugs are removed by
     *                bugID or by productID)
     */
    public boolean removeBugFromDB(int generalID, int position)
    {
        file = new File ("./Data/bug.txt");
        File temp = new File("./Data/temp.txt");
        BufferedWriter writer = null;
        try {
            temp.createNewFile();
        }
        catch(IOException e)
        {
            System.out.println("Error occurred with temp file in removeBugFromDB()");
            return false;
        }

        try {
            fileInput = new BufferedReader(new FileReader(file));
            writer = new BufferedWriter(new FileWriter(temp));
        }
        catch(IOException e) {
            System.out.println("Error occurred while trying to open bug.txt in removeBugFromDB()");
            return false;
        }

        String input;
        String summation = "";

        try {
            while ((input = fileInput.readLine()) != null) {
                String [] arr = input.split("\t");
                Integer ID = new Integer(arr[position]);

                if(ID == generalID)
                    continue;

                summation += input + "~";
                writer.write(input + "\n");
            }

            writer.close();
            boolean success = temp.renameTo(file);
            if(success)
            {
                System.out.println("Bug successfully removed");
            }
            else
            {
                System.out.println("Error occurred while removing bug");
                return false;
            }
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while trying to read from the bug.txt file in removeBugFromDB()");
            return false;
        }

        return true;
    }



    public boolean modifyBugInDB(int bugID, String updateInfo, int position)
    {
        file = new File ("./Data/bug.txt");
        File temp = new File("./Data/temp.txt");
        BufferedWriter writer = null;
        try {
            temp.createNewFile();
        }
        catch(IOException e)
        {
            System.out.println("Error occurred with temp file in modifyBugFromDB()");
            return false;
        }

        String input;
        String summed = "";
        try {
            while ((input = fileInput.readLine()) != null) {
                String [] arr = input.split("\t");
                Integer id = new Integer(bugID);

                if(arr[0] == id.toString())
                {
                    input = "";
                    arr[position] = updateInfo;
                    for(int i = 0; i < arr.length; i++)
                    {
                        input += arr[i] + "\t";
                    }
                }

                writer.write(input + "\n");
                summed += input + "~";
            }
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while trying to read from the bug.txt file in modifyBugInDB()");
            return false;
        }

        return true;
    }



    public boolean isProductInDB(Product prodChecked)
    {
        try {
            file = new File ("./Data/product.txt");
            fileInput = new BufferedReader(new FileReader(file));
        }
        catch(IOException e) {
            System.out.println("Error occurred while trying to open product.txt in isProductInDB()");
        }

        String input;

        // Check to see if this bug already exists in the system or not
        try {
            while ((input = fileInput.readLine()) != null) {
                if((input.contains(prodChecked.getName())) || (input.contains(prodChecked.getDescription())))
                {
                    return true;
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while trying to read from the product.txt file in isProductInDB()");
            return false;
        }
        return false;
    }



    public boolean addProductToDB(Product prodAdded)
    {
        if(isProductInDB(prodAdded) == true)
        {
            System.out.println("Product already exists in the DB!");
            return false;
        }

        String input = "";

        Integer ID = getProdID();
        prodID++;

        input += ID.toString() + "\t";

        input += prodAdded.getName() + "\t";
        input += prodAdded.getDescription();

        try {
            Files.write(Paths.get("./Data/product.txt"), input.getBytes(), StandardOpenOption.APPEND);
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while adding the product to the database");
            return false;
        }

        return true;
    }



    public boolean removeProductFromDB(int prodID)
    {
        file = new File ("./Data/product.txt");
        File temp = new File("./Data/temp.txt");
        BufferedWriter writer = null;
        try {
            temp.createNewFile();
        }
        catch(IOException e)
        {
            System.out.println("Error occurred with temp file in removeProductFromDB()");
            return false;
        }

        try {
            fileInput = new BufferedReader(new FileReader(file));
            writer = new BufferedWriter(new FileWriter(temp));
        }
        catch(IOException e) {
            System.out.println("Error occurred while trying to open product.txt in removeProductFromDB()");
        }

        String input;
        String summation = "";

        try {
            while ((input = fileInput.readLine()) != null) {
                String [] arr = input.split("\t");
                Integer ID = new Integer(arr[0]);

                if(ID == prodID)
                    continue;

                summation += input + "~";
                writer.write(input + "\n");
            }

            writer.close();
            boolean success = temp.renameTo(file);
            if(success)
            {
                System.out.println("Product successfully removed");
            }
            else
            {
                System.out.println("Error occurred while removing product");
            }
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while trying to read from the product.txt file in removeProductFromDB()");
            return false;
        }

        return true;
    }



    public boolean modifyProductInDB(int prodID, String updateInfo, int position)
    {
        file = new File ("./Data/product.txt");
        File temp = new File("./Data/temp.txt");
        BufferedWriter writer = null;
        try {
            temp.createNewFile();
        }
        catch(IOException e)
        {
            System.out.println("Error occurred with temp file in modifyProductInDB()");
            return false;
        }

        String input;
        try {
            while ((input = fileInput.readLine()) != null) {
                String [] arr = input.split("\t");
                Integer id = new Integer(prodID);

                if(arr[0] == id.toString())
                {
                    input = "";
                    arr[position] = updateInfo;
                    for(int i = 0; i < arr.length; i++)
                    {
                        input += arr[i] + "\t";
                    }
                }

                writer.write(input + "\n");
            }
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while trying to read from the product.txt file in modifyProductInDB()");
            return false;
        }

        return true;
    }



    public boolean isDeveloperInDB(Developer checkedDev)
    {
        try {
            file = new File ("./Data/developer.txt");
            fileInput = new BufferedReader(new FileReader(file));
        }
        catch(IOException e) {
            System.out.println("Error occurred while trying to open developer.txt for isDeveloperInDB()");
        }

        String input;

        // Check to see if this bug already exists in the system or not
        try {
            while ((input = fileInput.readLine()) != null) {
                if((input.contains(checkedDev.getUsername()) || (input.contains(checkedDev.getPassword()))))
                {
                    return true;
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while trying to read from the developer.txt file in isDeveloperInDB()");
            return false;
        }

        return false;
    }



    public boolean addDeveloperToDB(Developer addedDev)
    {
        if(isDeveloperInDB(addedDev) == true)
        {
            System.out.println("Developer Already Exists in the DB!");
            return false;
        }

        String input = "";

        Integer ID = getDevID();
        devID++;

        input += ID.toString() + "\t";

        input += addedDev.getUsername() + "\t";
        input += addedDev.getPassword();

        try {
            Files.write(Paths.get("./Data/developer.txt"), input.getBytes(), StandardOpenOption.APPEND);
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while adding the developer to the database");
            return false;
        }

        return true;
    }


    public boolean removeDeveloperFromDB(int developerID)
    {
        file = new File ("./Data/developer.txt");
        File temp = new File("./Data/temp.txt");
        BufferedWriter writer = null;
        try {
            temp.createNewFile();
        }
        catch(IOException e)
        {
            System.out.println("Error occurred with temp file in removeDeveloperFromDB()");
            return false;
        }

        try {
            fileInput = new BufferedReader(new FileReader(file));
            writer = new BufferedWriter(new FileWriter(temp));
        }
        catch(IOException e) {
            System.out.println("Error occurred while trying to open developer.txt in removeDeveloperFromDB()");
            return false;
        }

        String input;
        String summation = "";

        try {
            while ((input = fileInput.readLine()) != null) {
                String [] arr = input.split("\t");
                Integer ID = new Integer(arr[0]);

                if(ID == devID)
                    continue;

                writer.write(input + "\n");
            }

            writer.close();
            boolean success = temp.renameTo(file);
            if(success)
            {
                System.out.println("Developer successfully removed");
            }
            else
            {
                System.out.println("Error occurred while removing developer");
            }
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while trying to read from the developer.txt file in removeDeveloperFromDB()");
            return false;
        }

        return true;
    }



    public boolean modifyDeveloperInDB(int developerID, String updateInfo, int position)
    {
        file = new File ("./Data/developer.txt");
        File temp = new File("./Data/temp.txt");
        BufferedWriter writer = null;
        try {
            temp.createNewFile();
        }
        catch(IOException e)
        {
            System.out.println("Error occurred with temp file in modifyDeveloperInDB()");
            return false;
        }

        String input;
        try {
            while ((input = fileInput.readLine()) != null) {
                String [] arr = input.split("\t");
                Integer id = new Integer(developerID);

                if(arr[0] == id.toString())
                {
                    input = "";
                    arr[position] = updateInfo;
                    for(int i = 0; i < arr.length; i++)
                    {
                        input += arr[i] + "\t";
                    }
                }

                writer.write(input + "\n");
            }
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while trying to read from the product.txt file in modifyProductInDB()");
            return false;
        }

        return true;
    }



    // Traverses the bug file and returns a string with all bug info
    public String[] returnAllBugs()
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
                info += "~";
            }
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while reading in returnAllBugs()");
            return null;
        }

        String [] rv = info.split("~");
        return rv;
    }


    /**
     * Returns all of a product's bugs
     * @param prodID
     * @return
     */
    public String[] returnAllProductBugs(int prodID)
    {
        try {
            fileInput = new BufferedReader(new FileReader("./Data/bug.txt"));
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while trying to open bug.txt in returnAllProductBugs()");
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
                if(arr[8].equals(i.toString()))
                {
                    info += arr[1];
                    info += "~";
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while reading in returnAllProductBugs()");
            return null;
        }

        String[] rv = info.split("~");
        return rv;
    }



    // Used to send the product Name and ID to the GUI
    public String[] productNameIDPair()
    {
        try {
            fileInput = new BufferedReader(new FileReader("./Data/product.txt"));
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while trying to open bug.txt in productNameIDPair()");
            return null;
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

        String[] rv = info.split("\t");
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
            return null;
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
            System.out.println("Error occurred while reading in browseAssignedBugs()");
            return null;
        }

        String[] returnArr = rv.split("~");

        return returnArr;
    }

    public String[] browseBugReports()
    {
        try {
            fileInput = new BufferedReader(new FileReader("./Data/bugReport.txt"));
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while trying to open bugReport.txt in browseBugReports()");
            return null;
        }

        String returnV = "";
        String input;

        try
        {
            while((input = fileInput.readLine()) != null)
            {
                returnV += input + "~";
            }
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while reading in browseBugReports()");
            return null;
        }

        String[] rv = returnV.split("~");
        return rv;
    }

    public boolean addToBugReport(Bug reportedBug)
    {
        String input = "";

        input += "NO_ID" + "\t";
        input += reportedBug.getName() + "\t";
        input += "No_Date" + "\t";
        input += "N/A" + "\t";
        input += "N/A" + "\t";
        input += "N/A" + "\t";
        input += "N/A" + "\t";
        input += "N/A" + "\t";
        input += "N/A";

        try {
            Files.write(Paths.get("./Data/bugReport.txt"), input.getBytes(), StandardOpenOption.APPEND);
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while writing the bug report to the database");
            return false;
        }

        return true;
    }

    public boolean removeBugReport(Bug reportedBug)
    {
        file = new File ("./Data/bugReport.txt");
        File temp = new File("./Data/temp.txt");
        BufferedWriter writer = null;
        try {
            temp.createNewFile();
        }
        catch(IOException e)
        {
            System.out.println("Error occurred with temp file in removeBugReport()");
        }

        try {
            fileInput = new BufferedReader(new FileReader(file));
            writer = new BufferedWriter(new FileWriter(temp));
        }
        catch(IOException e) {
            System.out.println("Error occurred while trying to open bugReport.txt in removeBugReport()");
        }

        String input;

        try {
            while ((input = fileInput.readLine()) != null) {
                String[] arr = input.split("\t");

                if(arr[0].equals(reportedBug.getName()))
                    continue;

                writer.write(input + "\n");
            }

            writer.close();
            boolean success = temp.renameTo(file);
            if(success)
            {
                System.out.println("Bug Report successfully removed");
            }
            else
            {
                System.out.println("Error occurred while removing developer");
            }
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while trying to read from the developer.txt file in removeDeveloperFromDB()");
            return false;
        }

        return true;
    }
}
