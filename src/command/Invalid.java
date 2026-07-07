package command;

import models.StringOrInteger;

import java.util.List;
import java.util.logging.Logger;

/**
 * Invalid command
 * Intercepts invalid command inputs and prints an error message
 */
public class Invalid extends AbstractCommand {
    private static final Logger LOGGER = Logger.getLogger(Invalid.class.getName());

    /**
     * Constructor for Invalid
     * Initializes the outputPrinter
     */
    public Invalid() {
        super();
    }

    /**
     * This method prints an error message.
     *
     * @param parameterList - in this case a single parameter
     * @return true, if command was run successfully, else false
     */
    @Override
    public boolean runCommand(List<StringOrInteger> parameterList) {
        LOGGER.info("Invalid command called");
        outputPrinter.printText("Invalid command!\nPlease enter a new valid command: ");
        return true;
    }
}
