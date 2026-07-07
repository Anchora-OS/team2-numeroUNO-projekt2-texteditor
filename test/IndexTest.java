import command.Index;
import io.OutputPrinterInterface;
import models.StringOrInteger;
import models.Text;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains JUnit tests to test the behaviour of the Index Command Class with different words.
 */
public class IndexTest {
    private Index index;
    private Text text;
    OutputPrinterInterface testPrinter = new TestOutputPrinter();
    private final List<StringOrInteger> parameterList = new ArrayList<>();


    /**
     * This methode initialise the index and text classes for all tests and ads some dummy Paragraphs to text class.
     */
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        index = new Index();
        index.setOutputPrinter(testPrinter);
        text = new Text();
        index.setText(text);

    }

    /**
     * This methode tests the index runcommand methode for the given paragraphs.
     * Expectet Output:
     * For: 1, 2, 3, 5
     * Sample: 1, 2, 3, 4, 5, 6
     * Testing: 2, 3, 5, 6
     * (Auf gross und klein Schreibung achten)
     */
    @Test
    public void testindex() throws Exception {
        text.addParagraph(1, "Sample Time text For testing");
        text.addParagraph(2, "Sample Lol text For Testing");
        text.addParagraph(3, "Sample Time text For Testing and Testing");
        text.addParagraph(4, "Sample Word text for testing");
        text.addParagraph(5, "Sample Time text For Testing");
        text.addParagraph(6, "Sample Word Text for Testing");
        index.runCommand(parameterList);
        assertEquals("""
                For: 1, 2, 3, 5
                Sample: 1, 2, 3, 4, 5, 6
                Testing: 2, 3, 5, 6
                """, ((TestOutputPrinter) testPrinter).getOutput(), "Index output is not correct");
    }

    @Test
    public void testIndex2() throws Exception {
        text.addParagraph(1, "Those Words are not in the Index");
        text.addParagraph(2, "Or are those Words in the Index?");
        text.addParagraph(3, "Those Words are not in the Index again");
        text.addParagraph(4, "Or are those Words in the Index again?");
        text.addParagraph(5, "Those Those again");

        index.runCommand(parameterList);
        assertEquals("""
                Those: 1, 3, 5
                Words: 1, 2, 3, 4
                """, ((TestOutputPrinter) testPrinter).getOutput(), "Index output is not correct");
    }

    @Test
    public void tesNotLongEnough() throws Exception {
        text.addParagraph(1, "This is the only paragraph");
        index.runCommand(parameterList);
        assertEquals("No words occur more than 3 times in the text.", ((TestOutputPrinter) testPrinter).getOutput(), "No word should appear here");
    }

    @Test
    public void testEmptyText() throws Exception {
        index.runCommand(parameterList);
        assertEquals("No words occur more than 3 times in the text.", ((TestOutputPrinter) testPrinter).getOutput(), "No word should appear here");
    }

    @Test
    public void testOnlyOneWord() throws Exception {
        text.addParagraph(1, "Word");
        index.runCommand(parameterList);
        assertEquals("No words occur more than 3 times in the text.", ((TestOutputPrinter) testPrinter).getOutput(), "No word should appear here");
    }

    @Test
    public void testOnlyOneWordThreeTimes() throws Exception {
        text.addParagraph(1, "Word Word Word");
        index.runCommand(parameterList);
        assertEquals("No words occur more than 3 times in the text.", ((TestOutputPrinter) testPrinter).getOutput(), "No word should appear here");
    }

    @Test
    public void testOnlyOneWordFiveTimes() throws Exception {
        text.addParagraph(1, "Word");
        text.addParagraph(2, "Word");
        text.addParagraph(3, "Word");
        text.addParagraph(4, "Word");
        index.runCommand(parameterList);
        assertEquals("Word: 1, 2, 3, 4\n", ((TestOutputPrinter) testPrinter).getOutput(), "Word should appear here 4 times");
    }






}
