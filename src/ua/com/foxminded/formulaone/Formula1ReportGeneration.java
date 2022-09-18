package ua.com.foxminded.formulaone;

import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Formula1ReportGeneration {

    public String generateReport(Formula1DataLoader dataCollection) throws FileNotFoundException {

        if (dataCollection == null) {
            throw new IllegalArgumentException();
        }

        StringBuilder builder = new StringBuilder();

        List<Lap> lapsInfo = dataCollection.generateLapsData();

        int maxTeamNameLength = lapsInfo.stream().mapToInt(lap -> lap.getRacer().getTeamName().length()).max()
                .getAsInt();
        int maxRacerNameLength = lapsInfo.stream().mapToInt(lap -> lap.getRacer().getName().length()).max().getAsInt();

        int place = 1;
        for (Lap lap : lapsInfo) {
            builder.append(generateReportLine(lap, maxRacerNameLength, maxTeamNameLength, place));
            place++;
        }

        return builder.toString();

    }

    private String generateReportLine(Lap lap, int maxRacerNameLength, int maxTeamNameLength, int place) {

        StringBuilder builder = new StringBuilder();

        LocalTime time = LocalTime.ofNanoOfDay(lap.getBestTimeLap().toNanos());
        String timeOutput = time.format(DateTimeFormatter.ofPattern("mm:ss.SSS"));

        int spacesName = maxRacerNameLength - lap.getRacer().getName().length();
        int spacesTeam = maxTeamNameLength - lap.getRacer().getTeamName().length();

        if (place > 9) {
            spacesName--;
        }

        String line = String.format("%d. %s%s | %s%s | %s", place, lap.getRacer().getName(),
                repeatChar(spacesName, ' '), lap.getRacer().getTeamName(), repeatChar(spacesTeam, ' '), timeOutput);

        builder.append(line).append("\n");
        if (place == 15) {
            builder.append(repeatChar(line.length(), '-')).append("\n");
        }
        return builder.toString();
    }

    private String repeatChar(int length, char ch) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            builder.append(ch);
        }

        return builder.toString();
    }

}
