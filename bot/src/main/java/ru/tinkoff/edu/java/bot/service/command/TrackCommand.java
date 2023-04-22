package ru.tinkoff.edu.java.bot.service.command;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.tinkoff.edu.java.bot.client.ScrapperClient;

@Component
@RequiredArgsConstructor
public class TrackCommand implements Command {
    private final ScrapperClient client;

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
