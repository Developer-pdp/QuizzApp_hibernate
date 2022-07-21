package uz.team_dev.back.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Level {
    EASY("oson","легкий","easy"),
    MEDIUM("o`rtacha","средний","medium"),
    HARD("qiyin","жесткий","hard");

    private final String uz;
    private final String ru;
    private final String en;
}
