package pl.com.ttpsc.www.jdk8.helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileHelper {

	public static final String LINES = "lines.txt";
	public static final String SONNET = "sonnet.txt";

	public static Stream<String> getStreamFromFile(String pFilename) throws IOException {
		Path path = Paths.get(pFilename);
		return Files.lines(path);
	}

}
