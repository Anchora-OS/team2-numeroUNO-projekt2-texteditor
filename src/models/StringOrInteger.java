package models;

/**
 * This class is used to store a String or an Integer.
 * It dynamically checks if the value is a String or an Integer and stores it accordingly.
 * It provides getter methods for both types. And also a method to check if the value is a String or an Integer.
 */
public class StringOrInteger {
    private String stringValue;
    private Integer intValue;
    private final boolean isString;

    /**
     * Constructor for the StringOrInteger class if the value is a String.
     *
     * @param stringValue the String value
     */
    public StringOrInteger(String stringValue) {
        this.stringValue = stringValue;
        this.isString = true;
    }

    /**
     * Constructor for the StringOrInteger class if the value is an Integer.
     *
     * @param intValue the Integer value
     */
    public StringOrInteger(Integer intValue) {
        this.intValue = intValue;
        this.isString = false;
    }

    /**
     * This constructor is used to define if a parameter should a String or an Integer without having to set a value yet.
     *
     * @param isString true if the parameter should be a String, false if it should be an Integer
     */
    public StringOrInteger(boolean isString) {
        this.isString = isString;
    }

    /**
     * This method checks if the value is a String or an Integer.
     *
     * @return true if the value is a String, false if it is an Integer (never {@code null})
     */
    public boolean isString() {
        return isString;
    }

    /**
     * This method gets the String value.
     *
     * @return the String value (never {@code null})
     */
    public String getStringValue() {
        return stringValue;
    }

    /**
     * This method gets the Integer value.
     *
     * @return the Integer value (never {@code null})
     */
    public Integer getIntValue() {
        return intValue;
    }
}
