package com.github.rustam26.telegrambot.javarushclient.dto;

import lombok.Data;

@Data
public class MeGroupInfo {

    private MeGroupInfoStatus status;
    private Integer userGroupId;

}
