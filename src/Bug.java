import java.util.Date;

/**
 * The bug entity class
 */
public class Bug {

    /**
     * The name of the bug
     */
    private String name;

    /**
     *  The date the bug was reported
     */
    private Date date;

    /**
     *  The date the bug was fixed
     */
    private Date fixDate;

    /**
     *  A boolean to determine whether the bug is fixed or not
     */
    private boolean isFixed;

    /**
     *  The category of bug
     */
    private String category;

    /**
     *  The critical importance of the bug
     */
    private String importance;

    /**
     *  The description of the bug
     */
    private String description;

    /**
     *  The status of the bug
     */
    private String bugStatus;

    /**
     *  The ID of the bug
     */
    private int bugID;

    /**
     *  Whether the bug is valid or a fake report/troll
     */
    private boolean isValid;

    /**
     *  The ID of the developer
     */
    private int developerID;


    /*
     * Setters & Getters below
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getFixDate() {
        return fixDate;
    }

    public void setFixDate(Date fixDate) {
        this.fixDate = fixDate;
    }

    public boolean isFixed() {
        return isFixed;
    }

    public void setFixed(boolean fixed) {
        isFixed = fixed;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImportance() {
        return importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBugStatus() {
        return bugStatus;
    }

    public void setBugStatus(String bugStatus) {
        this.bugStatus = bugStatus;
    }

    public int getBugID() {
        return bugID;
    }

    public void setBugID(int bugID) {
        this.bugID = bugID;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public int getDeveloperID() {
        return developerID;
    }

    public void setDeveloperID(int developerID) {
        this.developerID = developerID;
    }
}
