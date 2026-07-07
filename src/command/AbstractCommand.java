package command;

import io.OutputPrinterInterface;
import io.OutputPrinter;
import models.CommandParameter;
import models.StringOrInteger;
import models.Text;

import java.util.LinkedList;
import java.util.List;

/**
 * This class is the abstract class for all commands to inherit from.
 * It provides a list of CommandParameters, a Text and an OutputPrinter.
 */
public abstract class AbstractCommand {

    protected List<CommandParameter> parameterList;
    protected Text text;
    protected OutputPrinterInterface outputPrinter;
    protected Boolean needOffset;

    /**
     * Constructor for AbstractCommand
     * Initializes the parameterList
     */
    protected AbstractCommand() {
        this.parameterList = new LinkedList<>();
        this.outputPrinter = new OutputPrinter();
        this.needOffset = false;
    }

    /**
     * This method returns the parameterList of the command.
     *
     * @return parameterList
     */
    public List<CommandParameter> getParameterList() {
        return parameterList;
    }

    /**
     * This method sets the text instance of the command.
     *
     * @param text - the text instance
     */
    public void setText(Text text) {
        this.text = text;
    }

    /**
     * This method sets the outputPrinter of the command.
     * the outputPrinter is am OutputPrinterInterface for better compatibility and testing.
     *
     * @param outputPrinter - the outputPrinter instance
     */
    public void setOutputPrinter(OutputPrinterInterface outputPrinter) {
        this.outputPrinter = outputPrinter;
    }

    /**
     * This method sets the needOffset of the command.
     * the needOffset is a boolean that indicates if the command needs an offset.
     *
     * @param needOffset - the needOffset instance
     */
    public void setNeedOffset(Boolean needOffset) {
        this.needOffset = needOffset;
    }

    /**
     * This method adds a CommandParameter to the parameterList.
     *
     * @param parameters - the base paramets that where provided with the command
     */
    public void verifyBaseParameters(String parameters) throws IllegalArgumentException{
    }

    /**
     * This method runs the command.
     *
     * @param parameterList - the list of parameters to be used by the command
     * @return true if the program should continue, false if it should exit
     * @throws Exception if something goes wrong
     */
    public abstract boolean runCommand(List<StringOrInteger> parameterList) throws Exception;

}
