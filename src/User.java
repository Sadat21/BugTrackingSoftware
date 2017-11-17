public class User {
    protected DatabaseController database;

    public void browseAllBugs(){

    }

    public void reportABug(String name, String description){
        Bug newBug = new Bug();
        newBug.setName(name);
        newBug.setValid(false);
        newBug.setDescription(description);
        database.addBugToDB(newBug);
    }
}
