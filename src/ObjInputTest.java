import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class ObjInputTest {
    private SafeInputObj safeInput;

    @Before
    public void setUp() {
        safeInput = new SafeInputObj(new Scanner(System.in));
    }

    @Test
    public void testGetNonZeroLenString() {
        String input = "Hello";
        InputStream in = new ByteArrayInputStream((input + "\n").getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);

        SafeInputObj safeInputObj = new SafeInputObj(sc);
        String result = safeInputObj.getNonZeroLenString("Enter something");
        assertEquals(input, result);
    }

    @Test
    public void testGetInt() {
        String input = "42";
        InputStream in = new ByteArrayInputStream((input + "\n").getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);

        SafeInputObj safeInputObj = new SafeInputObj(sc);
        int result = safeInputObj.getInt("Enter an integer");
        assertEquals(42, result);
    }

    @Test
    public void testGetDouble() {
        String input = "3.14";
        InputStream in = new ByteArrayInputStream((input + "\n").getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);

        SafeInputObj safeInputObj = new SafeInputObj(sc);
        double result = safeInputObj.getDouble("Enter a double");
        assertEquals(3.14, result, 0.001);
    }

    @Test
    public void testGetRangedInt() {
        String input = "10";
        InputStream in = new ByteArrayInputStream((input + "\n").getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);

        SafeInputObj safeInputObj = new SafeInputObj(sc);
        int result = safeInputObj.getRangedInt("Enter an integer between 1 and 20", 1, 20);
        assertEquals(10, result);
    }

    @Test
    public void testGetRangedDouble() {
        String input = "5.5";
        InputStream in = new ByteArrayInputStream((input + "\n").getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);

        SafeInputObj safeInputObj = new SafeInputObj(sc);
        double result = safeInputObj.getRangedDouble("Enter a double between 1.0 and 10.0", 1.0, 10.0);
        assertEquals(5.5, result, 0.001);
    }

    @Test
    public void testGetYNConfirm() {
        String input = "Y";
        InputStream in = new ByteArrayInputStream((input + "\n").getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);

        SafeInputObj safeInputObj = new SafeInputObj(sc);
        boolean result = safeInputObj.getYNConfirm("Confirm (Y/N)");
        assertTrue(result);
    }

    @Test
    public void testGetRegExString() {
        String input = "abc123";
        InputStream in = new ByteArrayInputStream((input + "\n").getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);

        SafeInputObj safeInputObj = new SafeInputObj(sc);
        String result = safeInputObj.getRegExString("Enter a string", "[a-zA-Z0-9]+");
        assertEquals(input, result);
    }
}
