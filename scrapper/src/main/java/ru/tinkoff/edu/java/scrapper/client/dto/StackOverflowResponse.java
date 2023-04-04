package ru.tinkoff.edu.java.scrapper.client.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.LinkedList;
import java.util.List;

@Data
public class StackOverflowResponse {
    @NotNull
    private long question_id;
    @NotNull
    private String title;
    @NotNull
    private List<String> tags = new LinkedList<>();
    @NotNull
    private int view_count;
    @NotNull
    private OffsetDateTime last_activity_date;

    private OffsetDateTime last_edit_date;

    @NotNull
    private boolean is_answered;
    @NotNull
    private int answer_count;

    private long accepted_answer_id;
}
