package ua.com.foxminded.formulaone;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {

    public List<String> readFile(String fileName) throws IOException {

        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("Empty filename!");
        }

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {

            List<String> lines = reader.lines().collect(Collectors.toList());
            if (lines.isEmpty()) {
                throw new IllegalArgumentException("Empty file!");
            }

            return lines;
        } catch (NullPointerException e) {
            throw new NoSuchFileException(fileName);
        }
    }

}
