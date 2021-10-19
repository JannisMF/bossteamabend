package de.tensing.bossteam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BossteamApplication {

    public static void main(String[] args) {
        SpringApplication.run(BossteamApplication.class, args);
    }
}
