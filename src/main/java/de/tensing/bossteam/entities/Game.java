package de.tensing.bossteam.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

import static de.tensing.bossteam.settings.Settings.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Game {
    private String id;

    private Integer progress;

    private Date startTime;

    public static List<Player> PLAYERS_LIST = new ArrayList<>();

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
