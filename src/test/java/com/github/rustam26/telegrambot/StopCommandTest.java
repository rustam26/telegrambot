package com.github.rustam26.telegrambot;


import com.github.rustam26.telegrambot.command.Command;
import com.github.rustam26.telegrambot.command.StopCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.rustam26.telegrambot.command.CommandName.STOP;
import static com.github.rustam26.telegrambot.command.StopCommand.STOP_MESSAGE;

@DisplayName("Unit-level testing for StopCommand")
public class StopCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService);
    }
}

