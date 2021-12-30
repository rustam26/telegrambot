package com.github.rustam26.telegrambot.command;

import com.github.rustam26.telegrambot.bot.TelegramBot;
import com.github.rustam26.telegrambot.service.SendBotMessageService;
import com.github.rustam26.telegrambot.service.SendBotMessageServiceImpl;
import com.github.rustam26.telegrambot.service.TelegramUserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


/**
 * Abstract class for testing {@link Command}s.
 */

 abstract class AbstractCommandTest {

    protected TelegramBot telegramBot = Mockito.mock(TelegramBot.class);
    protected SendBotMessageService sendBotMessageService = new SendBotMessageServiceImpl(telegramBot);
    protected TelegramUserService telegramUserService = Mockito.mock(TelegramUserService.class);

    abstract String getCommandName();

    abstract  String getCommandMessage();

    abstract Command getCommand();

    public static Update prepareUpdate(String chatId, String commandName) {
        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(Long.valueOf(chatId));
        Mockito.when(message.getText()).thenReturn(commandName);
        update.setMessage(message);
        return update;
    }

    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException{
        String chatId = "1234567824356";

        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(Long.valueOf(chatId));
        Mockito.when(message.getText()).thenReturn(getCommandName());
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(getCommandMessage());
        sendMessage.enableHtml(true);

        getCommand().execute(update);

        Mockito.verify(telegramBot).execute(sendMessage);

    }
}
