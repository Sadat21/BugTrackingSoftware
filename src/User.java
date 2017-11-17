import java.util.Date;

public class User {
    protected DatabaseController database;

    String[] browseProductBugs(int productID){

        String[] bugsInProduct = database.returnAllProductBugs(productID);
        return bugsInProduct;
    }

    public void reportABug(String name, String description){
        Bug newBug = new Bug();
        newBug.setName(name);
        newBug.setDescription(description);
        newBug.setBugStatus("Unconfirmed");
        Date todayDate = new Date();
        newBug.setDate(todayDate);
        database.addBugToDB(newBug);
    }
}
