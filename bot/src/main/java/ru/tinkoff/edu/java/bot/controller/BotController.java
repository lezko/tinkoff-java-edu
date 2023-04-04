package ru.tinkoff.edu.java.bot.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.edu.java.bot.dto.request.LinkUpdateRequest;

@RestController
public class BotController {
    @PostMapping("/updates")
    public void updateLink(@Valid @RequestBody LinkUpdateRequest request) {
    }
}
