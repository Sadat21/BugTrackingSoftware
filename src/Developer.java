import java.util.Vector;
import java.util.ArrayList;
import java.util.Date;

public class Developer extends User implements Subject{

    Vector<Bug> assignedBugs;

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
    private ArrayList<Observer> observers;


    Vector<Bug> modifyBug(Bug bug, String updateInfo, int position){
        bug.setBugStatus(updateInfo);
        Vector<Bug> updatedList = database.modifyBugInDB(bug, position);
        return updatedList;
    }

    public boolean reportFixedBug(Bug bug){
        bug.setFixed(true);
        Date todayDate = new Date();
        bug.setFixDate(todayDate);
        return
    }

    Vector<Bug>  browseAssignments(){
        database.browseAssignedBugs(developerID);
        return assignedBugs;
    }

    public void registerObserver(Observer o){
        observers.add(o);

        for (int i = 0; i < assignedBugs.size(); i++ ) {
            o.update(assignedBugs.elementAt(i).getBugStatus());
        }
    }
    public void removeObserver(Observer o){
        observers.remove(o);
    }

    public void notifyAllObservers(){
        for(int i = 0; i < observers.size(); i++)
        {
            Observer o = observers.get(i);

            for (int j = 0; j < assignedBugs.size(); j++ ) {
                o.update(assignedBugs.elementAt(i).getBugStatus());
            }
        }
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
