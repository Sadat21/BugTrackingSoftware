import java.util.Vector;

public class Product {

    Vector<Bug> productBugs;

    /**
     * The description of the product
     */
    private String description;

    /**
     *  The ID of the product
     */
    private int productID;

    /**
     *  The name of the product
     */
    private String name;

    /**
     * Setters and Getters below
     */

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
