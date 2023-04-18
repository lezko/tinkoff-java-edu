package ru.tinkoff.edu.java.scrapper.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import ru.tinkoff.edu.java.scrapper.client.GitHubClient;
import ru.tinkoff.edu.java.scrapper.client.StackOverflowClient;

@Configuration
public class ClientConfiguration {
    private static final String DEFAULT_URL = "http://localhost:8001";

    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl(DEFAULT_URL).build();
    }

    @Bean
    public GitHubClient gitHubClient() {
        return GitHubClient.create();
    }

    @Bean
    public StackOverflowClient stackOverflowClient() {
        return StackOverflowClient.create();
    }
}
