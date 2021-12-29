package com.github.rustam26.telegrambot.command;

import com.github.rustam26.telegrambot.command.Command;
import com.github.rustam26.telegrambot.command.CommandContainer;
import com.github.rustam26.telegrambot.command.CommandName;
import com.github.rustam26.telegrambot.command.UnknownCommand;

import com.github.rustam26.telegrambot.javarushclient.JavaRushGroupClient;
import com.github.rustam26.telegrambot.service.GroupSubService;

import com.github.rustam26.telegrambot.service.SendBotMessageService;
import com.github.rustam26.telegrambot.service.TelegramUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

@DisplayName("Unit-level testing for CommandContainer")

public class CommandContainerTest {

    private CommandContainer commandContainer;

    @BeforeEach
    public void init(){
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        TelegramUserService telegramUserService = Mockito.mock(TelegramUserService.class);
        JavaRushGroupClient javaRushGroupClient = Mockito.mock(JavaRushGroupClient.class);
        GroupSubService groupSubService = Mockito.mock(GroupSubService.class);
        commandContainer = new CommandContainer(sendBotMessageService, telegramUserService, javaRushGroupClient,groupSubService );

    }

    @Test
    public void shouldGetAllTheExistingCommands(){
        Arrays.stream(CommandName.values())
                .forEach(commandName -> {
                    Command command = commandContainer.retrieveCommand(commandName.getCommandName());
                    Assertions.assertNotEquals(UnknownCommand.class, command.getClass());
                });
    }

    @Test
    public void shouldReturnUnknownCommand(){
        String unknownCommand = "/lfdglkfg";

        Command command = commandContainer.retrieveCommand(unknownCommand);

        Assertions.assertEquals(UnknownCommand.class , command.getClass());
    }



}
