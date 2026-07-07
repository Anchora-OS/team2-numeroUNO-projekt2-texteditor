package core;

import io.CommandInput;
import io.InstructionsPrinter;
import models.ActionTupel;
import models.Text;

import java.util.logging.Logger;

/**
 * The TextEditor class is responsible for running the application.
 * It calls the commandInput for a command and then calls the command controller.
 */
public class TextEditor {
    private final CommandInput commandInput;
    private final InstructionsPrinter instructionsPrinter;
    private final CommandController commandController;
    private static final Logger LOGGER = Logger.getLogger(TextEditor.class.getName());

    /**
     * Constructor for the TextEditor class.
     * Initializes the commandInput, the instructionsPrinter and the commandController.
     */
    public TextEditor() {
        this.commandInput = new CommandInput();
        this.instructionsPrinter = new InstructionsPrinter();
        this.commandController = new CommandController(new Text());
    }

    /**
     * This method is responsible for running the application.
     * As long as the application is running, it will call the commandInput for a command and then call the command controller.
     */
    public void run() {
        LOGGER.info("Application started");

        boolean isRunning = true;

        instructionsPrinter.printWelcome();
        while (isRunning) {
            ActionTupel actionTupel = commandInput.getCommand();
            isRunning = commandController.callCommand(actionTupel);
        }
        LOGGER.info("Application terminated");
    }
}
