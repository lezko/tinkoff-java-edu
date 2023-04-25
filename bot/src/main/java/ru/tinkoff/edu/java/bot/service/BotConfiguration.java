package ru.tinkoff.edu.java.bot.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import ru.tinkoff.edu.java.bot.configuration.ApplicationConfig;

@Configuration
public class BotConfiguration {
    private final ApplicationContext ctx;

    public BotConfiguration(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    @Bean
    public String botToken() {
        ApplicationConfig config = ctx.getBean(ApplicationConfig.class);
        return config.botToken();
    }
}
