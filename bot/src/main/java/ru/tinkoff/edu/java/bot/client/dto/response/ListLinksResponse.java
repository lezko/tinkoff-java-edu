package ru.tinkoff.edu.java.bot.client.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListLinksResponse {
    private List<LinkResponse> links = new LinkedList<>();
    private int size;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LinkResponse link : links) {
            sb.append(link.getUrl()).append("\n");
        }
        return sb.toString();
    }
}
