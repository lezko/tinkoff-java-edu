package ru.tinkoff.edu.java.scrapper.client;

import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;
import ru.tinkoff.edu.java.scrapper.client.dto.GitHubResponse;

import java.util.Objects;

@RequiredArgsConstructor
public class GitHubClient {
    private static final String DEFAULT_URL = "https://api.github.com";

    private final WebClient webClient;

    public static GitHubClient create() {
        return create(DEFAULT_URL);
    }

    public static GitHubClient create(String baseUrl) {
        WebClient webClient = WebClient.builder().baseUrl(baseUrl).build();
        return new GitHubClient(webClient);
    }

    public GitHubResponse fetchRepo(String user, String repo) {
        String path = "/repos/" + user + "/" + repo;
        GitHubResponse response = webClient.get()
            .uri(path)
            .retrieve()
            .bodyToMono(GitHubResponse.class)
            .block();
        Objects.requireNonNull(response);
        return response;
    }
}
