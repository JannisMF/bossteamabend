package de.tensing.bossteam.entities;

import java.util.*;
import java.util.stream.IntStream;

import org.apache.commons.collections4.queue.CircularFifoQueue;

import static de.tensing.bossteam.entities.Settings.*;

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
    }
}
