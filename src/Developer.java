import java.util.Vector;
import java.util.ArrayList;

public class Developer implements Subject{
    private Vector<Bug> assignedBugs;
    private int developerID;
    private String username;
    private String password;
    private ArrayList<Observer> observers;

    public void updateBug(Bug bug, String updateStatus){}
    public void reportFixedBug(Bug bug){}
    public void browseAssignments(){}
    public void browseAllBugs(){}
    public void reportABug(String name, String description){}
    public void registerObserver(Observer o){}
    public void removeObserver(Observer o){}
    public void notifyAllObservers(){}

    public Vector<Bug> getAssignedBugs() {
        return assignedBugs;
    }

    public void setAssignedBugs(Vector<Bug> assignedBugs) {
        this.assignedBugs = assignedBugs;
    }

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
