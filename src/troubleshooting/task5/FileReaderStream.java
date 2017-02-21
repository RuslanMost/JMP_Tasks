package troubleshooting.task5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderStream {
    private static final int WORDS_QUANTITY = 3;
    private static final String DELIMITER = " ";

    public static void main(final String[] args) throws InterruptedException, IOException {
        String fileName = "Task #5 - Data.txt";
        List<List<String>> words = getAllWords(fileName);
        System.out.println(words);
        Thread.sleep(30000);
    }

    private static List<List<String>> getAllWords(final String fileName) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(fileName));
        return lines
                .map(line -> line.split(DELIMITER))
                .map(strings -> {
                    List<String> words = Arrays.asList(strings);
                    return words.subList(words.size() - WORDS_QUANTITY, words.size());
                })
                .flatMap(Stream::of).collect(Collectors.toList());
    }
}
