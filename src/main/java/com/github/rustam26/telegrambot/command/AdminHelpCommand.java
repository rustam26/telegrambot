package com.github.rustam26.telegrambot.command;

import com.github.rustam26.telegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.rustam26.telegrambot.command.CommandName.STAT;
import static java.lang.String.format;

public class AdminHelpCommand implements Command{

    public static final String ADMIN_HELP_MESSAGE = format("✨<b>Доступные команды админа</b>✨\n\n"
                    + "<b>Получить статистику</b>\n"
                    + "%s - статистика бота\n",
            STAT.getCommandName());

    private final SendBotMessageService sendBotMessageService;

    public AdminHelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }


    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId(), ADMIN_HELP_MESSAGE);
    }
}
