package ru.tinkoff.edu.java.bot.service;

import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import ru.tinkoff.edu.java.bot.service.command.Command;

import java.util.List;

public interface UserMessageProcessor extends UpdatesListener {
    List<? extends Command> commands();

    SendMessage process(Update update);
}
