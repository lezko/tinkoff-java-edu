package ru.tinkoff.edu.java.bot.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.tinkoff.edu.java.bot.client.dto.request.AddLinkRequest;
import ru.tinkoff.edu.java.bot.client.dto.request.RemoveLinkRequest;
import ru.tinkoff.edu.java.bot.client.dto.response.ListLinksResponse;
import ru.tinkoff.edu.java.bot.service.exception.LinkNotFoundException;

import java.util.Objects;


@Component
public class ScrapperClient {
    @Autowired
    private WebClient webClient;

    public void addChat(long tgChatId) {
        String path = "/links/" + tgChatId;
        webClient.post()
            .uri(path)
            .retrieve();
    }

    public void deleteChat(long tgChatId) {
        String path = "/link/" + tgChatId;
        webClient.delete()
            .uri(path)
            .retrieve();
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
            // todo remove
//            .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> {
//                System.out.println("error");
//                if (clientResponse.statusCode().equals(HttpStatusCode.valueOf(404))) {
//                    return Mono.error(LinkNotFoundException::new);
//                }
//                return Mono.error(RuntimeException::new);
//            });
    }

    public void stopTrackingLink(long tgChatId, String link) {
        String path = "/links";
        RemoveLinkRequest request = new RemoveLinkRequest(link);
        webClient.method(HttpMethod.DELETE)
            .uri(path)
            .header("Tg-Chat-Id", String.valueOf(tgChatId))
            .body(BodyInserters.fromValue(request))
            .retrieve()
            .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> {
                System.out.println("error");
                if (clientResponse.statusCode().equals(HttpStatusCode.valueOf(404))) {
                    return Mono.error(LinkNotFoundException::new);
                }
                return Mono.error(RuntimeException::new);
            });
    }
}
