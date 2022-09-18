package ua.com.foxminded.formulaone;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Formula1DataLoaderTest {

    String startLogFileName;
    String endLogFileName;
    String abbrFileName;
    Formula1DataLoader formula1Data;
    Formula1DataLoader formula1DataEmpty;

    @BeforeEach
    void setUp() throws Exception {
        formula1Data = new Formula1DataLoader("FilesLog/start.log", "FilesLog/end.log", "FilesLog/abbreviations.txt");
        formula1DataEmpty = new Formula1DataLoader("","",""); 
    }

    @Test
    void testListMustNotBeEmpty() throws FileNotFoundException {
        assertFalse(formula1Data.generateLapsData().isEmpty());
    }

    @Test
    void testRacerWhoTookFirstPlace() throws FileNotFoundException {
        List<Lap> actual = formula1Data.generateLapsData();
        assertEquals("Sebastian Vettel", actual.get(0).getRacer().getName());
    }
    
    @Test
    void testWhenFilePathNotSpecified() {              
        assertThrows(IllegalArgumentException.class, () -> {
            formula1DataEmpty.generateLapsData();
        });
    }

}
