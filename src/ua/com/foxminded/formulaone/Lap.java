package ua.com.foxminded.formulaone;

import java.time.Duration;
import java.time.LocalDateTime;

public class Lap implements Comparable<Lap> {

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Duration bestTimeLap;
    private Racer racer;

    public Lap(LocalDateTime startTime, LocalDateTime endTime, Duration bestTimeLap, Racer racer) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.racer = racer;
        this.bestTimeLap = bestTimeLap;
    }

    public Racer getRacer() {
        return racer;
    }

    public Duration getBestTimeLap() {
        return bestTimeLap;
    }

    @Override
    public int compareTo(Lap lap) {
        if (lap == null) {
            return -1;
        }

        return this.bestTimeLap.compareTo(lap.bestTimeLap);
    }

}
