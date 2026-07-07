package command;

import models.CommandParameter;
import models.StringOrInteger;

import java.util.List;
import java.util.logging.Logger;

/**
 * Del command
 * Deletes a paragraph from the text
 * If no index is given, the last paragraph is deleted
 * If the index is not valid, nothing is deleted
 */
public class Del extends CommandsWithIndex {
    private static final Logger LOGGER = Logger.getLogger(Del.class.getName());

    /**
     * Constructor for Del
     * Initializes the parameterList and adds the parameters that are required for the command
     */
    public Del() {
        parameterList.add(new CommandParameter("Index was not correct!\\nPlease re-enter index: ", "^(?:[1-9]|)$", true, false, new StringOrInteger(false)));
    }

    /**
     * This method deletes a paragraph at the given index or at the end of the text.
     *
     * @param parameterList - in this case a single parameter
     * @return true, if command was run successfully, else false
     */
    @Override
    public boolean runCommand(List<StringOrInteger> parameterList) {
        LOGGER.info("Del command called");
        text.removeParagraph(parameterList.get(0).getIntValue());
        return true;
    }
}
