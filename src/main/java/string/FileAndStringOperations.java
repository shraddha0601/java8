package string;

import java.io.File;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * Created by shraddha on 2/10/16.
 */
public class FileAndStringOperations {
    public static void main(String[] args) {
        System.out.println("Please enter directory name: ");
        Scanner directoryScanner = new Scanner(System.in);
        String dirName = directoryScanner.next();
        listAllFilesInDir(dirName);
    }

    private static void listAllFilesInDir(String dirName) {
        File directory = new File(dirName);
        System.out.println(
                Stream.of( directory.listFiles())
                .map(File::getName)
                .collect(joining(", "))
        );
    }
}
