package de.tensing.bossteam.entities;

import de.tensing.bossteam.news.News;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.IntStream;

import de.tensing.bossteam.utils.TimeConverter;
import org.apache.commons.collections4.queue.CircularFifoQueue;

import static de.tensing.bossteam.entities.Settings.*;
import static de.tensing.bossteam.utils.TimeConverter.getCurrentTime;

public class Game {
    public static List<Player> PLAYERS_LIST = new ArrayList<>();
    public static Queue<News> NEWS = new CircularFifoQueue<>(MAX_NUMBER_OF_NEWS);

    public static Integer PROGRESS = START_PROGRESS;

    public static Boolean GAME_STARTED = false;

    public static Boolean IS_DAY = true;
    public static String DAYTIME = "TAGESZEIT";
    public static Integer TIME_SEC = 600;
    public static String TIME = "404 Not Found";

    static {
        IntStream
                .rangeClosed(1, NUMBER_OF_PLAYERS)
                .forEach(i -> PLAYERS_LIST
                        .add(new Player(
                                i,
                                START_HEALTH,
                                START_FOOD,
                                START_ARMOR)));
        NEWS.add(new News(getCurrentTime(), "Hallo"));
        NEWS.add(new News(getCurrentTime(), "Was geht"));
        NEWS.add(new News(getCurrentTime(), "Test"));
        NEWS.add(new News(getCurrentTime(), "Halloooo"));
        NEWS.add(new News(getCurrentTime(), "Hallo5"));
        NEWS.add(new News(getCurrentTime(), "Hallo6. DAS IST EINE SEEEHR LANGE NACHRICHT DIE LÄNGER IST ALS SIE VIELLEICHT SEIN SOLLE !!11elfe!!"));

    }
}
