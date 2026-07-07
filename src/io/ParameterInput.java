package io;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import models.CommandParameter;
import models.StringOrInteger;

/**
 * This class is responsible for getting the parameters from the user for the Commands.
 * It receives a list of CommandParameters and returns a list of StringOrIntegers.
 */
public class ParameterInput {
    private final Scanner scanner;
    private static final Logger LOGGER = Logger.getLogger(ParameterInput.class.getName());
    private final OutputPrinter outputPrinter;

    /**
     * Constructor for the ParameterInput class.
     * Initializes the scanner and the outputPrinter.
     */
    public ParameterInput() {
        this.scanner = new Scanner(System.in);
        this.outputPrinter = new OutputPrinter();
    }

    /**
     * This method gets the parameters from the user for the Commands.
     * It receives a list of CommandParameters and returns a list of StringOrIntegers.
     * If there are no parameters to be set, it returns an empty list or if they are already set (for BaseParameters), it returns the list of the set parameters.
     *
     * @param parametersList the list of CommandParameters
     * @return the list of StringOrIntegers (never {@code null})
     */
    public List<StringOrInteger> getParameters(List<CommandParameter> parametersList) {
        List<StringOrInteger> returnList = new ArrayList<>();
        boolean parameterNotFound;
        for (CommandParameter c : parametersList) {
            if (!c.isSet()) {
                parameterNotFound = true;
                while (parameterNotFound) {
                    if (c.isBaseParameter()) {
                        outputPrinter.printError(c.getOutputText());
                        LOGGER.warning(c.getOutputText());
                    } else {
                        outputPrinter.printText(c.getOutputText());
                    }

                    String input = scanner.nextLine();
                    if (input.matches(c.getRegexValidator()) && checkForIllegalCharacters(input)) {
                        if (c.getValue().isString()) {
                            returnList.add(new StringOrInteger(input));
                        } else {
                            returnList.add(new StringOrInteger(Integer.parseInt(input)));
                        }
                        parameterNotFound = false;
                    } else {
                        outputPrinter.printError(input +" is an invalid input!");
                        LOGGER.warning("Invalid input!");
                    }
                }
            } else {
                returnList.add(c.getValue());
            }
        }
        return returnList;
    }

    /**
     * This method checks if the input contains illegal characters.
     * We only allow the following characters: .,:;-!? '()&quot;%@+*[]{}/\&amp;#$&auml;&ouml;&uuml;&Auml;&Ouml;&Uuml;0-9a-zA-Z
     *
     * @param input defines the input string
     * @return true if the input contains no illegal characters, false if the input contains illegal characters (never {@code null})
     */
    public boolean checkForIllegalCharacters(String input) {
        return input.matches("^[.,:;\\-!? '()\"%@+*\\[\\]{}/\\\\&#$äöüÄÖÜ0-9a-zA-Z]*$");
    }
}
