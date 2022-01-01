package com.github.rustam26.telegrambot.command;

import com.github.rustam26.telegrambot.repository.entity.TelegramUser;
import com.github.rustam26.telegrambot.service.SendBotMessageService;
import com.github.rustam26.telegrambot.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Stop {@link Command}
 */
public class StopCommand implements Command{

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public static final String STOP_MESSAGE = "Деактивировал все твои подписки \uD83D\uDE1F.\n" +
            "Ты всегда можешь вернуться нажав /start";


    public StopCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId(), STOP_MESSAGE);
        telegramUserService.findByChatId(update.getMessage().getChatId()).ifPresent
                (it ->{
                    it.setActive(false);
                    telegramUserService.save(it);
                });
    }
}
