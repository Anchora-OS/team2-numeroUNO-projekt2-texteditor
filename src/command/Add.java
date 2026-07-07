package command;

import models.CommandParameter;
import models.StringOrInteger;

import java.util.List;
import java.util.logging.Logger;

/**
 * Add command
 * Adds a paragraph to the text
 * If no index is given, the paragraph is added at the end of the text
 * If the index is not valid, nothing is added
 */
public class Add extends CommandsWithIndex {
    private static final Logger LOGGER = Logger.getLogger(Add.class.getName());

    /**
     * Constructor for Add
     * Initializes the parameterList and adds the parameters that are required for the command
     */
    public Add() {
        setNeedOffset(true);
        parameterList.add(new CommandParameter("Index was not correct!\\nPlease re-enter index: ", "^(?:[1-9]|)$", true, false, new StringOrInteger(false)));
        parameterList.add(new CommandParameter("New Text to add: ", "(.*?)", false, false, new StringOrInteger(true)));
    }

    /**
     * This method adds a new paragraph at the given index or at the end of the text.
     *
     * @param parameterList - in this case a single parameter
     * @return true, if command was run successfully, else false
     */
    @Override
    public boolean runCommand(List<StringOrInteger> parameterList) {
        LOGGER.info("Add command called");
        text.addParagraph(parameterList.get(0).getIntValue(), parameterList.get(1).getStringValue());
        return true;
    }
}
