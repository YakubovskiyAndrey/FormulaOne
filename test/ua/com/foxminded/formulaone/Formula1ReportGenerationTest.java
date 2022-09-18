package ua.com.foxminded.formulaone;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Formula1ReportGenerationTest {

    private Formula1ReportGeneration report;
    private Formula1DataLoader formula1Data;

    @BeforeEach
    void setUp() throws FileNotFoundException {

        report = new Formula1ReportGeneration();
        formula1Data = new Formula1DataLoader("FilesLog/start.log", "FilesLog/end.log",
               "FilesLog/abbreviations.txt");
    }

    @Test
    void testShouldReturnGeneratedReport() throws FileNotFoundException {
        String expected = "1. Sebastian Vettel  | FERRARI                   | 01:04.415\n"
                + "2. Daniel Ricciardo  | RED BULL RACING TAG HEUER | 01:12.013\n"
                + "3. Valtteri Bottas   | MERCEDES                  | 01:12.434\n"
                + "4. Lewis Hamilton    | MERCEDES                  | 01:12.460\n"
                + "5. Stoffel Vandoorne | MCLAREN RENAULT           | 01:12.463\n"
                + "6. Kimi Raikkonen    | FERRARI                   | 01:12.639\n"
                + "7. Fernando Alonso   | MCLAREN RENAULT           | 01:12.657\n"
                + "8. Sergey Sirotkin   | WILLIAMS MERCEDES         | 01:12.706\n"
                + "9. Charles Leclerc   | SAUBER FERRARI            | 01:12.829\n"
                + "10. Sergio Perez     | FORCE INDIA MERCEDES      | 01:12.848\n"
                + "11. Romain Grosjean  | HAAS FERRARI              | 01:12.930\n"
                + "12. Pierre Gasly     | SCUDERIA TORO ROSSO HONDA | 01:12.941\n"
                + "13. Carlos Sainz     | RENAULT                   | 01:12.950\n"
                + "14. Esteban Ocon     | FORCE INDIA MERCEDES      | 01:13.028\n"
                + "15. Nico Hulkenberg  | RENAULT                   | 01:13.065\n"
                + "------------------------------------------------------------\n"
                + "16. Brendon Hartley  | SCUDERIA TORO ROSSO HONDA | 01:13.179\n"
                + "17. Marcus Ericsson  | SAUBER FERRARI            | 01:13.265\n"
                + "18. Lance Stroll     | WILLIAMS MERCEDES         | 01:13.323\n"
                + "19. Kevin Magnussen  | HAAS FERRARI              | 01:13.393\n";

        String actual = report.generateReport(formula1Data);
        assertEquals(expected, actual);
    }

    @Test
    void testWhenUseNullArgument() {
        assertThrows(IllegalArgumentException.class, () -> {
            report.generateReport(null);
        });
    }

}
