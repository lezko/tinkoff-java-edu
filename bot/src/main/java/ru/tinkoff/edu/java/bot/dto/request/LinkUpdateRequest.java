package ru.tinkoff.edu.java.bot.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class LinkUpdateRequest {
    @NotNull
    private long id;
    @NotNull
    private String url;
    @NotNull
    private String description;
    @NotNull
    private List<Long> tgChatIds;
}
