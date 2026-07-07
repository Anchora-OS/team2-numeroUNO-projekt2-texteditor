package command;

/**
 * This enum contains all commands and their regex and instruction. It also contains their specific command class.
 * To add a new command, add it here and create a new class in the command package that extends AbstractCommand or if needed CommandWithParameter, if it has index as base parameter.
 */
public enum Commands {
    ADD("(?i)\\bAdd(?:\\s*[1-9]\\d*)?\\b\\s*", new Add(), "ADD [n] --> to add a text at index n%n"),
    DEL("(?i)\\bDel(?:\\s*[1-9]\\d*)?\\b\\s*", new Del(), "DEL [n]  --> to delete the text at index n%n"),
    DUMMY("(?i)\\bDummy(?:\\s*[1-9]\\d*)?\\b\\s*", new Dummy(), "DUMMY [n]  --> to add a dummy text at index n%n"),
    EXIT("(?i)\\bExit\\b\\s*", new Exit(), "EXIT  --> to exit the programm%n"),
    FORMAT("(?i)\\s*\\bFormat\\b\\s*(?:Raw|Fix(?:\\s*[1-9]\\d*)?)\\s*", new Format(), "FORMAT RAW  --> to set the output format to default format%nFORMAT FIX <n>  --> to set the format to n symbols per line%n"),
    INDEX("(?i)\\bIndex\\b\\s*", new Index(), "INDEX  --> prints the paragraphs that contains the same word at least 3 times%n"),
    REPLACE("(?i)\\bReplace(?:\\s*[1-9]\\d*)?\\b\\s*", new Replace(), "REPLACE [n]  --> replace a given word or word row with another in the Text with index n%n"),
    PRINT("(?i)\\bPrint\\b\\s*", new Print(), "PRINT  --> prints all texts%n"),
    INVALID("", new Invalid(), "");

    private final String regex;
    private final AbstractCommand commandClass;
    private final String instruction;

    /**
     * Constructor for Commands
     *
     * @param regex        - regex of the command
     * @param commandClass - the command class
     * @param instruction  - the instruction of the command
     */
    Commands(String regex, AbstractCommand commandClass, String instruction) {
        this.regex = regex;
        this.commandClass = commandClass;
        this.instruction = instruction;
    }

    /**
     * Getter for the command class object
     *
     * @return the command class (never {@code null})
     */
    public AbstractCommand getCommandClass() {
        return commandClass;
    }

    /**
     * Getter for the regex Validator of the Command
     *
     * @return the regex (never {@code null})
     */
    public String getRegex() {
        return regex;
    }

    /**
     * Getter for the instruction of the Command.
     *
     * @return the instruction (never {@code null})
     */
    public String getInstruction() {
        return instruction;
    }
}
