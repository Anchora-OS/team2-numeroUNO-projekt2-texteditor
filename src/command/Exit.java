package command;

import models.StringOrInteger;

import java.util.List;
import java.util.logging.Logger;

/**
 * Exit command
 * Exits the program by returning false.
 */
public class Exit extends AbstractCommand {
    private static final Logger LOGGER = Logger.getLogger(Exit.class.getName());

    /**
     * This method exits the program by returning false.
     *
     * @param parameterList - in this case a single parameter
     * @return true, if command was run successfully, else false
     */
    @Override
    public boolean runCommand(List<StringOrInteger> parameterList) {
        LOGGER.info("Exit command called");
        return false;
    }
}
