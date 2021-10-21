package de.tensing.bossteam.news;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@AllArgsConstructor
@Data
public class News {

    private String time;

    private String message;
}
