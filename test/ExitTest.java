import command.Exit;
import models.StringOrInteger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;


/**
 * This class contains JUnit tests to test the behaviour of the Exit Command Class.
 */
public class ExitTest {
    private Exit exit;
    private final List<StringOrInteger> parameterList = new ArrayList<>();

    /**
     * This methode initialise the Exit class for all tests
     */
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        exit = new Exit();
    }

    /**
     * This methode tests that the correct return value is transmitted to terminate the programm.
     */
    @Test
    public void testDel() {
        assertFalse(exit.runCommand(parameterList), "Exit command should return false");
    }
}
