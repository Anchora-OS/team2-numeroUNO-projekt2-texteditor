package command;

import models.StringOrInteger;
import models.Paragraph;

import java.util.List;
import java.util.logging.Logger;

/**
 * Print command
 * Prints the text
 * If the format mode is FIX, the text is formatted to the given length
 * If the format mode is RAW, the text is not formatted
 */
public class Print extends AbstractCommand {
    private static final Logger LOGGER = Logger.getLogger(Print.class.getName());

    /**
     * Constructor for Print
     * Initializes the outputPrinter
     */
    public Print() {
        super();
    }

    /**
     * This method prints the text with the given format mode and format length.
     *
     * @param parameterList - in this case a single parameter
     * @return true, if command was run successfully, else false
     */
    @Override
    public boolean runCommand(List<StringOrInteger> parameterList) {
        LOGGER.info("Print command called");
        List<Paragraph> paragraphs = text.getParagraphs();
        int formatWidth = text.getFormatWidth();

        if (formatWidth == 0) { // RAW
            if (text.getTextLength() == 0)
                outputPrinter.printText("Text is empty");

            for (int i = 1; i <= text.getTextLength(); i++) {
                outputPrinter.printText("<" + i + ">: " + paragraphs.get(i - 1).getData());
            }
        } else { // FIX
            for (Paragraph p : text.getParagraphs()) {
                outputPrinter.printText(
                        formatParagraph(p.getData(), text.getFormatWidth())
                );
            }
        }
        return true;
    }

    /**
     * This method takes in a string and a max line width and formats it into a string with a max width per line.
     * To wrap to a new line the method uses "\n".
     *
     * @param input    - the string that should be formatted
     * @param maxWidth - the max width in chars of a line
     * @return formatted string
     */
    private String formatParagraph(String input, int maxWidth) {
        StringBuilder result = new StringBuilder();
        int currentLineLength = 0;

        String[] words = input.split(" ");

        for (String word : words) {
            if (word.length() > maxWidth) {
                int startIndex = 0;

                while (startIndex < word.length()) {
                    int endIndex = Math.min(startIndex + maxWidth, word.length());
                    result.append("\n").append(word, startIndex, endIndex);
                    startIndex = endIndex;
                }

                currentLineLength = 0;

                result.append(" \n");
            } else {
                if (currentLineLength + word.length() > maxWidth) {
                    result.append("\n");
                    currentLineLength = 0;
                }

                result.append(word).append(" ");
                currentLineLength += word.length() + 1;
            }
        }

        return result.toString().replaceAll("\\n\\n", "\n").trim() + "\n";
    }
}
