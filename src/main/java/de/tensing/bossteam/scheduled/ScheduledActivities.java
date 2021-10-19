package de.tensing.bossteam.scheduled;

import de.tensing.bossteam.entities.Player;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

import static de.tensing.bossteam.entities.Game.*;
import static de.tensing.bossteam.entities.Settings.*;

@Component
public class ScheduledActivities {

    private static final int SCHEDULER_DELAY = 5000;
    private int secondsLeftFood = FOOD_REMOVAL_INTERVAL;
    private int secondsLeftDay = DAY_LENGTH;
    private int secondsLeftNight = NIGHT_LENGTH;

    //Execute every 5 seconds
    @Scheduled(fixedDelay=SCHEDULER_DELAY)
    public void executeScheduler() {
        if (GAME_STARTED == true) {
            // REMOVE FOOD
            if (!(secondsLeftFood > 0)) {
                secondsLeftFood = FOOD_REMOVAL_INTERVAL;
                removeFood();
            } else {
                secondsLeftFood -= SCHEDULER_DELAY/1000;
            }

            // COMPUTE DAY/NIGHT
            if (IS_DAY) {
                if (!(secondsLeftDay > 0)) {
                    secondsLeftDay = DAY_LENGTH;
                    IS_DAY = false;
                } else {
                    secondsLeftDay -= SCHEDULER_DELAY/1000;
                }
            } else {
                if (!(secondsLeftNight > 0)) {
                    secondsLeftNight = NIGHT_LENGTH;
                    IS_DAY = true;
                } else {
                    secondsLeftNight -= SCHEDULER_DELAY/1000;
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
            }
        }
    }
}
