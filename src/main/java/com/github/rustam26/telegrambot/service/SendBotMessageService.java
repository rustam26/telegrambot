package com.github.rustam26.telegrambot.service;

import java.util.List;

/**
 *  Service for sending messages via telegram-bot.
 */


public interface SendBotMessageService {

    /**
     * Send message via telegram bot.
     *
     * @param chatId provided chatId in which messages would be sent.
     * @param message provided message to by sent.
     */

    void sendMessage(Long chatId, String message);
    void sendMessage(Long chatId, List<String> messages);

}
