package models;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * This class represents a text. A text consists of a List of paragraphs.
 * It provides methods to add, remove, get and set paragraphs, as well as a method to get the amount of paragraphs.
 */
public class Text {
    private final List<Paragraph> paragraphs;
    private int formatWidth;
    private static final Logger LOGGER = Logger.getLogger(Text.class.getName());

    /**
     * Constructor for Text
     * Initializes the List of paragraphs and sets the format width to 0
     */
    public Text() {
        this.paragraphs = new LinkedList<>();
        this.formatWidth = 0;
    }

    /**
     * Gives the number of paragraphs in text
     *
     * @return integer: number of paragraphs in text (never {@code null})
     */
    public int getTextLength() {
        return paragraphs.size();
    }

    /**
     * Add paragraph to text at specific index
     *
     * @param index         - integer representing index of where to add the paragraph
     * @param paragraphText - paragraph to be added
     */
    public void addParagraph(int index, String paragraphText) {
        validateText(paragraphText);
        paragraphs.add(index - 1, new Paragraph(paragraphText));
    }

    /**
     * Removes paragraph at specific index
     *
     * @param index - integer representing index of where to remove the paragraph
     */
    public void removeParagraph(int index) {
        paragraphs.remove(index - 1);
    }

    /**
     * Returns the entire List of paragraphs
     *
     * @return List of paragraphs (never {@code null})
     */
    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    /**
     * Returns the paragraph at the given index - 1
     *
     * @param index - integer representing index of paragraph to be returned
     * @return Paragraph from the List of paragraphs at the given index (never {@code null})
     */
    public Paragraph getParagraphAtIndex(int index) {
        return paragraphs.get(index - 1);
    }

    /**
     * Sets the paragraph at the given index to the new
     *
     * @param index         - integer representing index of paragraph to be replaced
     * @param paragraphText - new String to be set in the paragraph
     */
    public void setParagraphAtIndex(int index, String paragraphText) {
        validateText(paragraphText);
        paragraphs.set(index - 1, new Paragraph(paragraphText));
    }

    /**
     * Returns the current format width of the text.
     * The format width of the text. 0 represents format fix.
     *
     * @return integer representing the format width of the text (never {@code null})
     */
    public int getFormatWidth() {
        return formatWidth;
    }

    /**
     * Sets the current format width of the text.
     * The format width of the text. 0 represents format fix.
     *
     * @param formatWidth - integer representing the new format width of the text
     */
    public void setFormatWidth(int formatWidth) {
        this.formatWidth = formatWidth;
    }

    /**
     * Validates the given text with the following characters:
     * .,:;-!? '()&quot;%@+*[]{}/\&amp;#$&auml;&ouml;&uuml;&Auml;&Ouml;&Uuml;0-9a-zA-Z
     *
     * @param text - String to be validated
     * @throws IllegalArgumentException if the text contains invalid characters
     */
    private void validateText(String text) {
        if (!text.matches("^[.,:;\\-!? '()\"%@+*\\[\\]{}/\\\\&#$äöüÄÖÜ0-9a-zA-Z]*$")) {
            LOGGER.severe("An IllegalArgumentException was thrown");
            throw new IllegalArgumentException("Zu speichernden Text in Absatz enthält ungültige Zeichen");
        }
    }

}
