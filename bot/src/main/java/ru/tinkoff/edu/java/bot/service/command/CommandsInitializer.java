package ru.tinkoff.edu.java.bot.service.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CommandsInitializer {
    private List<Command> commands;

    private final StartCommand startCommand;
    private final HelpCommand helpCommand;
    private final TrackCommand trackCommand;
    private final UntrackCommand untrackCommand;
    private final ListCommand listCommand;

    public List<Command> commands() {
        if (commands == null) {
            commands = Arrays.asList(
                startCommand,
                helpCommand,
                trackCommand,
                untrackCommand,
                listCommand
            );
            helpCommand.setCommands(commands);
        }
        return commands;
    }
}
