package com.github.rustam26.telegrambot;

import com.github.rustam26.telegrambot.command.Command;
import com.github.rustam26.telegrambot.command.NoCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.rustam26.telegrambot.command.CommandName.NO;
import static com.github.rustam26.telegrambot.command.NoCommand.NO_MESSAGE;

@DisplayName("Unit-level testing for NoCommand")
public class NoCommandTest extends AbstractCommandTest {


    @Override
    String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NO_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendBotMessageService);
    }
}
