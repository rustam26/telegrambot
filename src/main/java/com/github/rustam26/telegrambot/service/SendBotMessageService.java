package com.github.rustam26.telegrambot.service;

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

    void sendMessage(String chatId, String message);

}
