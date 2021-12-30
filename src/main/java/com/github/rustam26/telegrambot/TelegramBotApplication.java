package com.github.rustam26.telegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Telegram bot.
 */
@EnableScheduling
@SpringBootApplication
public class 	TelegramBotApplication {

	public static void main(String[] args) {
 		SpringApplication.run(TelegramBotApplication.class, args);
	}


}
