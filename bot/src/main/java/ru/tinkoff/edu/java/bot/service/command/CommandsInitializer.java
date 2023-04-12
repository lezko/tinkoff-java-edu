package ru.tinkoff.edu.java.bot.service.command;

import org.springframework.stereotype.Component;
import ru.tinkoff.edu.java.bot.client.ScrapperClient;

import java.util.Arrays;
import java.util.List;

@Component
public class CommandsInitializer {
    private final List<Command> commands;

    public CommandsInitializer(ScrapperClient client) {
        HelpCommand helpCommand = new HelpCommand();
        List<Command> commandList = Arrays.asList(
            new StartCommand(client),
            helpCommand,
            new TrackCommand(client),
            new UntrackCommand(client),
            new ListCommand(client)
        );
        helpCommand.setCommands(commandList);
        commands = commandList;
    }

    public List<Command> commands() {
        return commands;
    }
}
