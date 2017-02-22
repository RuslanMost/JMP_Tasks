package troubleshooting.task5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderStreamWithLeak {
    private static final int WORDS_QUANTITY = 3;
    private static final String DELIMITER = " ";

    public static void main(final String[] args) throws InterruptedException, IOException {
        String fileName = "Task #5 - Data.txt";
        List<List<String>> listsOfThreeWordsLists = getAllWords(fileName);
        System.out.println(listsOfThreeWordsLists);
        Thread.sleep(30000);
    }

    private static List<List<String>> getAllWords(final String fileName) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(fileName));
        return lines
                .map(line -> line.split(DELIMITER))
                .map(strings -> {
                    List<String> threeWordList = Arrays.asList(strings);
                    return threeWordList.subList(threeWordList.size() - WORDS_QUANTITY, threeWordList.size());
                })
                .flatMap(Stream::of).collect(Collectors.toList());
    }
}
