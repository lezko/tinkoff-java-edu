package ru.tinkoff.edu.java.scrapper.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import ru.tinkoff.edu.java.scrapper.client.dto.LinkUpdateRequest;

@Component
public class BotClient {
    @Autowired
    private WebClient webClient;

    public void updateLink(LinkUpdateRequest request) {
        String path = "/updates";
        webClient.post()
            .uri(path)
            .body(BodyInserters.fromValue(request))
            .retrieve()
            .toBodilessEntity()
            .block();
    }
}
