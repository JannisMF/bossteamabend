package de.tensing.bossteam.utils;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeConverter {
    public static String secToMinAndSecString(int time) {

        if (time < 0) {
            throw new RuntimeException("Cannot insert negative values");
        }

        int minutes = time / 60;
        int seconds = time % 60;
        return seconds < 10 ? minutes + ":0" + seconds : minutes + ":" + seconds;
    }

    public static String getCurrentTime() {
        ZoneId timeZoneGermany = ZoneId.of("Europe/Berlin");
        return LocalTime.now(timeZoneGermany)
                .truncatedTo(ChronoUnit.SECONDS)
                .format(DateTimeFormatter.ISO_LOCAL_TIME);
    }
}
