import command.Del;
import models.StringOrInteger;
import models.Text;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains JUnit tests to test the behaviour of the Del Command Class with different texts.
 */
public class DelTest {
    private Del del;
    private Text text;
    private final List<StringOrInteger> parameterList = new LinkedList<>();

    /**
     * This methode initialise the del and text classes for all tests
     */
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        del = new Del();
        text = new Text();
        del.setText(text);

        text.addParagraph(1, "Test Paragraph at Index 1");
    }

    /**
     * This methode tests to delete a single paragraph in the Text class.
     */
    @Test
    public void testDelSingle() {
        parameterList.add(0, new StringOrInteger(1));

        assertEquals(1, text.getTextLength(), "Text length is not correct, it should be 1");
        del.runCommand(parameterList);
        assertEquals(0, text.getTextLength(), "Text length is not correct, it should be 0");
    }

    /**
     * This methode tests to delete a single paragraph at index 2 in the Text class.
     * Additionally, it tests that the last paragraph (at index 3) is moved correcty to the index 2 in the Text class.
     */
    @Test
    public void testDelSecond() {
        text.addParagraph(2, "Test Paragraph at Index 2");
        text.addParagraph(3, "Test Paragraph at Index 3");
        parameterList.add(0, new StringOrInteger(2));

        assertEquals(3, text.getTextLength(), "Text length is not correct, it should be 3");
        del.runCommand(parameterList);
        assertEquals(2, text.getTextLength());
        assertEquals("Test Paragraph at Index 1", text.getParagraphAtIndex(1).getData(), "Text is not correct, it should be 'Test Paragraph at Index 1'");
        assertEquals("Test Paragraph at Index 3", text.getParagraphAtIndex(2).getData(), "Text is not correct, it should be 'Test Paragraph at Index 3'");
    }

    /**
     * This methode tests to delete multiple paragraph at index 2 and 4 in the Text class.
     * Additionally, it tests that the paragraph (at index 3 and 5) are moved correcty to the index 2 and 3 in the Text class.
     */
    @Test
    public void testDelMultiple() {
        text.addParagraph(2, "Test Paragraph at Index 2");
        text.addParagraph(3, "Test Paragraph at Index 3");
        text.addParagraph(4, "Test Paragraph at Index 4");
        text.addParagraph(5, "Test Paragraph at Index 5");

        parameterList.add(0, new StringOrInteger(2));
        assertEquals(5, text.getTextLength(), "Text length is not correct, it should be 5");
        del.runCommand(parameterList);
        assertEquals(4, text.getTextLength(), "Text length is not correct, it should be 4");

        parameterList.add(0, new StringOrInteger(3));
        assertEquals(4, text.getTextLength(), "Text length is not correct, it should be 4");
        del.runCommand(parameterList);
        assertEquals(3, text.getTextLength(), "Text length is not correct, it should be 3");

        assertEquals("Test Paragraph at Index 1", text.getParagraphAtIndex(1).getData(), "Text is not correct, it should be 'Test Paragraph at Index 1'");
        assertEquals("Test Paragraph at Index 3", text.getParagraphAtIndex(2).getData(), "Text is not correct, it should be 'Test Paragraph at Index 3'");
        assertEquals("Test Paragraph at Index 5", text.getParagraphAtIndex(3).getData(), "Text is not correct, it should be 'Test Paragraph at Index 5'");
    }
}
