package ru.tinkoff.edu.java.bot.client.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RemoveLinkRequest {
    @NotNull
    private String link;
}
