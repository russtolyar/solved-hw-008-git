package hw009;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Book {

    private static final Logger LOGGER = LogManager.getLogger(Book.class);

    public static void main(String[] args) throws IOException {

        LOGGER.debug("Hello");


        File textFile = new File("src\\main\\resources\\book.txt");
        LOGGER.debug("Path " + textFile.getAbsolutePath());

        String text = FileUtils.readFileToString(textFile, "UTF-8");
        LOGGER.debug("Original text read as  - " + text);

        text = text.toLowerCase();
        LOGGER.debug("TO LOWER case - " + text);

        text = text.replaceAll("[^a-z]", " ");
        LOGGER.debug("JUST LOW LETTERS AND SPACE " + text);
        LOGGER.debug(StringUtils.isAlphanumericSpace(text));

        String[] textSplited = StringUtils.split(text);
        LOGGER.debug("SPLIT ACTIVATED \n " + Arrays.toString(textSplited));

        List<String> textList = new ArrayList<>(Arrays.asList(textSplited));
        System.out.println("Change to ARRAYLIST \n " + textList);
        LOGGER.debug("Change to ARRAYLIST \n " + textList);

        Map<String, Integer> textMap = new HashMap<>();
        LOGGER.debug("textMap was created \n" + textMap);
        for (String word :
                textList) {
            if (textMap.containsKey(word)) {
                textMap.put(word, textMap.get(word) + 1);
            } else {
                textMap.put(word, 1);
            }
        }
        textMap.entrySet().stream().sorted(Map.Entry
                .<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);

        Map<String, Integer> result = textMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        LOGGER.debug("\n\n" + result + "\nFOR!!!!!!!!!!!!!!!!!!!\n");

        for (Map.Entry<String, Integer> rez : result.entrySet()) {
            LOGGER.debug(rez);

        }
        FileUtils.writeLines(new File("src\\main\\resources\\writenFromBook.txt"), result.entrySet());
    }
}