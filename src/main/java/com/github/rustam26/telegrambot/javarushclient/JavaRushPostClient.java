package com.github.rustam26.telegrambot.javarushclient;

import com.github.rustam26.telegrambot.javarushclient.dto.PostInfo;

import java.util.List;

public interface JavaRushPostClient {


    List<PostInfo> findNewPosts(Integer groupId, Integer lastPostId);
}
