package models;

/**
 * This class represents a parameter of a command.
 * It contains the output text, the regex validator, if it is a base parameter, if it is set and the value.
 */
public class CommandParameter {
    private String outputText;
    private String regexValidator;
    private final boolean isBaseParameter;
    private boolean isSet;
    private StringOrInteger value;

    /**
     * Constructor for the CommandParameter class.
     *
     * @param outputText      the output text which is printed to the user
     * @param regexValidator  the regex validator to make sure the input matches the parameter
     * @param isBaseParameter if it is a base parameter (base parameters are the parameters that get provided with the command itself)
     * @param isSet           if it is set (can only be true for base parameters)
     * @param value           the value of the parameter (if it is already set)
     */
    public CommandParameter(String outputText, String regexValidator, boolean isBaseParameter, boolean isSet, StringOrInteger value) {
        this.outputText = outputText;
        this.regexValidator = regexValidator;
        this.isBaseParameter = isBaseParameter;
        this.isSet = isSet;
        this.value = value;
    }

    /**
     * This method gets the output text of the CommandParameter.
     *
     * @return the output text (never {@code null})
     */
    public String getOutputText() {
        return outputText;
    }

    /**
     * This method sets the output text of the CommandParameter.
     *
     * @param outputText the output text
     */
    public void setOutputText(String outputText) {
        this.outputText = outputText;
    }

    /**
     * This method gets the regex validator of the CommandParameter.
     *
     * @return the regex validator (never {@code null})
     */
    public String getRegexValidator() {
        return regexValidator;
    }

    /**
     * This method sets the regex validator of the CommandParameter.
     *
     * @param regexValidator the regex validator
     */
    public void setRegexValidator(String regexValidator) {
        this.regexValidator = regexValidator;
    }

    /**
     * This method gets if the CommandParameter is a base parameter.
     *
     * @return if it is a base parameter (never {@code null})
     */
    public boolean isBaseParameter() {
        return isBaseParameter;
    }

    /**
     * This method gets if the CommandParameter is already set.
     *
     * @return if it is already set (never {@code null})
     */
    public boolean isSet() {
        return isSet;
    }

    /**
     * This method sets if the CommandParameter is already set.
     *
     * @param set if it is already set
     */
    public void setIsSet(boolean set) {
        isSet = set;
    }

    /**
     * This method gets the value of the CommandParameter.
     *
     * @return the value (never {@code null})
     */
    public StringOrInteger getValue() {
        return value;
    }

    /**
     * This method sets the value of the CommandParameter.
     *
     * @param value the value
     */
    public void setValue(StringOrInteger value) {
        this.value = value;
    }
}
