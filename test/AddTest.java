import command.AbstractCommand;
import command.Add;
import models.StringOrInteger;
import models.Text;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * This class contains JUnit tests to test the behaviour of the Add command Class with different input values.
 *
 * @since 1.0.0
 */
public class AddTest {
    private AbstractCommand add;
    private Text text;
    private final List<StringOrInteger> parameterList = new ArrayList<>();

    /**
     * This methode initialise the add class and text class for all tests
     */
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        text = new Text();
        add = new Add();
        add.setText(text);
    }

    /**
     * This methode tests to add a single new paragraph (Text) to the Text class.
     */
    @Test
    public void testAddSingle() throws Exception {
        parameterList.add(0, new StringOrInteger(1));
        parameterList.add(1, new StringOrInteger("New text to add."));

        add.runCommand(parameterList);
        assertEquals("New text to add.", text.getParagraphAtIndex(1).getData(), "Text is not correct");
    }

    /**
     * This methode tests to add a multiple (3) new paragraphs (Texts) to the Text class.
     */
    @Test
    public void testAddMultiple() throws Exception {
        parameterList.add(0, new StringOrInteger(1));
        parameterList.add(1, new StringOrInteger("New text to add line one."));
        add.runCommand(parameterList);

        parameterList.add(0, new StringOrInteger(2));
        parameterList.add(1, new StringOrInteger("New text to add line two."));
        add.runCommand(parameterList);

        parameterList.add(0, new StringOrInteger(3));
        parameterList.add(1, new StringOrInteger("New text to add line three."));
        add.runCommand(parameterList);

        assertEquals("New text to add line one.", text.getParagraphAtIndex(1).getData(), "Text on line one is not correct");
        assertEquals("New text to add line two.", text.getParagraphAtIndex(2).getData(), "Text on line two is not correct");
        assertEquals("New text to add line three.", text.getParagraphAtIndex(3).getData(), "Text on line three is not correct");
    }

    /**
     * This Test the verifyBaseParameter method of the Add class with correct Parameters.
     * We expect the parameter in the ParameterList to have the isSet value true and
     * the value of the parameter to be the same as the input value.
     */
    @Test
    public void testVerifyBaseParameterCorrectParameter() {
        add.verifyBaseParameters("1");
        assertTrue(add.getParameterList().get(0).isSet(), "Parameter is not set, but should be");
        assertEquals(1, add.getParameterList().get(0).getValue().getIntValue(), "Parameter value is not correct");
    }

    /**
     * This Test the verifyBaseParameter method of the Add class with a single wrong Parameter.
     * We expect the parameter in the ParameterList to have the isSet value false.
     */
    @Test
    public void testVerifyBaseParameterSingleWrongParameter() {
        add.verifyBaseParameters("2");
        assertFalse(add.getParameterList().get(0).isSet(), "Parameter is set, but should not be");
    }

    /**
     * This Test the verifyBaseParameter method of the Add class with multiple wrong Parameters.
     * We expect an Exception to be thrown.
     */
    @Test
    public void testVerifyBaseParameterMultipleWrongParameter() {
        assertThrows(IllegalArgumentException.class, () -> add.verifyBaseParameters("2 hello world"));
        assertFalse(add.getParameterList().get(0).isSet(), "Parameter is set, but should not be");
    }

    /**
     * This Test the verifyBaseParameter method of the Add class with a single wrong Parameter, that is not an integer.
     * We expect an Exception to be thrown.
     */
    @Test
    public void testVerifyBaseParameterSingleNonIntParameter() {
        assertThrows(IllegalArgumentException.class, () -> add.verifyBaseParameters("a"));
        assertFalse(add.getParameterList().get(0).isSet(), "Parameter is set, but should not be");
    }

    /**
     * This tests the ADD command with a single illegal character.
     * We expect an IllegalArgumentException to be thrown.
     * Legal is only a-z, A-Z, 0-9, and the following special characters [&auml;&ouml;&uuml;&Auml;&Ouml;&Uuml;] and : .,:;-!? '()&quot;%@+*[]{}/\&amp;#$
     */
    @Test
    public void testADDWithIllegalCharacters() {
        parameterList.add(0, new StringOrInteger(1));
        parameterList.add(1, new StringOrInteger("£"));
        parameterList.add(2, new StringOrInteger("€"));
        parameterList.add(3, new StringOrInteger("§"));
        assertThrows(IllegalArgumentException.class, () -> add.runCommand(parameterList), "Illegal character should not be allowed");
    }
}
