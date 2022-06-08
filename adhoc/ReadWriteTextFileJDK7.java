import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class ReadWriteTextFileJDK7 {

  public static void main(String... args) throws IOException {
    ReadWriteTextFileJDK7 text = new ReadWriteTextFileJDK7();

    // treat as a small file
    // List<String> lines = text.readSmallTextFile(FILE_NAME);
    // log(lines);
    // lines.add("This is a line added in code.");
    // text.writeSmallTextFile(lines, FILE_NAME);

    // treat as a large file - use some buffering
    // using scanner
    text.readLargerTextFile(FILE_NAME);

    // using bufferd reader
    // text.readLargerTextFileAlternate(FILE_NAME);

    // using stream
    // Instant starts = Instant.now();
    // System.out.println("start - " + starts);
    // Stream<String> liness = Files.lines(Paths.get(FILE_NAME));
    // liness.map(l -> l.toUpperCase()).forEach(System.out::println);
    // Instant ends = Instant.now();
    // System.out.println(Duration.between(starts, ends));
  }

  final static String FILE_NAME = "input.txt";
  final static String OUTPUT_FILE_NAME = "output.txt";
  final static Charset ENCODING = StandardCharsets.UTF_8;

  // For smaller files

  /**
   * Note: the javadoc of Files.readAllLines says it's intended for small
   * files. But its implementation uses buffering, so it's likely good
   * even for fairly large files.
   */
  List<String> readSmallTextFile(String fileName) throws IOException {
    Path path = Paths.get(fileName);
    return Files.readAllLines(path, ENCODING);
  }

  void writeSmallTextFile(List<String> lines, String fileName) throws IOException {
    Path path = Paths.get(fileName);
    Files.write(path, lines, ENCODING);
  }

  // For larger files

  void readLargerTextFile(String fileName) throws IOException {
    Instant starts = Instant.now();
    Path path = Paths.get(fileName);
    try (Scanner scanner = new Scanner(path, ENCODING.name())) {
      while (scanner.hasNextLine()) {
        // process each line in some way
        log(scanner.nextLine().toUpperCase());
      }
    }
    Instant ends = Instant.now();
    System.out.println("Using scanner " + Duration.between(starts, ends));
  }

  void readLargerTextFileAlternate(String fileName) throws IOException {
    Instant starts = Instant.now();
    Path path = Paths.get(fileName);
    try (BufferedReader reader = Files.newBufferedReader(path, ENCODING)) {
      String line = null;
      while ((line = reader.readLine()) != null) {
        // process each line in some way
        log(line.toUpperCase());
      }
    }
    Instant ends = Instant.now();
    System.out.println("Using buffered" + Duration.between(starts, ends));
  }

  void writeLargerTextFile(String fileName, List<String> lines) throws IOException {
    Path path = Paths.get(fileName);
    try (BufferedWriter writer = Files.newBufferedWriter(path, ENCODING)) {
      for (String line : lines) {
        writer.write(line);
        writer.newLine();
      }
    }
  }

  private static void log(Object msg) {
    System.out.println(String.valueOf(msg));
  }

}
