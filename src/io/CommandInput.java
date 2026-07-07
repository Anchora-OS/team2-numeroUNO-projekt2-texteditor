package io;

import command.Commands;
import models.ActionTupel;

import java.util.Scanner;

/**
 * This Class manages the input from the user to select a Command.
 * It checks if the input matches one of the commands and returns an ActionTupel with the command and the input.
 * If the input does not match any command it returns an ActionTupel with the command INVALID.
 */
public class CommandInput {
    private final Scanner scanner;

    /**
     * Constructor for the CommandInput class.
     * Initializes the scanner.
     */
    public CommandInput() {
        scanner = new Scanner(System.in);
    }

    /**
     * This method get the Input from the user and checks if it matches one of the commands.
     * If it matches no command it returns an ActionTupel with the command INVALID.
     *
     * @return ActionTupel with the command and the input (without the command word itself)
     */
    public ActionTupel getCommand() {
        System.out.print("> ");
        String input = scanner.nextLine();
        for (Commands c : Commands.values()) {
            if (!c.name().equals("INVALID") && input.matches(c.getRegex())) {
                return new ActionTupel(purgeCommandWordFromInput(input, c), c);
            }
        }
        return new ActionTupel(purgeCommandWordFromInput(input, Commands.INVALID), Commands.INVALID);
    }

    /**
     * This method purges the command word from the input string.
     *
     * @param input   the input string from the User
     * @param command the used command word
     * @return the input string without the command word and trimmed
     */
    public String purgeCommandWordFromInput(String input, Commands command) {
        String commandWord = "(?i)" + command.toString();
        return input.replaceAll(commandWord, "").trim();
    }
}
