package ru.tinkoff.edu.java.scrapper.client.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class GitHubResponse {
    @NotNull
    private long id;
    @NotNull
    private String full_name;
    @NotNull
    private String description;
    @NotNull
    private OffsetDateTime pushed_at;
    @NotNull
    private OffsetDateTime created_at;
    @NotNull
    private OffsetDateTime updated_at;
}
