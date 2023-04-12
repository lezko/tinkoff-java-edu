package ru.tinkoff.edu.java.bot.service.command;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import ru.tinkoff.edu.java.bot.client.ScrapperClient;
import ru.tinkoff.edu.java.bot.client.dto.response.ListLinksResponse;

public class ListCommand implements Command {
    private final ScrapperClient client;

    public ListCommand(ScrapperClient client) {
        this.client = client;
    }

    @Override
    public String command() {
        return "/list";
    }

    @Override
    public String description() {
        return "Show tracking links";
    }

    @Override
    public SendMessage handle(Update update) {
        long chatId = update.message().chat().id();
        ListLinksResponse res = client.fetchLinks(chatId);
        String message;
        if (res.getLinks().isEmpty()) {
            message = "No links are currently being tracked";
        } else {
            message = res.toString();
        }
        return new SendMessage(chatId, message);
    }
}

