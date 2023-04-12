package ru.tinkoff.edu.java.bot.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SetMyCommands;
import com.pengrad.telegrambot.response.BaseResponse;
import org.springframework.stereotype.Service;
import ru.tinkoff.edu.java.bot.service.command.CommandsInitializer;

import java.util.List;

@Service
public class TgBot implements Bot {

    private final TelegramBot bot;
    private final MessageProcessor processor;

    public TgBot(String botToken, CommandsInitializer initializer) {
        bot = new TelegramBot(botToken);
        bot.execute(new SetMyCommands(
            initializer
                .commands()
                .stream()
                .map(c -> new BotCommand(c.command(), c.description()))
                .toArray(BotCommand[]::new))
        );
        processor = new MessageProcessor(initializer.commands());
        start();
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
        bot.setUpdatesListener(list -> {
            for (Update update : list) {
                bot.execute(processor.process(update));
            }
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }

    @Override
    public void close() {
        bot.removeGetUpdatesListener();
    }
}
