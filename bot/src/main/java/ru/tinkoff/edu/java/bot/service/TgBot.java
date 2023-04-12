package ru.tinkoff.edu.java.bot.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tinkoff.edu.java.bot.client.ScrapperClient;
import ru.tinkoff.edu.java.bot.service.command.*;

import java.util.Arrays;
import java.util.List;

@Component
public class TgBot implements Bot {

    private final TelegramBot bot;
    private final List<Command> commands;

    @Autowired
    private ScrapperClient client;

    public TgBot(String botToken) {
        bot = new TelegramBot(botToken);
        commands = createCommands();
        start();
    }

    private List<Command> createCommands() {
        HelpCommand helpCommand = new HelpCommand();
        List<Command> commandList = Arrays.asList(
            new StartCommand(),
            helpCommand,
            new TrackCommand(),
            new UntrackCommand(),
            new ListCommand()
        );
        helpCommand.setCommands(commandList);
        return commandList;
    }

    @Override
    public <T extends BaseRequest<T, R>, R extends BaseResponse> void execute(BaseRequest<T, R> request) {

    }

    @Override
    public int process(List<Update> updates) {
        return 0;
    }

    @Override
    public void start() {
        bot.setUpdatesListener(new UserMessageProcessor() {
            @Override
            public int process(List<Update> list) {
                for (Update update : list) {
                    SendMessage req = new SendMessage(
                        update.message().chat().id(),
                        "Command not supported"
                    );
                    System.out.println(update.message().text());
                    for (Command c : commands) {
                        if (c.supports(update)) {
                            req = c.handle(update);
                            break;
                        }
                    }
                    bot.execute(req);
                }
                return UpdatesListener.CONFIRMED_UPDATES_ALL;
            }

            @Override
            public List<? extends Command> commands() {
                return null;
            }

            @Override
            public SendMessage process(Update update) {
                return null;
            }
        });
    }

    @Override
    public void close() {
        bot.removeGetUpdatesListener();
    }
}
