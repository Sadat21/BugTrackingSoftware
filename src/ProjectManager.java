import java.util.ArrayList;

public class ProjectManager extends User implements Observer{

    private String username;
    private String password;
    private int managerID;
    private ArrayList<Subject> subjects;

    public void browseBugReports(){}
    public void approveBugReport(Bug reportedBug){
        reportedBug.setValid(true);
    }
    public void addDeveloper(String username, String password){
        Developer newDeveloper = new Developer();
        newDeveloper.setUsername(username);
        newDeveloper.setPassword(password);
        database.addDeveloperToDB(newDeveloper);
    }

    public void removeDeveloper(Developer d){
        database.removeDeveloperFromDB(d);
    }

    public void assignDeveloper(Bug assign, Developer d){
        assign.setDeveloperID(d.getDeveloperID());
        d.getAssignedBugs().add(assign);
    }

    public void unassignDeveloper(Bug assign, Developer d){
        int bugID = assign.getBugID();
        for (int i = 0; i < d.getAssignedBugs().size(); i++) {
            if (d.getAssignedBugs().elementAt(i).getBugID() == bugID ) {
                d.getAssignedBugs().remove(i);
            }
        }

        /*
        Want to test this if it will work:
        d.getAssignedBugs().remove(assign);
         */
    }

    public void addProduct(String name, String description){
        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setDescription(description);
        database.addProductToDB(newProduct);
    }
    public void removeProduct(Product p){
        database.removeProductFromDB(p.getProductID());
    }

    public void modifyProduct(Product p, String updateInfo){
        p.setDescription(updateInfo);
        database.modifyProductInDB(p.getProductID(), updateInfo);
    }

    public void removeFixedBug(Bug bug){

    }

    public void update(String status) {}

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
