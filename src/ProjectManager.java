import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.PrintWriter;

public class ProjectManager extends User {

    private String username;
    private String password;
    private int managerID;

    public String[] browseAllBugsInProduct(int productID){
        String[] allBugsInProduct = database.returnAllProductBugs(productID);
        return allBugsInProduct;
    }

    public boolean approveBugReport(int bugID){

        boolean isApproved = database.modifyBugInDB(bugID, "Fixed", 5);
        return isApproved;
    }

    public void addDeveloper(String username, String password){
        Developer newDeveloper = new Developer();
        newDeveloper.setUsername(username);
        newDeveloper.setPassword(password);
        database.addDeveloperToDB(newDeveloper);
    }

    public void removeDeveloper(int developerID){
        database.removeDeveloperFromDB(developerID);
    }

    public boolean assignDeveloper(int bugID, int developerID){
        Integer devID = developerID;
        boolean isAssigned = database.modifyBugInDB(bugID, devID.toString(), 6);
        return isAssigned;
    }

    public boolean addProduct(String name, String description){
        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setDescription(description);
        boolean isAdded = database.addProductToDB(newProduct);
        return isAdded;
    }
    public boolean removeProduct(int productID){
        boolean isRemoved = database.removeProductFromDB(productID);
        return isRemoved;
    }

    public boolean modifyProduct(int productID, String updateInfo, int position){
        boolean isModified = database.modifyProductInDB(productID, updateInfo, position);
        return isModified;
    }

    public boolean removeFixedBug(int bugID){

        boolean isRemoved = database.removeBugFromDB(bugID);
        if (isRemoved) {
            generateReport(bug);
        }
    }

    void generateReport(int bugID, String productName, String bugName, int developerID) {

        int elapsedTime;

        try {
            PrintWriter reportWriter = new PrintWriter(bugName + "-report.txt");
            reportWriter.println("Product: " + productName);
            reportWriter.println("Elapsed Time between submission & fixing: " + elapsedTime);
            reportWriter.println("Developer Responsible: " + developerID);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*
        Setters & Getters Below
     */

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

}
