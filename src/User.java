import java.util.Vector;
import java.util.Date;

public class User {
    protected DatabaseController database;

    Vector<Bug> browseAllBugs(){
        String[] allBugs = database.returnAllBugs();
        return allBugs;
    }

    public void reportABug(String name, String description){
        Bug newBug = new Bug();
        newBug.setName(name);
        newBug.setValid(false);
        newBug.setFixed(false);
        newBug.setDescription(description);

        Date todayDate = new Date();
        newBug.setDate(todayDate);

        database.addBugToDB(newBug);
    }
}
