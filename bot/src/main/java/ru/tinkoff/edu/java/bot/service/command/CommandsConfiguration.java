package ru.tinkoff.edu.java.bot.service.command;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;
import java.util.List;

@Configuration
public class CommandsConfiguration {
    @Bean
    public List<Command> commands() {
        List<Command> list = List.of(
            new StartCommand(),
            new HelpCommand(),
            new TrackCommand(),
            new UntrackCommand(),
            new ListCommand()
        );
        return list;
    }
}
