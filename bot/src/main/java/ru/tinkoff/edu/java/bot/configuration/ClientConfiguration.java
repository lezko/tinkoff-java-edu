package ru.tinkoff.edu.java.bot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ClientConfiguration {
    private static final String DEFAULT_URL = "http://localhost:8002";

    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl(DEFAULT_URL).build();
    }
}
