import java.util.ArrayList;

public class ProjectManager implements Observer{

    private String username;
    private String password;
    private int managerID;
    private ArrayList<Subject> subjects;

    public void browseAllBugs() {}
    public void browseBugReports(){}
    public void approveBugReport(Bug reportedBug){}
    public void addDeveloper(String username, String password){}
    public void removeDeveloper(Developer d){}
    public void assignDeveloper(Bug assign, Developer d){}
    public void unassignDeveloper(Bug assign, Developer d){}
    public void addProduct(String name, String description){}
    public void removeProduct(Product p){}
    public void modifyProduct(int ID, String updateInfo){}
    public void removeFixedBug(Bug bug){}
    public void update(String bugInfo, int bugID){}

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

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }


}
