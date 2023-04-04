package ru.tinkoff.edu.java.bot.dto;

import lombok.Data;

import java.util.List;

@Data
public class ApiErrorResponse {
    private String description;
    private String code;
    private String exceptionName;
    private String exceptionMessage;
    private List<String> stacktrace;
}
