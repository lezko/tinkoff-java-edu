package ru.tinkoff.edu.java.scrapper.client;

import org.springframework.web.reactive.function.client.WebClient;
import ru.tinkoff.edu.java.scrapper.client.dto.GitHubResponse;
import ru.tinkoff.edu.java.scrapper.client.dto.StackOverflowListResponse;
import ru.tinkoff.edu.java.scrapper.client.dto.StackOverflowResponse;

import java.util.Objects;

public class StackOverflowClient {
    private static final String DEFAULT_URL = "https://api.stackexchange.com/2.3";

    private final WebClient webClient;

    public static StackOverflowClient create() {
        return create(DEFAULT_URL);
    }

    public static StackOverflowClient create(String baseUrl) {
        WebClient webClient = WebClient.builder().baseUrl(baseUrl).build();
        return new StackOverflowClient(webClient);
    }

    public StackOverflowClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public StackOverflowResponse fetchQuestion(long questionId) {
        String path = "/questions/" + questionId + "?site=stackoverflow";
        StackOverflowListResponse response = webClient.get()
            .uri(path)
            .retrieve()
            .bodyToMono(StackOverflowListResponse.class)
            .block();
        Objects.requireNonNull(response);
        return response.getItems().get(0);
    }
}
