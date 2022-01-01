package com.github.rustam26.telegrambot.command;

import com.github.rustam26.telegrambot.command.annotation.AdminCommand;
import com.github.rustam26.telegrambot.javarushclient.JavaRushGroupClient;
import com.github.rustam26.telegrambot.service.GroupSubService;
import com.github.rustam26.telegrambot.service.SendBotMessageService;
import com.github.rustam26.telegrambot.service.StatisticsService;
import com.github.rustam26.telegrambot.service.TelegramUserService;
import com.google.common.collect.ImmutableMap;

import java.util.List;

import static com.github.rustam26.telegrambot.command.CommandName.*;
import static java.util.Objects.nonNull;


/**
 * Container of the {@link Command}s, which are using for handling telegram commands.
 */

public class CommandContainer {


    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;
    private List<String> admins;

    public CommandContainer(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService,
                            JavaRushGroupClient javaRushGroupClient, GroupSubService groupSubService,
                            List<String> admins, StatisticsService statisticsService) {
        this.admins = admins;

        commandMap = ImmutableMap.<String , Command> builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService, telegramUserService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService, telegramUserService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(NO.getCommandName(), new NoCommand(sendBotMessageService))
                .put(STAT.getCommandName(),new StatCommand(sendBotMessageService,statisticsService))
                .put(ADD_GROUP_SUB.getCommandName(), new AddGroupSubCommand(sendBotMessageService, javaRushGroupClient, groupSubService))
                .put(LIST_GROUP_SUB.getCommandName(), new ListGroupSubCommand(sendBotMessageService, telegramUserService))
                .put(DELETE_GROUP_SUB.getCommandName(), new DeleteGroupSubCommand(sendBotMessageService, groupSubService,telegramUserService))
                .put(ADMIN_HELP.getCommandName(), new AdminHelpCommand(sendBotMessageService))
                .build();

        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public  Command findCommand(String commandIdentifier, String username){

        Command orDefault = commandMap.getOrDefault(commandIdentifier, unknownCommand);
        if (isAdminCommand(orDefault)){
            if (admins.contains(username)){
                return orDefault;
            }else {
                return unknownCommand;
            }
        }
        return orDefault;
    }

    private boolean isAdminCommand(Command command){
        return nonNull(command.getClass().getAnnotation(AdminCommand.class));
    }
}
