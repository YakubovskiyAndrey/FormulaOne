package ua.com.foxminded.formulaone;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileReaderTest {

    private FileReader reader;

    @BeforeEach
    void setUp() throws Exception {
        reader = new FileReader();
    }

    @Test
    void testReturnNonEmptyLine() throws IOException {
        List<String> list = reader.readFile("FilesLog/start.log");
        assertEquals("SVF2018-05-24_12:02:58.917", list.get(0));
    }

    @Test
    void testFileNameIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            reader.readFile("");
        });
    }
    
    @Test
    void testFileNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            reader.readFile(null);
        });
    }

    @Test
    void testFileIsNotExsist() {
        assertThrows(NoSuchFileException.class, () -> {
            reader.readFile("file");
        });

    }
    
    @Test
    void testFileIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            reader.readFile("FilesLog/testEmptyFile.txt");
        });

    }

}
