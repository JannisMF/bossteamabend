package de.tensing.bossteam.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class News {

    private String time;

    private String message;
}
