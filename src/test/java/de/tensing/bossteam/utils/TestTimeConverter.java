package de.tensing.bossteam.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TestTimeConverter {

    @Test
    public void testSecToMinAndSecString() {
        Assertions.assertEquals("1:00", TimeConverter.secToMinAndSecString(60));
        Assertions.assertEquals("116:40", TimeConverter.secToMinAndSecString(7000));
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> TimeConverter.secToMinAndSecString(-500));
        Assertions.assertEquals("Cannot insert negative values", exception.getMessage());
    }

    @Test
    public void testGetCurrentTime() {

        //TODO: Test this method
    }
}
