package ua.com.foxminded.formulaone;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileParser {

    public Racer createRacerFromString(String string) {

        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("Empty line!");
        }

        String[] parameterArray = string.split("_");

        return new Racer(parameterArray[0], parameterArray[1], parameterArray[2]);
    }

    public LocalDateTime parseTimeDateFromString(String dateTime) {

        if (dateTime == null || dateTime.isEmpty()) {
            throw new IllegalArgumentException("Empty line!");
        }

        return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS"));
    }
}
