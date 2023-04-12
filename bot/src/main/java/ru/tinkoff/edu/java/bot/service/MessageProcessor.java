package ru.tinkoff.edu.java.bot.service;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import ru.tinkoff.edu.java.bot.service.command.Command;

import java.util.List;

public class MessageProcessor implements UserMessageProcessor {
    private final List<Command> commands;

    public MessageProcessor(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public SendMessage process(Update update) {
        SendMessage req = new SendMessage(
            update.message().chat().id(),
            "Command not supported"
        );
        for (Command c : commands) {
            if (c.supports(update)) {
                req = c.handle(update);
                break;
            }
        }
        return req;
    }
}
