package ru.tinkoff.edu.java.bot.client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import ru.tinkoff.edu.java.bot.client.dto.request.AddLinkRequest;
import ru.tinkoff.edu.java.bot.client.dto.request.RemoveLinkRequest;
import ru.tinkoff.edu.java.bot.client.dto.response.ListLinksResponse;

import java.util.Objects;

@RequiredArgsConstructor
public class ScrapperClient {
    private static final String DEFAULT_URL = "http://localhost:8002";

    private final WebClient webClient;

    public static ScrapperClient create() {
        return create(DEFAULT_URL);
    }

    public static ScrapperClient create(String baseUrl) {
        WebClient webClient = WebClient.builder().baseUrl(baseUrl).build();
        return new ScrapperClient(webClient);
    }

    public void addChat(long tgChatId) {
        String path = "/links/" + String.valueOf(tgChatId);
        webClient.post()
            .uri(path)
            .retrieve();
    }

    public void deleteChat(long tgChatId) {
        String path = "/link/" + String.valueOf(tgChatId);
        webClient.delete()
            .uri(path)
            .retrieve();
            // todo exception handling
    }

    public ListLinksResponse fetchLinks(long tgChatId) {
        String path = "/links";
        ListLinksResponse response = webClient.get()
            .uri(path)
            .header("Tg-Chat-Id", String.valueOf(tgChatId))
            .retrieve()
            .bodyToMono(ListLinksResponse.class)
            .block();
        Objects.requireNonNull(response);
        return response;
    }

    public void startTrackingLink(long tgChatId, String link) {
        String path = "/links";
        AddLinkRequest request = new AddLinkRequest(link);
        webClient.post()
            .uri(path)
            .header("Tg-Chat-Id", String.valueOf(tgChatId))
            .body(BodyInserters.fromValue(request))
            .retrieve();
    }

    public void stopTrackingLink(long tgChatId, String link) {
        String path = "/links";
        RemoveLinkRequest request = new RemoveLinkRequest(link);
        webClient.method(HttpMethod.DELETE)
            .uri(path)
            .header("Tg-Chat-Id", String.valueOf(tgChatId))
            .body(BodyInserters.fromValue(request))
            .retrieve();
            // todo exception handling
    }
}
