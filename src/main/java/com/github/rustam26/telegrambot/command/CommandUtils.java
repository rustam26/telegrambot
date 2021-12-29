package com.github.rustam26.telegrambot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Utils class for Commands.
 */
public class CommandUtils {


    public static String getChatId(Update update) {
        return update.getMessage().getChatId().toString();
    }


    public static String getMessage(Update update) {
        return update.getMessage().getText();
    }
}