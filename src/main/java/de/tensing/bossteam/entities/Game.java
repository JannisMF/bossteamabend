package de.tensing.bossteam.entities;

import org.apache.commons.collections4.queue.CircularFifoQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

import static de.tensing.bossteam.entities.Settings.*;

public class Game {
    public static List<Player> PLAYERS_LIST = new ArrayList<>();
    public static Queue<News> NEWS = new CircularFifoQueue<>(MAX_NUMBER_OF_NEWS);
    public static Queue<Price> PRICE = new CircularFifoQueue<>(MAX_NUMBER_OF_PRICES);

    public static Integer PROGRESS = START_PROGRESS;

    public static Boolean GAME_STARTED = false;

    public static Boolean IS_DAY = false;
    public static String DAYTIME = "TAGESZEIT";
    public static Integer TIME_SEC = NIGHT_LENGTH;
    public static String TIME = "404 Not Found";

    static {
        IntStream
                .rangeClosed(1, NUMBER_OF_PLAYERS)
                .forEach(i -> PLAYERS_LIST
                        .add(new Player(
                                i,
                                START_HEALTH,
                                START_FOOD,
                                START_ARMOR,
                                "Spieler " + i)));
    }
}
