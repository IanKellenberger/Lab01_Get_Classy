import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

// Ensure this import is correct for JUnit 4.13
// Make sure Product class is correctly imported if in a different package
public class ProductTest {

    private Product testProduct;

    @Before
    public void setUp() {
        // Initialize a test Product object
        testProduct = new Product("Laptop", "High-end gaming laptop", "12345", 1299.99);
    }

    @Test
    public void testGetName() {
        assertEquals("Laptop", testProduct.getName());
    }

    @Test
    public void testSetName() {
        testProduct.setName("Gaming Laptop");
        assertEquals("Gaming Laptop", testProduct.getName());
    }

    @Test
    public void testGetDescription() {
        assertEquals("High-end gaming laptop", testProduct.getDescription());
    }

    @Test
    public void testSetDescription() {
        testProduct.setDescription("Ultra high-end gaming laptop");
        assertEquals("Ultra high-end gaming laptop", testProduct.getDescription());
    }

    @Test
    public void testGetID() {
        assertEquals("12345", testProduct.getID());
    }

    @Test
    public void testGetCost() {
        assertEquals(1299.99, testProduct.getCost(), 0.001);
    }

    @Test
    public void testSetCost() {
        testProduct.setCost(1399.99);
        assertEquals(1399.99, testProduct.getCost(), 0.001);
    }

    @Test
    public void testToCSV() {
        String expectedCSV = "Laptop,High-end gaming laptop,12345,1299.99";
        assertEquals(expectedCSV, testProduct.toCSV());
    }

    @Test
    public void testToJSON() {
        String expectedJSON = "{\"name\":\"Laptop\",\"description\":\"High-end gaming laptop\",\"ID\":\"12345\",\"cost\":1299.99}";
        assertEquals(expectedJSON, testProduct.toJSON());
    }

    @Test
    public void testToXML() {
        String expectedXML = "<product>" +
                "<name>Laptop</name>" +
                "<description>High-end gaming laptop</description>" +
                "<ID>12345</ID>" +
                "<cost>1299.99</cost>" +
                "</product>";
        assertEquals(expectedXML, testProduct.toXML());
    }
}
