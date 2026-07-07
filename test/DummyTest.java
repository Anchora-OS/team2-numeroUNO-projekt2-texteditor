import command.Dummy;
import models.StringOrInteger;
import models.Text;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains JUnit tests to test the behaviour of the Dummy Command Class with different texts.
 */
public class DummyTest {

    Dummy dummy;
    Text text;

    /**
     * This methode initialise the dummy class and text class for all tests
     */
    @BeforeEach
    void setUp() {
        dummy = new Dummy();
        text = new Text();
    }

    /**
     * This methode tests that the dummy command can be executed with an empty text and adds the Paragraph.
     */
    @Test
    public void testDummyEmptyText() {
        dummy.setText(text);
        List<StringOrInteger> dummyListe = new LinkedList<>();
        dummyListe.add(new StringOrInteger(1));
        dummy.runCommand(dummyListe);
        assertEquals("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor " +
                "invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo " +
                "dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.", text.getParagraphAtIndex(1).getData(), "Text is not the same as the dummy text");
    }

    /**
     * This methode tests that the dummy command can be executed with a text and adds the Paragraph at Index 2.
     */
    @Test
    public void testDummyTextEnd() {
        text.addParagraph(1, "Test");
        dummy.setText(text);
        List<StringOrInteger> dummyListe = new LinkedList<>();
        dummyListe.add(new StringOrInteger(text.getTextLength() + 1));
        dummy.runCommand(dummyListe);
        assertEquals("Test", text.getParagraphAtIndex(1).getData(), "Text is not 'Test' maybe it is the dummy text");
        assertEquals("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor " +
                "invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo " +
                "dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.", text.getParagraphAtIndex(2).getData(), "Text is not the same as the dummy text");
    }

    /**
     * This methode tests that the dummy command can be executed with a text with two Paragraphs and adds the Paragraph.
     */
    @Test
    public void testDummyTextMiddle() {
        text.addParagraph(1, "Test");
        text.addParagraph(2, "Test");
        dummy.setText(text);
        List<StringOrInteger> dummyListe = new LinkedList<>();
        dummyListe.add(new StringOrInteger(text.getTextLength()));
        dummy.runCommand(dummyListe);
        assertEquals("Test", text.getParagraphAtIndex(1).getData(), "Text is not 'Test' maybe it is the dummy text");
        assertEquals("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor " +
                "invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo " +
                "dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.", text.getParagraphAtIndex(2).getData(), "Text is not the same as the dummy text");
        assertEquals("Test", text.getParagraphAtIndex(3).getData(), "Text is not 'Test' maybe it is the dummy text");
    }

    /**
     * This methode tests that the dummy command can be executed with a text with two Paragraphs and adds the Paragraph.
     */
    @Test
    public void testDummyTextBeginning() {
        text.addParagraph(1, "Test");
        dummy.setText(text);
        List<StringOrInteger> dummyListe = new LinkedList<>();
        dummyListe.add(new StringOrInteger(text.getTextLength()));
        dummy.runCommand(dummyListe);
        assertEquals("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor " +
                "invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo " +
                "dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.", text.getParagraphAtIndex(1).getData(), "Text is not the same as the dummy text");
        assertEquals("Test", text.getParagraphAtIndex(2).getData(), "Text is not 'Test' maybe it is the dummy text");
    }

}
