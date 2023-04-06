package ru.tinkoff.edu.java.bot.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tinkoff.edu.java.bot.service.command.Command;

import java.util.List;

@Component
public class TgBot implements Bot {

    private final TelegramBot bot;

    public TgBot(String botToken, List<Command> commands) {
        bot = new TelegramBot(botToken);
        System.out.println(commands.size());
        bot.setUpdatesListener(new UserMessageProcessor() {
            @Override
            public int process(List<Update> list) {
                for (Update update : list) {
//                    SendMessage req = new SendMessage(
//                        update.message().chat().id(),
//                        "Command not supported"
//                    );
                    for (Command c : commands) {
                        System.out.println(update.message().text());
                        if (c.supports(update)) {
                            System.out.println(update.message().text());
                            SendMessage req = c.handle(update);
                            bot.execute(req);

                            break;
                        }
                    }
//                    bot.execute(req);
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
    public <T extends BaseRequest<T, R>, R extends BaseResponse> void execute(BaseRequest<T, R> request) {

    }

    @Override
    public int process(List<Update> updates) {
        return 0;
    }

    @Override
    public void start() {

    }

    @Override
    public void close() {

    }
}
