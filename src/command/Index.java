package command;

import models.StringOrInteger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Index extends AbstractCommand {
    private static final int INDEX_FILTER_VALUE = 4;    // Represent the minimum number of occurrences of a word to be printed
    private static final Logger LOGGER = Logger.getLogger(Index.class.getName());

    /**
     * Constructor for Index
     * Initializes the outputPrinter
     */
    public Index() {
           super();
    }

    /**
     * This method takes each substring in a paragraph and adds it into a dictionary where the occurrences are counted.
     * The dictionary is a HashMap with the word and an arraylist that holds all paragraph numbers where this word occurs.
     * Then the words where the first letter is not uppercase are filtered out and then all words that occur less than 3
     * times are filtered out. And then the dictionary is printed.
     *
     * @param parameterList is empty in this case
     * @return true, if command was run successfully, else false
     */
    @Override
    public boolean runCommand(List<StringOrInteger> parameterList) throws Exception {
        LOGGER.info("Index command called");
        try {
            Map<String, List<Integer>> dictionary = new TreeMap<>();

            for (int paragraphNumber = 1; paragraphNumber <= text.getTextLength(); paragraphNumber++) {
                int finalParagraphNumber = paragraphNumber;
                String[] words = text.getParagraphAtIndex(paragraphNumber).getData().split("\\s+", -1);

                Arrays.stream(words)
                        .filter(substring -> Character.isUpperCase(substring.charAt(0)))
                        .forEach(substring -> dictionary.computeIfAbsent(substring, k -> new ArrayList<>()).add(finalParagraphNumber));
            }

            dictionary.entrySet().removeIf(entry -> entry.getValue().size() < INDEX_FILTER_VALUE);
            StringBuilder output = new StringBuilder();

            if (dictionary.isEmpty()) {
                output.append("No words occur more than ").append(INDEX_FILTER_VALUE - 1).append(" times in the text.");
            } else {
                dictionary.forEach((key, values) ->
                        output.append(key).append(": ").append(
                                values.stream().distinct().map(String::valueOf).collect(Collectors.joining(", "))
                        ).append("\n")
                );
            }

            outputPrinter.printText(output.toString());

        } catch (Exception e) {
            LOGGER.severe("An Exception was thrown");
            throw new Exception("An error happened in the runCommand method in " + getClass());
        }
        return true;
    }


}
