import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    private Person person;

    @Before
    public void setUp() {
        // Set up a Person object before each test
        person = new Person("John", "Doe", "JD123", "Mr.", 1985);
    }

    @Test
    public void testFullName() {
        assertEquals("John Doe", person.fullName());
    }

    @Test
    public void testFormalName() {
        assertEquals("Mr. John Doe", person.formalName());
    }

    @Test
    public void testGetAge() {
        // Assuming the current year is 2024
        assertEquals(39, person.getAge());
    }

    @Test
    public void testGetAgeForSpecificYear() {
        // Test the getAge method for a specific year
        assertEquals(30, person.getAge(2015));
    }

    @Test
    public void testToCSV() {
        String expectedCSV = "John,Doe,JD123,Mr.,1985";
        assertEquals(expectedCSV, person.toCSV());
    }

    @Test
    public void testToJSON() {
        String expectedJSON = "{\"firstName\":\"John\",\"lastName\":\"Doe\",\"ID\":\"JD123\",\"title\":\"Mr.\",\"YOB\":1985}";
        assertEquals(expectedJSON, person.toJSON());
    }

    @Test
    public void testToXML() {
        String expectedXML = "<person><firstName>John</firstName><lastName>Doe</lastName><ID>JD123</ID><title>Mr.</title><YOB>1985</YOB></person>";
        assertEquals(expectedXML, person.toXML());
    }
}
