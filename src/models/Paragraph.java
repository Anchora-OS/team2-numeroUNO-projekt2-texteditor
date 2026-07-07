package models;

/**
 * This class represents a single paragraph. That can store a string.
 */
public class Paragraph {
    private final String data;

    /**
     * Constructor for the Paragraph class.
     *
     * @param data the string that should be stored in the paragraph
     */
    public Paragraph(String data) {
        this.data = data;
    }

    /**
     * Getter for the String stored in the paragraph.
     *
     * @return the data (never {@code null})
     */
    public String getData() {
        return data;
    }

}
