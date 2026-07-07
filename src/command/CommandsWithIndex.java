package command;

import models.StringOrInteger;

import java.util.logging.Logger;

/**
 * This class is the abstract class for all commands that have index as a base parameter, to inherit from.
 * It inherits from AbstractCommand and provides a method to specifically verify the index parameter.
 */
public abstract class CommandsWithIndex extends AbstractCommand {
    private static final Logger LOGGER = Logger.getLogger(CommandsWithIndex.class.getName());

    /**
     * Constructor for CommandsWithIndex
     * Initializes textLength by getting the text length from text.getTextLength()
     */
    protected CommandsWithIndex() {
        super();
    }

    /**
     * This method verifies the index parameter and sets it on the parameterList.
     * If no index is given, the paragraph is added at the end of the text otherwise it is either added at the given index or nothing is added and the parameterList gets set accordingly.
     * If you need an offset, set needOffset to true in the constructor of the command.
     *
     * @param parameters - the base paramets that where provided with the command
     */
    public void verifyBaseParameters(String parameters) throws IllegalArgumentException {
        String[] parameterArray = parameters.split("\\s+");
        int textLength = text.getTextLength();

        if (parameterArray.length == 1 && parameterArray[0].isEmpty()) {
            parameterList.get(0).setIsSet(true);
            parameterList.get(0).setValue(new StringOrInteger(textLength + (needOffset ? 1 : 0)));
        } else if (parameterArray.length > 1) {
            LOGGER.severe("An IllegalArgumentException was thrown");
            throw new IllegalArgumentException("Illegal parameterArray.length exception");
        } else {
            int index;
            try {
                index = Integer.parseInt(parameterArray[0]);
            } catch (Exception e) {
                LOGGER.severe("An IllegalArgumentException was thrown");
                throw new IllegalArgumentException("Index is not an integer: " + e);
            }

            if (index > 0 && index <= textLength + 1) {
                parameterList.get(0).setIsSet(true);
                parameterList.get(0).setValue(new StringOrInteger(index));
            } else {
                parameterList.get(0).setIsSet(false);
                parameterList.get(0).setRegexValidator("^(?:[1-" + (textLength + 1) + "]|)$");
                parameterList.get(0).setOutputText("Index has to be between 1 and " + (textLength + 1) + " Please re-enter index: ");
            }
        }
    }

}
