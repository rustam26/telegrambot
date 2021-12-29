package com.github.rustam26.telegrambot.javarushclient.dto;


import lombok.*;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;


@Builder
@Getter
public class GroupRequestArgs {

    private final String query;
    private final GroupInfoType type;
    private final GroupFilter filter;

    private final Integer offset;

    private final Integer limit;


    public Map<String ,Object> populateQueries(){
        Map <String, Object>queries = new HashMap<>();

        if (nonNull(query)){
            queries.put("query", query);
        }
        if (nonNull(type)){
            queries.put("type", type);
        }
        if (nonNull(filter)){
            queries.put("filter", filter);
        }
        if (nonNull(offset)){
            queries.put("offset", offset);
        }
        if (nonNull(limit)){
            queries.put("limit", limit);
        }
        return queries;
    }
}
