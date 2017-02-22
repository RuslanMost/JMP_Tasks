package troubleshooting.task5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class FileReaderScannerWithLeak {
    private static final int WORDS_QUANTITY = 3;

    public static void main(final String[] args) throws InterruptedException, IOException {
        String fileName = "Task #5 - Data.txt";
        List<List<String>> allLines = getSplitedLines(fileName);
        List<List<String>> collect = getAllLists(allLines);
        System.out.println(collect);
        Thread.sleep(30000);
    }

    private static List<List<String>> getAllLists(final List<List<String>> allLines) {
        List<List<String>> threeWordsLists = new ArrayList<>();
        for (List<String> splittedLine : allLines) {
            List<String> lastThreeWordsList = splittedLine.subList(splittedLine.size() - WORDS_QUANTITY, splittedLine.size());
            threeWordsLists.add(lastThreeWordsList);
        }
        return threeWordsLists;
    }

    private static List<List<String>> getSplitedLines(final String fileName) throws IOException {
        List<List<String>> lines = new ArrayList<>();
        try (FileInputStream inputStream = new FileInputStream(fileName); Scanner sc = new Scanner(inputStream)) {
            while (sc.hasNextLine()) {
                lines.add(Arrays.asList(sc.nextLine().split(" ")));
            }
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        }
        return lines.isEmpty() ? Collections.emptyList() : lines;
    }
}
