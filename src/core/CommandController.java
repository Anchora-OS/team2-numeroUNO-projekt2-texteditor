package core;

import command.*;
import io.ParameterInput;
import models.ActionTupel;
import models.StringOrInteger;
import models.Text;

import java.util.List;
import java.util.logging.Logger;

/**
 * The CommandController class is responsible for selecting the correct command class based on the command provided by the ActionTupel.
 * It also calls the command, provides it with potential parameters, runs it and returns a boolean if the programm should continue running or not.
 */
public class CommandController {

    private final ParameterInput parameterInput;
    private final Text text;
    private static final Logger LOGGER = Logger.getLogger(CommandController.class.getName());

    /**
     * Constructor for the CommandController class.
     *
     * @param text the text object that is used for the commands
     */
    public CommandController(Text text) {
        this.parameterInput = new ParameterInput();
        this.text = text;
    }

    /**
     * Selects the command class based on the command Enum provided by the parameter.
     * If no command is found, the INVALID command is returned.
     *
     * @param command the command Enum
     * @return the command class (never {@code null})
     */
    public AbstractCommand selectCommand(Commands command) {
        for (Commands c : Commands.values()) {
            if (c.name().equals(command.name())) {
                return c.getCommandClass();
            }
        }
        return Commands.INVALID.getCommandClass();
    }

    /**
     * Calls the command class that was provided by the ActionTupel, runs it and returns a boolean if the programm should continue running or not.
     *
     * @param actionTupel the action tupel
     * @return the result of the command (never {@code null})
     */
    public boolean callCommand(ActionTupel actionTupel) {
        try {
            AbstractCommand command = selectCommand(actionTupel.getCommand());
            command.setText(text);
            command.verifyBaseParameters(actionTupel.getValue());
            List<StringOrInteger> returnedParameterList = parameterInput.getParameters(command.getParameterList());
            return command.runCommand(returnedParameterList);
        } catch (Exception e) {
            LOGGER.severe("callCommand threw an exception: " + e);
            return true;
        }
    }
}
