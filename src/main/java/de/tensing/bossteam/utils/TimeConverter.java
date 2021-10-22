package de.tensing.bossteam.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeConverter {
    public static String secToMinAndSecString(int time) {
        int mins = time / 60;
        int secs = time % 60;
        return secs < 10 ? mins + ":0" + secs : mins + ":" + secs;
    }

    public static String getCurrentTime() {
        ZoneId timeZoneGermany = ZoneId.of("Europe/Berlin");
        return LocalTime.now(timeZoneGermany)
                .truncatedTo(ChronoUnit.SECONDS)
                .format(DateTimeFormatter.ISO_LOCAL_TIME);
    }
}
