public class User {

    public void browseAllBugs(){}

    public void reportABug(String name, String description){
        Bug newBug = new Bug();
        newBug.setName(name);
        newBug.setValid(false);
        newBug.setDescription(description);
    }
}
