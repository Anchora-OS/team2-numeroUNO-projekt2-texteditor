package command;

import models.CommandParameter;
import models.StringOrInteger;

import java.util.List;
import java.util.logging.Logger;

/**
 * Dummy command
 * Adds a preset paragraph to the text
 * If no index is given, the paragraph is added at the end of the text
 * If the index is not valid, nothing is added and user is asked again
 */
public class Dummy extends CommandsWithIndex {
    private static final Logger LOGGER = Logger.getLogger(Dummy.class.getName());

    /**
     * Constructor for Dummy
     * Initializes the parameterList and adds the parameters that are required for the command
     */
    public Dummy() {
        setNeedOffset(true);
        parameterList.add(new CommandParameter("Index was not correct!\\nPlease re-enter index: ", "^(?:[1-9]|)$", true, false, new StringOrInteger(false)));
    }

    /**
     * This method adds a new paragraph at the given index or at the end of the text.
     *
     * @param parameterList - in this case a single parameter
     * @return true, if command was run successfully, else false
     */
    @Override
    public boolean runCommand(List<StringOrInteger> parameterList) {
        LOGGER.info("Dummy command called");
        String dummyText = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor " +
                "invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo " +
                "dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";
        text.addParagraph(parameterList.get(0).getIntValue(), dummyText);
        return true;
    }


}
