package de.tensing.bossteam.utils;

public class TimeConverter {
    public static String secToMinAndSecString(int time) {
        int mins = time / 60;
        int secs = time % 60;
        return secs < 10 ? mins + ":0" + secs : mins + ":" + secs;
    }
}
