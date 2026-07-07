import command.Print;
import io.OutputPrinterInterface;
import models.StringOrInteger;
import models.Text;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains JUnit tests to test the behaviour of the Print Command Class with different texts.
 */
public class PrintTest {
    Text text;
    Print print;
    OutputPrinterInterface testPrinter = new TestOutputPrinter();

    /**
     * This methode initialise the print, text and dummy classes for all tests and add some default paragraphs to the text class
     * Additionally it sets the Format to Format fix with length 1
     */
    @BeforeEach
    void setUp() {
        text = new Text();
        print = new Print();
        print.setOutputPrinter(testPrinter);
        text.addParagraph(1, "Virtute praecedunt, quod fere cotidianis proeliis cum Germanis contendunt, septentr ionesimmensoslongusw ordos ionesimmensoslongusws.");
        text.addParagraph(2, "12345678901234567890");
        text.setFormatWidth(1);
        print.setText(text);
    }

    /**
     * This methode tests the correct run of the runCommand methode. Instead of printing it at the console a boolean is returned.
     */
    @Test
    public void testPrint() {
        print.runCommand(new LinkedList<>());
    }

    /**
     * This methode tests to print all paragraphs in Format RAW. Instead of printing it at the console its saved in the TestOutputPrinter class.
     */
    @Test
    public void testPrintFormatRAW() {
        text.setFormatWidth(0);
        print.runCommand(new LinkedList<>());
        assertEquals("<1>: Virtute praecedunt, quod fere cotidianis proeliis cum Germanis contendunt, septentr ionesimmensoslongusw ordos ionesimmensoslongusws.\n" +
                "<2>: 12345678901234567890", ((TestOutputPrinter) testPrinter).getOutput(), "Printed text is not correct");
    }

    /**
     * This methode tests to print all paragraphs in Format Fix 10. nstead of printing it at the console its saved in the TestOutputPrinter class.
     */
    @Test
    public void testPrintFormatFix10() {
        text.setFormatWidth(10);
        print.runCommand(new LinkedList<>());
        assertEquals("""
                Virtute\s
                praecedunt
                ,\s
                quod fere\s
                cotidianis\s
                proeliis\s
                cum\s
                Germanis\s
                contendunt
                ,\s
                septentr\s
                ionesimmen
                soslongusw\s
                ordos\s
                ionesimmen
                soslongusw
                s.

                1234567890
                1234567890
                """, ((TestOutputPrinter) testPrinter).getOutput(), "Printed text is not correct with format fix 10");
    }

    /**
     * This methode tests to print all paragraphs in Format Fix 20. nstead of printing it at the console its saved in the TestOutputPrinter class.
     */
    @Test
    public void testPrintFormatFix20() {
        text.setFormatWidth(20);
        print.runCommand(new LinkedList<>());
        assertEquals("""
                Virtute praecedunt,\s
                quod fere cotidianis\s
                proeliis cum\s
                Germanis contendunt,\s
                septentr\s
                ionesimmensoslongusw\s
                ordos\s
                ionesimmensoslongusw
                s.

                12345678901234567890
                """, ((TestOutputPrinter) testPrinter).getOutput(), "Printed text is not correct with format fix 20");
    }

    /**
     * This methode tests to print all paragraphs in Format Fix 30. nstead of printing it at the console its saved in the TestOutputPrinter class.
     */
    @Test
    public void testPrintFormatFix30() {
        text.setFormatWidth(30);
        print.runCommand(new LinkedList<>());
        assertEquals("""
                Virtute praecedunt, quod fere\s
                cotidianis proeliis cum\s
                Germanis contendunt, septentr\s
                ionesimmensoslongusw ordos\s
                ionesimmensoslongusws.

                12345678901234567890
                """, ((TestOutputPrinter) testPrinter).getOutput(), "Printed text is not correct with format fix 30");
    }

    /**
     * This methode tests to print all paragraphs in Format Fix 5. Instead of printing it at the console its saved in the TestOutputPrinter class.
     */
    @Test
    public void testPrintFormatFix5() {
        text.setFormatWidth(5);
        print.runCommand(new LinkedList<StringOrInteger>());
        assertEquals("""
                Virtu
                te\s
                praec
                edunt
                ,\s
                quod\s
                fere\s
                cotid
                ianis\s
                proel
                iis\s
                cum\s
                Germa
                nis\s
                conte
                ndunt
                ,\s
                septe
                ntr\s
                iones
                immen
                soslo
                ngusw\s
                ordos\s
                iones
                immen
                soslo
                ngusw
                s.

                12345
                67890
                12345
                67890
                """, ((TestOutputPrinter) testPrinter).getOutput(), "Printed text is not correct with format fix 5");
    }

    /**
     * This methode tests to print all paragraphs in Format Fix 1. nstead of printing it at the console its saved in the TestOutputPrinter class.
     */
    @Test
    public void testPrintFormatFix1() {
        text.setFormatWidth(1);
        print.runCommand(new LinkedList<>());
        assertEquals("""
                V
                i
                r
                t
                u
                t
                e\s
                p
                r
                a
                e
                c
                e
                d
                u
                n
                t
                ,\s
                q
                u
                o
                d\s
                f
                e
                r
                e\s
                c
                o
                t
                i
                d
                i
                a
                n
                i
                s\s
                p
                r
                o
                e
                l
                i
                i
                s\s
                c
                u
                m\s
                G
                e
                r
                m
                a
                n
                i
                s\s
                c
                o
                n
                t
                e
                n
                d
                u
                n
                t
                ,\s
                s
                e
                p
                t
                e
                n
                t
                r\s
                i
                o
                n
                e
                s
                i
                m
                m
                e
                n
                s
                o
                s
                l
                o
                n
                g
                u
                s
                w\s
                o
                r
                d
                o
                s\s
                i
                o
                n
                e
                s
                i
                m
                m
                e
                n
                s
                o
                s
                l
                o
                n
                g
                u
                s
                w
                s
                .
                
                1
                2
                3
                4
                5
                6
                7
                8
                9
                0
                1
                2
                3
                4
                5
                6
                7
                8
                9
                0
                """, ((TestOutputPrinter) testPrinter).getOutput(), "Printed text is not correct with format fix 1");
    }
}
