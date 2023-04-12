package ru.tinkoff.edu.java.bot.service.command;

import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.tinkoff.edu.java.bot.client.ScrapperClient;
import ru.tinkoff.edu.java.bot.client.dto.response.LinkResponse;
import ru.tinkoff.edu.java.bot.client.dto.response.ListLinksResponse;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ListCommandTest {
    @Test
    void checkEmptyList() {
        long mockTgChatId = 0;
        ScrapperClient client = mock(ScrapperClient.class);
        Update update = mock(Update.class);
        Message msg = mock(Message.class);
        Chat chat = mock(Chat.class);

        when(client.fetchLinks(mockTgChatId)).thenReturn(new ListLinksResponse());

        when(update.message()).thenReturn(msg);
        when(msg.chat()).thenReturn(chat);
        when(chat.id()).thenReturn(mockTgChatId);

        ListCommand listCommand = new ListCommand(client);
        SendMessage message = listCommand.handle(update);

        String expected = "No links are currently being tracked";
        assertEquals(expected, message.getParameters().get("text").toString());
    }

    @Test
    void checkFormatting() {
        long mockTgChatId = 0;
        ScrapperClient client = mock(ScrapperClient.class);
        Update update = mock(Update.class);
        Message msg = mock(Message.class);
        Chat chat = mock(Chat.class);

        List<String> urls = Arrays.asList(
            "https://github.com/user/repo1",
            "https://github.com/user/repo2",
            "https://github.com/user/repo3"
        );
        ListLinksResponse response = new ListLinksResponse();
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            sb.append(url).append("\n");
            response.getLinks().add(new LinkResponse(0, URI.create(url)));
        }
        String expected = sb.toString();

        when(client.fetchLinks(mockTgChatId)).thenReturn(response);

        when(update.message()).thenReturn(msg);
        when(msg.chat()).thenReturn(chat);
        when(chat.id()).thenReturn(mockTgChatId);

        ListCommand listCommand = new ListCommand(client);
        SendMessage message = listCommand.handle(update);

        assertEquals(expected, message.getParameters().get("text").toString());
    }
}
