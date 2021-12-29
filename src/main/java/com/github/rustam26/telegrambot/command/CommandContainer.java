package com.github.rustam26.telegrambot.command;

import com.github.rustam26.telegrambot.javarushclient.JavaRushGroupClient;
import com.github.rustam26.telegrambot.service.GroupSubService;
import com.github.rustam26.telegrambot.service.SendBotMessageService;
import com.github.rustam26.telegrambot.service.TelegramUserService;
import com.google.common.collect.ImmutableMap;

import static com.github.rustam26.telegrambot.command.CommandName.*;


/**
 * Container of the {@link Command}s, which are using for handling telegram commands.
 */

public class CommandContainer {


    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService,
                            JavaRushGroupClient javaRushGroupClient, GroupSubService groupSubService) {


        commandMap = ImmutableMap.<String , Command> builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService, telegramUserService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService, telegramUserService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(NO.getCommandName(), new NoCommand(sendBotMessageService))
                .put(STAT.getCommandName(),new StatCommand(sendBotMessageService, telegramUserService))
                .put(ADD_GROUP_SUB.getCommandName(), new AddGroupSubCommand(sendBotMessageService, javaRushGroupClient, groupSubService))
                .put(LIST_GROUP_SUB.getCommandName(), new ListGroupSubCommand(sendBotMessageService, telegramUserService))

                .put(DELETE_GROUP_SUB.getCommandName(), new DeleteGroupSubCommand(sendBotMessageService, groupSubService,telegramUserService))

                .build();

        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public  Command retrieveCommand(String commandIdentifier){
        return commandMap.getOrDefault(commandIdentifier,unknownCommand);
    }
}
