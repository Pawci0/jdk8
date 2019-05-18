package pl.com.ttpsc.www.jdk8;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import pl.com.ttpsc.www.jdk8.helper.FileHelper;

public class Exercise3 {

    private static final String WORD_REGEXP = "[- .:,]+";

    /**
     * Exercise 0
     * <p>
     * Get the longest word in the file using max()
     */
    private static void exercise0() throws IOException {

        String longestWord = FileHelper.getStreamFromFile(FileHelper.LINES)
                .flatMap((String line) -> Stream.of(line.split(WORD_REGEXP)))
                .max(Comparator.comparingInt(String::length)).get();

        System.out.print(longestWord);
    }

    /**
     * Exercise 1
     * <p>
     * Get the longest word in the file using reduce()
     */
    private static void exercise1() throws IOException {

        String longestWord = FileHelper.getStreamFromFile(FileHelper.LINES)
                .flatMap((String line) -> Stream.of(line.split(WORD_REGEXP)))
                .reduce((a, b) -> a.length() < b.length() ? b : a).get();

        System.out.print(longestWord);
    }

    /**
     * Exercise 2
     * <p>
     * Get the length of the longest word in the file
     */
    private static void exercise2() throws IOException {

        int max = FileHelper.getStreamFromFile(FileHelper.LINES)
                .flatMap((String line) -> Stream.of(line.split(WORD_REGEXP)))
                .max(Comparator.comparingInt(String::length)).get().length();

        System.out.print(max);
    }

    /**
     * Exercise 3
     * <p>
     * Get the list of the shortest words in the file
     */
    private static void exercise3() throws IOException {

        int shortestWordLength = FileHelper.getStreamFromFile(FileHelper.LINES)
                .flatMap((String line) -> Stream.of(line.split(WORD_REGEXP)))
                .min(Comparator.comparingInt(String::length)).get().length();

        List<String> shortestWords = FileHelper.getStreamFromFile(FileHelper.LINES)
                .flatMap((String line) -> Stream.of(line.split(WORD_REGEXP)))
                .filter(s -> (s.length() == shortestWordLength)).collect(Collectors.toList());

        System.out.println(shortestWordLength);
        System.out.print(shortestWords);
    }

    /**
     * Exercise 4
     * <p>
     * Get the number of words in the file
     */
    private static void exercise4() throws IOException {

        long wordCount = FileHelper.getStreamFromFile(FileHelper.LINES)
                .flatMap((String line) -> Stream.of(line.split(WORD_REGEXP)))
                .count();

        System.out.print(wordCount);
    }

    /**
     * Exercise 5
     * <p>
     * Get the number of letters in the file
     */
    private static void exercise5() throws IOException {

        long letterCount = FileHelper.getStreamFromFile(FileHelper.LINES)
                .flatMap((String line) -> Stream.of(line.split(WORD_REGEXP)))
                .mapToInt(s -> s.length()).sum();

        System.out.print(letterCount);
    }

    /**
     * Exercise 6
     * <p>
     * Get the average word length in the file
     */
    private static void exercise6() throws IOException {

        double average = FileHelper.getStreamFromFile(FileHelper.LINES)
                .flatMap((String line) -> Stream.of(line.split(WORD_REGEXP)))
                .mapToInt(s -> s.length()).average().getAsDouble();

        System.out.print(average);
    }

    /**
     * Exercise 7
     * <p>
     * Get the number of occurrences of the word "luxemburg"
     */
    private static void exercise7() throws IOException {

        long luxemburgCount = FileHelper.getStreamFromFile(FileHelper.LINES)
                .flatMap((String line) -> Stream.of(line.split(WORD_REGEXP)))
                .filter(s -> s.equals("luxemburg")).count();

        System.out.print(luxemburgCount);
    }

    /**
     * Exercise 8
     * <p>
     * Group the number of words per word length; For example: 30 words with
     * length 4, 60 words with length 5, etc.
     */
    private static void exercise8() throws IOException {

        Map<Integer, Long> numberOfWordsPerLength = FileHelper.getStreamFromFile(FileHelper.LINES)
                .flatMap((String line) -> Stream.of(line.split(WORD_REGEXP)))
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));

        System.out.print(numberOfWordsPerLength);
    }

    /**
     * Exercise 9
     * <p>
     * Group the number of occurrences of each character in the file For
     * example: a = 4, b = 5, etc.
     */
    private static void exercise9() throws IOException {

        Map<String, Long> numberOfLetterOccurrences = FileHelper.getStreamFromFile(FileHelper.LINES)
                .flatMap((String line) -> Stream.of(line.split(WORD_REGEXP)))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        //System.out.print(numberOfLetterOccurrences);
    }

    /**
     * Exercise 10
     * <p>
     * Get the list with number of words in each line; For example: 100, 150,
     * 120, etc.
     */
    private static void exercise10() throws IOException {

        List<Long> wordsInLines = FileHelper.getStreamFromFile(FileHelper.LINES)
                .map((String line) -> Stream.of(line.split(WORD_REGEXP)))
                .map(s -> s.count())
                .collect(Collectors.toList());

        System.out.print(wordsInLines);
    }

    public static void main(String[] args) throws IOException {

        System.out.print("solution 0: ");
        exercise0();
        System.out.println();
        System.out.print("solution 1: ");
        exercise1();
        System.out.println();
        System.out.print("solution 2: ");
        exercise2();
        System.out.println();
        System.out.print("solution 3: ");
        exercise3();
        System.out.println();
        System.out.print("solution 4: ");
        exercise4();
        System.out.println();
        System.out.print("solution 5: ");
        exercise5();
        System.out.println();
        System.out.print("solution 6: ");
        exercise6();
        System.out.println();
        System.out.print("solution 7: ");
        exercise7();
        System.out.println();
        System.out.print("solution 8: ");
        exercise8();
        System.out.println();
        System.out.print("solution 9: ");
        exercise9();
        System.out.println();
        System.out.print("solution 10: ");
        exercise10();

    }

}
