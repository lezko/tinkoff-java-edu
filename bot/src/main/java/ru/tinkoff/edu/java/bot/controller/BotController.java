package ru.tinkoff.edu.java.bot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.edu.java.bot.client.ScrapperClient;
import ru.tinkoff.edu.java.bot.dto.request.LinkUpdateRequest;

@RestController
public class BotController {
    @Autowired
    private ScrapperClient client;

    @PostMapping("/updates")
    public void updateLink(@Valid @RequestBody LinkUpdateRequest request) {
    }

    @GetMapping("test")
    public void test() {
        client.addChat(0);
    }
}
