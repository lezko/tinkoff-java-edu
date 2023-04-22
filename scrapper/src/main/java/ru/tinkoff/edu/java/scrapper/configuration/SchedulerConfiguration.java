package ru.tinkoff.edu.java.scrapper.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tinkoff.edu.java.scrapper.scheduler.Scheduler;

@Configuration
@RequiredArgsConstructor
public class SchedulerConfiguration {
    private final ApplicationConfig config;

    @Bean
    public Scheduler scheduler() {
        return config.scheduler();
    }
}
