import java.util.Vector;
import java.util.ArrayList;
import java.util.Date;

public class Developer extends User {

    /**
     *  The ID of the developer
     */
    private int developerID;

    /**
     *  The username of the developer
     */
    private String username;

    /**
     *  The password of the developer
     */
    private String password;

    /**
     *  The ArrayList for observers
     */

    public boolean modifyBug(int bugID, String updateInfo, int position){
        boolean success = database.modifyBugInDB(bugID, updateInfo, position);
        return success;
    }

    String[]  browseAssignments(int developerID){
        String[] assignedBugs = database.browseAssignedBugs(developerID);
        return assignedBugs;
    }


    /*
        Getters & Setters below
     */

    public int getDeveloperID() {
        return developerID;
    }

    public void setDeveloperID(int developerID) {
        this.developerID = developerID;
    }

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

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }
}
