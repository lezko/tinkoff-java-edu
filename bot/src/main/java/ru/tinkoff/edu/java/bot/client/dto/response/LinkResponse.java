package ru.tinkoff.edu.java.bot.client.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkResponse {
    private long id;
    private URI url;
}
