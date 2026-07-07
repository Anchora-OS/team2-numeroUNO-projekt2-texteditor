package command;

import models.CommandParameter;
import models.StringOrInteger;

import java.util.List;
import java.util.logging.Logger;

/**
 * Replace command
 * Replaces a word in a paragraph with all occurrences of the word with another word
 * If no index is given, the last paragraph is used
 * If the index is not valid, nothing is replaced
 */
public class Replace extends CommandsWithIndex {
    private static final Logger LOGGER = Logger.getLogger(Replace.class.getName());

    /**
     * Constructor for Replace
     * Initializes the parameterList and adds the parameters that are required for the command
     */
    public Replace() {
        this.parameterList.add(new CommandParameter("Index was not correct!\\nPlease re-enter index: ", "^(?:[1-9]|)$", true, false, new StringOrInteger(false)));
        this.parameterList.add(new CommandParameter("Searched word: ", "(.*?)", false, false, new StringOrInteger(true)));
        this.parameterList.add(new CommandParameter("To replace with: ", "(.*?)", false, false, new StringOrInteger(true)));
    }

    /**
     * This method replaces a word in a paragraph with all occurrences of the word with another word
     * If no index is given, the last paragraph is used
     * If the index is not valid, nothing is replaced
     *
     * @param parameterList - in this case a single parameter
     * @return true, if command was run successfully, else false
     */
    @Override
    public boolean runCommand(List<StringOrInteger> parameterList) {
        LOGGER.info("Replace command called");
        int index = parameterList.get(0).getIntValue();
        String toReplace = parameterList.get(1).getStringValue();
        String replacement = parameterList.get(2).getStringValue();

        this.text.setParagraphAtIndex(index, this.text.getParagraphAtIndex(index).getData().replace(toReplace, replacement));
        return true;
    }
}
