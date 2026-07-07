import command.Format;
import io.OutputPrinterInterface;
import models.StringOrInteger;
import models.Text;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;


/**
 * This class contains JUnit tests to test the behaviour of the Format Command Class with different texts.
 */
public class FormatTest {
    private Format format;
    private Text text;
    private final List<StringOrInteger> parameterList = new ArrayList<>();
    OutputPrinterInterface testPrinter = new TestOutputPrinter();

    /**
     * This methode initialise the format and text classes for all tests and sets a Default Format Width
     */
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        format = new Format();
        text = new Text();
        format.setText(text);
        format.setOutputPrinter(testPrinter);
        text.setFormatWidth(100);
    }

    /**
     * This methode tests the set of Format Raw (0) in the Text class.
     */
    @Test
    public void testFormatRaw() {
        parameterList.add(0, new StringOrInteger("RAW"));

        assertEquals(100, text.getFormatWidth(), "Format width is not correct, it should be 100");
        format.runCommand(parameterList);
        assertEquals(0, text.getFormatWidth(), "Format width is not correct, it should be 0");
    }

    /**
     * This methode tests the set of Format Fix (10) in the Text class.
     */
    @Test
    public void testFormatFix10() {
        parameterList.add(0, new StringOrInteger("FIX"));
        parameterList.add(1, new StringOrInteger(10));

        assertEquals(100, text.getFormatWidth(), "Format width is not correct, it should be 100");
        format.runCommand(parameterList);
        assertEquals(10, text.getFormatWidth(), "Format width is not correct, it should be 10");
    }

    /**
     * This methode tests the set of Format Fix (1000) in the Text class.
     */
    @Test
    public void testFormatFix1000() {
        parameterList.add(0, new StringOrInteger("FIX"));
        parameterList.add(1, new StringOrInteger(1000));

        assertEquals(100, text.getFormatWidth(), "Format width is not correct, it should be 100");
        format.runCommand(parameterList);
        assertEquals(1000, text.getFormatWidth(), "Format width is not correct, it should be 1000");
    }
}
