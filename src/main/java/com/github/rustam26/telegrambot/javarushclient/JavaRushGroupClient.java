package com.github.rustam26.telegrambot.javarushclient;

import com.github.rustam26.telegrambot.javarushclient.dto.GroupsCountRequestArgs;
import com.github.rustam26.telegrambot.javarushclient.dto.GroupDiscussionInfo;
import com.github.rustam26.telegrambot.javarushclient.dto.GroupInfo;
import com.github.rustam26.telegrambot.javarushclient.dto.GroupRequestArgs;

import java.util.List;

public interface JavaRushGroupClient {

    List<GroupInfo> getGroupList (GroupRequestArgs requestArgs);


    List<GroupDiscussionInfo> getGroupDiscussionList(GroupRequestArgs requestArgs);

    Integer getGroupCount (GroupsCountRequestArgs countRequestArgs);

    GroupDiscussionInfo getGroupById(Integer id);

    Integer findLastPostId(Integer groupSub);
}
