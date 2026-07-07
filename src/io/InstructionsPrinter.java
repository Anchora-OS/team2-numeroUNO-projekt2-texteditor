package io;

import command.Commands;

public class InstructionsPrinter {

    /**
     * This method prints the welcome message to the console.
     * For this it calls the welcomeMsgFactory method to create the message dynamically.
     */
    public void printWelcome() {
        System.out.printf(welcomeMsgFactory());
    }

    /**
     * This method creates the welcome message from the Instructions saved in each command Enum.
     * So if a new command is added, it will automatically be added to the welcome message.
     *
     * @return the welcome message (never {@code null})
     */
    public String welcomeMsgFactory() {
        StringBuilder instruction = new StringBuilder("Welcome to this Texteditor %nYou can save, print and modify your textes here.%n" +
                "Use one of the following command to navigate:%n%n");
        for (Commands c : Commands.values()) {
            instruction.append(c.getInstruction());
        }
        return instruction.toString();
    }
}
