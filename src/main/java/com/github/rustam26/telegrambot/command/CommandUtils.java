package com.github.rustam26.telegrambot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Utils class for Commands.
 */
public class CommandUtils {


    public static Long getChatId(Update update) {
        return update.getMessage().getChatId();
    }


    public static String getMessage(Update update) {
        return update.getMessage().getText();
    }
}