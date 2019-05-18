package pl.com.ttpsc.www.jdk8;

import pl.com.ttpsc.www.jdk8.helper.FileHelper;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exercise2 {

	private static final String WORD_REGEXP = "[- .:,]+";

	/**
	 * Exercise 1
	 *
	 * Create a new list with all the strings from original list converted to
	 * lower case and print them out.
	 */
	private static void exercise1() {
		List<String> list = Arrays.asList(
				"The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

		list.stream()
				.map(s -> s.toUpperCase())
				.forEach(System.out::println);
	}

	/**
	 * Exercise 2
	 *
	 * Modify exercise 1 so that the new list only contains strings that have an
	 * odd length
	 */
	private static void exercise2() {
		List<String> list = Arrays.asList(
				"The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

		List<String> solution = list.stream()
				.filter(s -> s.length() % 2 != 0)
				.collect(Collectors.toList());
		System.out.println(solution);
	}

	/**
	 * Exercise 3
	 *
	 * Join the second, third and forth strings of the list into a single
	 * string, where each word is separated by a hyphen (-). Print the resulting
	 * string.
	 */
	private static void exercise3() {
		List<String> list = Arrays.asList(
				"The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");

		String solution = IntStream
				.range(0, list.size())
				.filter(i -> ((i >= 2) && (i <= 4)))
				.mapToObj(list::get)
				.collect(Collectors.joining("-"));

		System.out.println(solution);
	}

	/**
	 * Count the number of lines in the file using the BufferedReader provided
	 */
	private static void exercise4() throws IOException {

		long count = FileHelper.getStreamFromFile(FileHelper.SONNET)
				.count();
		System.out.println("line counter: " + count);

	}

	/**
	 * Create a list of words with no duplicates
	 * contained in the file. Print the words.
	 * 
	 * HINT: A regular expression, WORD_REGEXP, is already defined for your use.
	 */
	private static void exercise5() throws IOException {

		Set<String> solution = FileHelper.getStreamFromFile(FileHelper.SONNET)
				.map(s -> s.split(WORD_REGEXP))
				.flatMap(s -> Arrays.stream(s))
				.distinct()
				.collect(Collectors.toSet());
		System.out.println(solution);

	}

	/**
	 * Create a list of words from the file, converted to lower-case
	 * and with duplicates removed, which is sorted by natural order.
	 * Print the contents of the list.
	 */
	private static void exercise6() throws IOException {

		FileHelper.getStreamFromFile(FileHelper.SONNET)
				.map(s -> s.split(WORD_REGEXP))
				.flatMap(s -> Arrays.stream(s))
				.map(s -> s.toLowerCase())
				.distinct()
				.sorted()
				.forEach(System.out::println);
	}

	/**
	 * Modify exercise 6 so that the words are sorted by length
	 */
	private static void exercise7() throws IOException {

		FileHelper.getStreamFromFile(FileHelper.SONNET)
				.map(s -> s.split(WORD_REGEXP))
				.flatMap(s -> Arrays.stream(s))
				.map(s -> s.toLowerCase())
				.distinct()
				.sorted(Comparator.comparingInt(String::length))
				.forEach(System.out::println);
		
	}

	public static void main(String[] args) throws IOException {
		System.out.println("solution 1:");
		exercise1();
		System.out.println("solution 2:");
		exercise2();
		System.out.println("solution 3:");
		exercise3();
		System.out.println("solution 4:");
		exercise4();
		System.out.println("solution 5:");
		exercise5();
		System.out.println("solution 6:");
		exercise6();
		System.out.println("solution 7:");
		exercise7();
	}

}
