package ru.tinkoff.edu.java.bot.client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.tinkoff.edu.java.bot.client.dto.request.AddLinkRequest;
import ru.tinkoff.edu.java.bot.client.dto.request.RemoveLinkRequest;
import ru.tinkoff.edu.java.bot.client.dto.response.ListLinksResponse;
import ru.tinkoff.edu.java.bot.service.exception.TgChatNotFoundException;

import java.util.Objects;


@Component
@RequiredArgsConstructor
public class ScrapperClient {
    private final WebClient webClient;

    public void addChat(long tgChatId) {
        String path = "/tg-chat/" + tgChatId;
        webClient.post()
            .uri(path)
            .retrieve()
            .toBodilessEntity()
            .block();
    }

    public void deleteChat(long tgChatId) {
        String path = "/tg-chat/" + tgChatId;
        webClient.delete()
            .uri(path)
            .retrieve()
            .onStatus(status -> status.value() == 404, clientResponse -> Mono.error(TgChatNotFoundException::new))
            .toBodilessEntity()
            .block();
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
            .retrieve()
            .toBodilessEntity()
            .block();
    }

    public void stopTrackingLink(long tgChatId, String link) {
        String path = "/links";
        RemoveLinkRequest request = new RemoveLinkRequest(link);
        webClient.method(HttpMethod.DELETE)
            .uri(path)
            .header("Tg-Chat-Id", String.valueOf(tgChatId))
            .body(BodyInserters.fromValue(request))
            .retrieve()
            .onStatus(status -> status.value() == 404, clientResponse -> Mono.error(TgChatNotFoundException::new))
            .toBodilessEntity()
            .block();
    }
}
