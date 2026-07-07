package io;

/**
 * This interface is used to have a common interface for the OutputPrinter and the TestOutputPrinter (used for unit-tests).
 */
public interface OutputPrinterInterface {
    /**
     * Prints a text to the console.
     *
     * @param text The text to be printed.
     */
    void printText(String text);

    /**
     * Prints an error message to the console.
     *
     * @param error The error message to be printed.
     */
    void printError(String error);
}
