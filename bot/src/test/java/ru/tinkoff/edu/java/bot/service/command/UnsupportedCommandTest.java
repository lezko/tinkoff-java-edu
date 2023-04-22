package ru.tinkoff.edu.java.bot.service.command;

import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.tinkoff.edu.java.bot.service.MessageProcessor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UnsupportedCommandTest {
    @Autowired
    private CommandsInitializer initializer;

    @Mock
    private Update update;
    @Mock
    private Message msg;
    @Mock
    private Chat chat;

    @Test
    void checkUnsupported() {
        MessageProcessor processor = new MessageProcessor(initializer.commands());

        String unsupportedCommand = "/create";

        when(update.message()).thenReturn(msg);
        when(msg.text()).thenReturn(unsupportedCommand);
        when(msg.chat()).thenReturn(chat);
        when(chat.id()).thenReturn(0L);

        SendMessage message = processor.process(update);

        String expected = "Command not supported";
        assertEquals(expected, message.getParameters().get("text").toString());
    }
}
