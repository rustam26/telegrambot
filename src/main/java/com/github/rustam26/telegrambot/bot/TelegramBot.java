package com.github.rustam26.telegrambot.bot;

import com.github.rustam26.telegrambot.command.CommandContainer;
import com.github.rustam26.telegrambot.javarushclient.JavaRushGroupClient;
import com.github.rustam26.telegrambot.service.GroupSubService;
import com.github.rustam26.telegrambot.service.SendBotMessageServiceImpl;
import com.github.rustam26.telegrambot.service.StatisticsService;
import com.github.rustam26.telegrambot.service.TelegramUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;


import java.util.List;

import static com.github.rustam26.telegrambot.command.CommandName.NO;

@Component
public class TelegramBot extends TelegramLongPollingBot {
    public static String COMMAND_PREFIX = "/";

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    private final CommandContainer commandContainer;

    @Autowired
    public TelegramBot(TelegramUserService telegramUserService, JavaRushGroupClient javaRushGroupClient,
                       GroupSubService groupSubService, @Value("#{'${bot.admins}'.split(',')}") List<String> admins, StatisticsService statisticsService) {
        this.commandContainer =
                new CommandContainer(new SendBotMessageServiceImpl(this),
                        telegramUserService,javaRushGroupClient,groupSubService, admins, statisticsService);

    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()){
            String message =  update.getMessage().getText().trim();
            String username = update.getMessage().getFrom().getUserName();
            if (message.startsWith(COMMAND_PREFIX)){
                String commandIdentifier = message.split(" ")[0].toLowerCase();
                commandContainer.findCommand(commandIdentifier, username).execute(update);
            } else {
                commandContainer.findCommand(NO.getCommandName(), username).execute(update);
            }

        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }


}
