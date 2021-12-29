package com.github.rustam26.telegrambot.service;

import com.github.rustam26.telegrambot.javarushclient.dto.GroupDiscussionInfo;
import com.github.rustam26.telegrambot.repository.entity.GroupSub;

public interface GroupSubService {

    GroupSub save (String chatId, GroupDiscussionInfo groupDiscussionInfo);
}
