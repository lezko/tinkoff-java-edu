package ru.tinkoff.edu.java.bot.service.command;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import ru.tinkoff.edu.java.bot.client.ScrapperClient;

public class StartCommand implements Command {
    private final ScrapperClient client;

    public StartCommand(ScrapperClient client) {
        this.client = client;
    }

    @Override
    public String command() {
        return "/start";
    }

    @Override
    public String description() {
        return "Register new user";
    }

    @Override
    public SendMessage handle(Update update) {
        long chatId = update.message().chat().id();
        String message = "New user has been registered!";
        return new SendMessage(chatId, message);
    }
}
