package de.tensing.bossteam.scheduled;

import de.tensing.bossteam.entities.News;
import de.tensing.bossteam.entities.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

import static de.tensing.bossteam.entities.Game.*;
import static de.tensing.bossteam.entities.Settings.*;
import static de.tensing.bossteam.utils.TimeConverter.getCurrentTime;

@Slf4j
@Component
public class ScheduledActivities {

    private int secondsLeftFood = FOOD_REMOVAL_INTERVAL;

    //Execute every second
    @Scheduled(fixedDelay = 1000)
    public void executeScheduler() {
        if (GAME_STARTED == true) {
            // REMOVE FOOD
            if (!(secondsLeftFood > 0)) {
                secondsLeftFood = FOOD_REMOVAL_INTERVAL;
                removeFood();
            } else {
                secondsLeftFood--;
            }

            // COMPUTE DAY/NIGHT
            if (IS_DAY) {
                if (!(TIME_SEC > 0)) {
                    TIME_SEC = NIGHT_LENGTH;
                    IS_DAY = false;
                    String message = "Die Nacht beginnt. Passt vor den Zombies auf!";
                    News news = new News(getCurrentTime(), message);
                    NEWS.add(news);
                } else {
                    TIME_SEC--;
                }
            } else {
                if (!(TIME_SEC > 0)) {
                    TIME_SEC = DAY_LENGTH;
                    IS_DAY = true;
                    String message = "Der Tag ist angebrochen. Gewinnt Spiele um Fortschritt zu bekommen!";
                    News news = new News(getCurrentTime(), message);
                    NEWS.add(news);
                } else {
                    TIME_SEC--;
                }
            }
        }
    }
    private void removeFood() {
        for (int i = 0; i < PLAYERS_LIST.size(); i++) {
            Player p = PLAYERS_LIST.get(i);
            if (p.getFood() > 0) {
                p.setFood(p.getFood() - 1);
            } else if (p.getHealth() > 0) {
                p.setHealth(p.getHealth() - 1);
                if (p.getHealth() == 0) {
                    String message = p.getName() + " ist verhungert.";
                    News news = new News(getCurrentTime(), message);
                    NEWS.add(news);
                }
            }
            PLAYERS_LIST.set(i, p);
        }
        String message = "Alle Spieler haben ein Essen verloren.";
        News news = new News(getCurrentTime(), message);
        NEWS.add(news);
    }
}
