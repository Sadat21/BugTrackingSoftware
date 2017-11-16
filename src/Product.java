import java.util.Vector;

public class Product {
    private Vector<Bug> bugs;
    private String description;
    private int productID;
    private String name;

    public Vector<Bug> getBugs() {
        return bugs;
    }

    public void setBugs(Vector<Bug> bugs) {
        this.bugs = bugs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
