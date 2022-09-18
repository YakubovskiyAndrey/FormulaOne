package ua.com.foxminded.formulaone;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileParserTest {

    private FileParser parser;

    @BeforeEach
    void setUp() throws Exception {
        parser = new FileParser();
    }

    @Test
    void testReturnRacerFromString() {

        Racer actual = parser.createRacerFromString("SVF_Sebastian Vettel_FERRARI");
        String expectedAbbr = "SVF";
        String expectedFullName = "Sebastian Vettel";
        String expectedTeamName = "FERRARI";
        assertNotNull(actual);

        assertEquals(actual.getAbbreviation(), expectedAbbr);
        assertEquals(actual.getName(), expectedFullName);
        assertEquals(actual.getTeamName(), expectedTeamName);
    }

    @Test
    void testWhenArgumentRacerIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            parser.createRacerFromString("");
        });
    }

    @Test
    void testWhenArgumentRacerIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            parser.createRacerFromString(null);
        });
    }

    @Test
    void testWhenArgumentTimeDateIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            parser.parseTimeDateFromString("");
        });
    }

    @Test
    void testWhenArgumentTimeDateIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            parser.parseTimeDateFromString(null);
        });
    }

}
