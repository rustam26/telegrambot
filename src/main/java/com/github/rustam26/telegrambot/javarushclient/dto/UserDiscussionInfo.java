package com.github.rustam26.telegrambot.javarushclient.dto;


import lombok.Data;

@Data
public class UserDiscussionInfo {

    private Boolean isBookMarked;
    private Integer lastTime;
    private Integer newCommentsCount;
}
