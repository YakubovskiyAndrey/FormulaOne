package ua.com.foxminded.formulaone;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LapTest {

    private Lap lap;

    @BeforeEach
    void setUp() throws Exception {

        LocalDateTime startTime = LocalDateTime.parse("2018-05-24_12:02:58.917",
                DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS"));
        LocalDateTime endTime = LocalDateTime.parse("2018-05-24_12:04:03.332",
                DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS"));
        Duration lapDuration = Duration.between(startTime, endTime);

        lap = new Lap(startTime, endTime, lapDuration, null);
    }

    @Test
    void testCompare() {
        assertEquals(0, lap.compareTo(lap));
    }

    @Test
    void testCompareWhenLapIsNull() {
        assertEquals(-1, lap.compareTo(null));
    }

}
