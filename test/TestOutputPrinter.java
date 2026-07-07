import io.OutputPrinterInterface;

//This Test class is a copy of the OutputPrinter class from the src/io/OutputPrinter.java file.
//This Test class is only for testing (it saves the Steam instead of printing it to the console with the System.out in OutputPrinter class)
public class TestOutputPrinter implements OutputPrinterInterface {
    private String printingText = "";

    public String getOutput() {
        return printingText;
    }

    public void printText(String text) {
        if (!printingText.isEmpty()) {
            printingText += "\n";
        }
        printingText += text;
    }

    public void printError(String error) {
        System.err.println(error);
    }
}
