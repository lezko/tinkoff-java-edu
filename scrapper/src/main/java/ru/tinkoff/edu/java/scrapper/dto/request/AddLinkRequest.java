package ru.tinkoff.edu.java.scrapper.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddLinkRequest {
    @NotNull
    private String link;
}
