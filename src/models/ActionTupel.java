package models;

import command.Commands;

/**
 * This class is a tupel that contains a string and a command.
 * It is used to return the command and the input from the CommandInput class.
 */
public class ActionTupel {
    private final String value;
    private Commands command;

    /**
     * Constructor for the ActionTupel class.
     *
     * @param value   the input string
     * @param command the command
     */
    public ActionTupel(String value, Commands command) {
        this.value = value;
        this.command = command;
    }

    /**
     * Getter for the input string.
     *
     * @return the input string (never {@code null})
     */
    public String getValue() {
        return value;
    }

    /**
     * Getter for the command.
     *
     * @return the command Enum (never {@code null})
     */
    public Commands getCommand() {
        return command;
    }

    /**
     * Setter for the input command.
     *
     * @param command the selected command
     */
    public void setCommand(Commands command) {
        this.command = command;
    }
}
