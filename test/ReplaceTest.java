import models.StringOrInteger;
import models.Text;
import org.junit.jupiter.api.Test;
import command.Replace;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains JUnit tests to test the behaviour of the Replace Command Class with different texts.
 */
class ReplaceTest {
    private Replace replace;
    private Text text;
    private final List<StringOrInteger> parameterList = new ArrayList<>();
    ;

    /**
     * This methode initialise the replace and text classes for all tests
     */
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        replace = new Replace();
        text = new Text();
        replace.setText(text);
    }

    /**
     * This methode tests to replace a single word in one given paragraph with two words.
     */
    @Test
    public void testReplaceSingle() {
        text.addParagraph(1, "Test Paragraph for replace");
        parameterList.add(0, new StringOrInteger(1));
        parameterList.add(1, new StringOrInteger("Paragraph"));
        parameterList.add(2, new StringOrInteger("New Text"));

        replace.runCommand(parameterList);
        assertEquals("Test New Text for replace", text.getParagraphAtIndex(1).getData(), "Text is not correct when replacing 'Paragraph' with New 'Text'");
    }

    /**
     * This methode tests to replace two similar words in one given paragraph with two words.
     */
    @Test
    public void testReplaceMulti() {
        text.addParagraph(1, "Test Paragraph for replace with two Paragraph");
        parameterList.add(0, new StringOrInteger(1));
        parameterList.add(1, new StringOrInteger("Paragraph"));
        parameterList.add(2, new StringOrInteger("New Text"));

        replace.runCommand(parameterList);
        assertEquals("Test New Text for replace with two New Text", text.getParagraphAtIndex(1).getData(), "Text is not correct when replacing 'Paragraph' with New 'Text'");
    }

    /**
     * This methode tests to replace a group of words so its look like a word would have been added to the text.
     */
    @Test
    public void testReplaceAdd() {
        text.addParagraph(1, "Test Paragraph for add a word");
        parameterList.add(0, new StringOrInteger(1));
        parameterList.add(1, new StringOrInteger("Test Paragraph"));
        parameterList.add(2, new StringOrInteger("Test New Text Paragraph"));

        replace.runCommand(parameterList);
        assertEquals("Test New Text Paragraph for add a word", text.getParagraphAtIndex(1).getData(), "Text is not correct when replacing 'Test Paragraph' with 'Test New Text Paragraph'");
    }

    /**
     * This methode tests to replace a single word with an empty string wich result in deleting the single word .
     */
    @Test
    public void testReplaceDelete() {
        text.addParagraph(1, "Test Paragraph for delete a word");
        parameterList.add(0, new StringOrInteger(1));
        parameterList.add(1, new StringOrInteger(" Paragraph"));
        parameterList.add(2, new StringOrInteger(""));

        replace.runCommand(parameterList);
        assertEquals("Test for delete a word", text.getParagraphAtIndex(1).getData(), "Text is not correct when replacing ' Paragraph' with ''");
    }

    /**
     * This methode tests to replace multiple single symbols (here all " ") with multiple single symbole (here "-").
     */
    @Test
    public void testReplaceBlankSpace() {
        text.addParagraph(1, "Test Paragraph for Blank Space");
        parameterList.add(0, new StringOrInteger(1));
        parameterList.add(1, new StringOrInteger(" "));
        parameterList.add(2, new StringOrInteger("-"));

        replace.runCommand(parameterList);
        assertEquals("Test-Paragraph-for-Blank-Space", text.getParagraphAtIndex(1).getData(), "Text is not correct when replacing ' ' with '-'");
    }

    /**
     * This methode tests the replace command multiple times on different paragraphs.
     */
    @Test
    public void testReplaceMultipleTimes() {
        text.addParagraph(1, "First Test Paragraph for replace");
        parameterList.add(0, new StringOrInteger(1));
        parameterList.add(1, new StringOrInteger("Paragraph"));
        parameterList.add(2, new StringOrInteger("First Text"));

        replace.runCommand(parameterList);
        assertEquals("First Test First Text for replace", text.getParagraphAtIndex(1).getData(), "Text is not correct when replacing 'Paragraph' with 'First Text'");

        text.addParagraph(2, "Second Test Paragraph for replace");
        parameterList.add(0, new StringOrInteger(2));
        parameterList.add(1, new StringOrInteger("Paragraph"));
        parameterList.add(2, new StringOrInteger("Second Text"));

        replace.runCommand(parameterList);
        assertEquals("Second Test Second Text for replace", text.getParagraphAtIndex(2).getData(), "Text is not correct when replacing 'Paragraph' with 'Second Text'");
    }
}
