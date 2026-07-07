package io;

/**
 * This class is responsible for printing text to the console.
 * It can print normal Text and Error messages.
 */
public class OutputPrinter implements OutputPrinterInterface {

    /**
     * Prints a text to the console.
     *
     * @param text The text to be printed.
     */
    public void printText(String text) {
        System.out.println(text);
    }

    /**
     * Prints an error message to the console.
     *
     * @param error The error message to be printed.
     */
    public void printError(String error) {
        System.err.println(error);
    }
}
