package ru.tinkoff.edu.java.bot.service.command;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import ru.tinkoff.edu.java.bot.client.ScrapperClient;

public class TrackCommand implements Command {
    private final ScrapperClient client;

    public TrackCommand(ScrapperClient client) {
        this.client = client;
    }

    @Override
    public String command() {
        return "/track";
    }

    @Override
    public String description() {
        return "Start tracking link";
    }

    @Override
    public SendMessage handle(Update update) {
        long chatId = update.message().chat().id();
        String message = "Started tracking new link";
        return new SendMessage(chatId, message);
    }
}
