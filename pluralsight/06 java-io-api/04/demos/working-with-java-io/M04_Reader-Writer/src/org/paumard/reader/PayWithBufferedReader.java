package org.paumard.reader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class PayWithBufferedReader {

    public static void main(String[] args) {

        Path path = Path.of("files/sonnet.txt");
        try (BufferedReader bufferedReader = Files.newBufferedReader(path);) {

            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println("line = " + line);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader bufferedReader = Files.newBufferedReader(path);) {

            Stream<String> lines = bufferedReader.lines();
            lines.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
