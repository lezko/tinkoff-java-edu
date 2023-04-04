package ru.tinkoff.edu.java.bot.dto;

import lombok.Data;

import java.util.List;

@Data
public class LinkUpdateRequest {
    private long id;
    private String uri;
    private String description;
    private List<Long> tgChatIds;
}
