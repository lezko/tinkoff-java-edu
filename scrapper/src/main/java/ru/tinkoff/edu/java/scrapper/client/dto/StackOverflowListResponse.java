package ru.tinkoff.edu.java.scrapper.client.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class StackOverflowListResponse {
    @NotNull List<StackOverflowResponse> items = new LinkedList<>();
}
