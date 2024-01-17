
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadingFilesPerLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test the method here

    }
    public static List<String> read(String file) throws IOException {
        return Files.lines(Paths.get(file)).toList();
//        try (Stream<String> stream = Files.lines(Paths.get(file))) {
//            lines = stream.collect(Collectors.toList());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return lines;
    }
}
