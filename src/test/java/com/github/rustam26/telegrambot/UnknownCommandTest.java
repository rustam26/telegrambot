package com.github.rustam26.telegrambot;

import com.github.rustam26.telegrambot.command.Command;
import com.github.rustam26.telegrambot.command.UnknownCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.rustam26.telegrambot.command.UnknownCommand.UNKNOWN_MESSAGE;

@DisplayName("Unit-level testing for UnknownCommand")

public class UnknownCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return "/fdgdfgdfgdbd";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }
}
