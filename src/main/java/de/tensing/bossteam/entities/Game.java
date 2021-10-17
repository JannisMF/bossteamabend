package de.tensing.bossteam.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

import static de.tensing.bossteam.entities.Settings.*;

public class Game {
    public static List<Player> PLAYERS_LIST = new ArrayList<>();

    public static Integer PROGRESS = START_PROGRESS;

    public static Date START_TIME;

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
