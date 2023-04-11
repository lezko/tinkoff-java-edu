package ru.tinkoff.edu.java.bot.service.command;

import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HelpCommand implements Command {

    private List<Command> commands;
    @Autowired
    @Lazy
    private CommandsConfiguration config;

    private void setupCommands() {
        commands = List.of(
            new StartCommand(),
            new HelpCommand(),
            new TrackCommand(),
            new UntrackCommand(),
            new ListCommand()
        );
    }

    @Override
    public String command() {
        return "/help";
    }

    @Override
    public String description() {
        return "Show all commands";
    }

    @Override
    public SendMessage handle(Update update) {
//        if (commands == null) {
//            setupCommands();
//        }

        long chatId = update.message().chat().id();
        StringBuilder s = new StringBuilder();
        for (Command c : config.commands()) {
            s.append(c.command()).append(" - ").append(c.description()).append("\n");
        }
        return new SendMessage(chatId, s.toString());
    }
}
