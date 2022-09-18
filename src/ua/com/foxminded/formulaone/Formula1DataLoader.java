package ua.com.foxminded.formulaone;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Formula1DataLoader {

    private String startFile;
    private String endFile;
    private String abbreviationsFile;

    public Formula1DataLoader(String startFile, String endFile, String abbreviationsFile) {
        super();
        this.startFile = startFile;
        this.endFile = endFile;
        this.abbreviationsFile = abbreviationsFile;
    }
       

    public List<Lap> generateLapsData() throws FileNotFoundException {

        try {
            FileReader reader = new FileReader();

            List<String> abbreviationsList = reader.readFile(abbreviationsFile);
            List<String> startList = reader.readFile(startFile);
            List<String> endList = reader.readFile(endFile);

            return parseRacers(abbreviationsList).stream().map(racer -> {
                LocalDateTime startTime = parseLapInfo(startList, racer);
                LocalDateTime endTime = parseLapInfo(endList, racer);
                Duration lapDuration = Duration.between(startTime, endTime);

                return new Lap(startTime, endTime, lapDuration, racer);

            }).sorted().collect(Collectors.toList());

        } catch (IOException e) {
            throw new FileNotFoundException(e.getMessage());
        }

    }
   
    private List<Racer> parseRacers(List<String> abbreviationsList) {

        FileParser parser = new FileParser();

        return abbreviationsList.stream().map(parser::createRacerFromString).collect(Collectors.toList());
    }

    private LocalDateTime parseLapInfo(List<String> list, Racer racer) {

        FileParser parser = new FileParser();

        return parser.parseTimeDateFromString(list.stream().filter(line -> line.startsWith(racer.getAbbreviation()))
                .findAny().orElseThrow(() -> new NoSuchElementException("No element in start.log")).substring(3));
    }

}
