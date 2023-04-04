package ru.tinkoff.edu.java.scrapper.scheduler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tinkoff.edu.java.scrapper.configuration.ApplicationConfig;

@Configuration
public class SchedulerConfiguration {
    private final ApplicationContext ctx;

    public SchedulerConfiguration(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    @Bean
    public Scheduler scheduler() {
        ApplicationConfig config = ctx.getBean(ApplicationConfig.class);
        return config.scheduler();
    }
}
