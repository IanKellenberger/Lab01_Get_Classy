public class Product {
    private String name;
    private String description;
    private String ID; // should never change
    private double cost;

    // Constructor
    public Product(String name, String description, String ID, double cost) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for ID
    public String getID() {
        return ID;
    }

    // Getter for cost
    public double getCost() {
        return cost;
    }

    // Setter for cost
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Returns a CSV representation of the Product object.
     * @return A comma-separated value (CSV) string.
     */
    public String toCSV() {
        return String.join(",", name, description, ID, String.valueOf(cost));
    }

    /**
     * Returns a JSON representation of the Product object.
     * @return A JSON string.
     */
    public String toJSON() {
        return String.format("{\"name\":\"%s\",\"description\":\"%s\",\"ID\":\"%s\",\"cost\":%.2f}",
                name, description, ID, cost);
    }

    /**
     * Returns an XML representation of the Product object.
     * @return An XML string.
     */
    public String toXML() {
        return String.format("<product>" +
                        "<name>%s</name>" +
                        "<description>%s</description>" +
                        "<ID>%s</ID>" +
                        "<cost>%.2f</cost>" +
                        "</product>",
                name, description, ID, cost);
    }
}
