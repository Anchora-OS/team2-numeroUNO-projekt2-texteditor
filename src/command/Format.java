package command;

import models.CommandParameter;
import models.StringOrInteger;

import java.util.List;
import java.util.logging.Logger;

/**
 * Format command
 * Sets the format mode and the format length
 * It is differentiated between FIX and RAW
 * FIX: the text is formatted to the given length
 * RAW: the text is not formatted
 */
public class Format extends AbstractCommand {
    private static final Logger LOGGER = Logger.getLogger(Format.class.getName());

    public Format() {
        super();
        parameterList.add(new CommandParameter("Enter Format Mode (Fix/Raw): ", "/^(fix|raw)$/", true, false, new StringOrInteger(true)));
        parameterList.add(new CommandParameter("Enter new Format Length: ", "^\\s*(?:0|[1-9]\\d*)\\s*$", true, false, new StringOrInteger(false)));
    }

    /**
     * This method sets the format mode and the format length.
     *
     * @param parameterList - in this case a single parameter
     * @return true, if command was run successfully, else false
     */
    @Override
    public boolean runCommand(List<StringOrInteger> parameterList) {
        LOGGER.info("Format command called");

        if (parameterList.get(0).getStringValue().equalsIgnoreCase("raw")){
            text.setFormatWidth(0);
        } else {
            text.setFormatWidth(parameterList.get(1).getIntValue());
        }
        outputPrinter.printText("Format width (0 is FIX): " + text.getFormatWidth());
        return true;
    }

    /**
     * This method verifies that the given parameter which is only an index or nothing is valid.
     *
     * @param parameters - in this case a single parameter
     */
    @Override
    public void verifyBaseParameters(String parameters) {
        String[] parameterArray = parameters.split("\\s+");

        if (parameterArray[0].equalsIgnoreCase("raw")) {
            parameterList.get(0).setIsSet(true);
            parameterList.get(0).setValue(new StringOrInteger("RAW"));
            parameterList.get(1).setIsSet(true);
            parameterList.get(1).setValue(new StringOrInteger(0));
        } else if (parameterArray[0].equalsIgnoreCase("fix")) {
            parameterList.get(0).setIsSet(true);
            parameterList.get(0).setValue(new StringOrInteger("FIX"));
            if (parameterArray.length == 2) {
                try {
                    int formatWidth = Integer.parseInt(parameterArray[1]);
                    parameterList.get(1).setIsSet(true);
                    parameterList.get(1).setValue(new StringOrInteger(formatWidth));
                } catch (Exception e) {
                    throw new IllegalArgumentException("Format width is not an integer");
                }
            } else {
                parameterList.get(1).setIsSet(false);
            }
        } else {
            throw new IllegalArgumentException("Illegal parameter: " + parameterArray[0]);
        }
    }
}
