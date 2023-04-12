package ru.tinkoff.edu.java.scrapper.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.tinkoff.edu.java.scrapper.client.GitHubClient;
import ru.tinkoff.edu.java.scrapper.client.StackOverflowClient;
import ru.tinkoff.edu.java.scrapper.client.dto.GitHubResponse;
import ru.tinkoff.edu.java.scrapper.client.dto.StackOverflowResponse;
import ru.tinkoff.edu.java.scrapper.controller.exception.LinkNotFoundException;
import ru.tinkoff.edu.java.scrapper.controller.exception.TgChatNotFoundException;
import ru.tinkoff.edu.java.scrapper.dto.request.AddLinkRequest;
import ru.tinkoff.edu.java.scrapper.dto.request.RemoveLinkRequest;
import ru.tinkoff.edu.java.scrapper.dto.response.LinkResponse;
import ru.tinkoff.edu.java.scrapper.dto.response.ListLinksResponse;

@RestController
@RequiredArgsConstructor
public class ScrapperController {
    private final GitHubClient gitHubClient;
    private final StackOverflowClient stackOverflowClient;

    @PostMapping("/tg-chat/{id}")
    public void addChat(@Valid @PathVariable long id) {
        System.out.println(id);
    }

    @DeleteMapping("/tg-chat/{id}")
    public void deleteChat(@Valid @PathVariable long id) {
        System.out.println(id);
        throw new TgChatNotFoundException();
    }

    @GetMapping("/links")
    public ListLinksResponse getLinks(@Valid @RequestHeader("Tg-Chat-Id") long id) {
        System.out.println(id);
        return new ListLinksResponse();
    }

    @PostMapping("/links")
    public LinkResponse addLink(@Valid @RequestBody AddLinkRequest req, @Valid @RequestHeader("Tg-Chat-Id") long id) {
        System.out.println(req);
        System.out.println(id);
//        throw new LinkNotFoundException();
        return new LinkResponse();
    }

    @DeleteMapping("/links")
    public LinkResponse deleteLink(@Valid @RequestBody RemoveLinkRequest req, @Valid @RequestHeader("Tg-Chat-Id") long id) {
//        return new LinkResponse();
        System.out.println("scrapper error");
        throw new LinkNotFoundException();
    }

    @GetMapping("/gh")
    public GitHubResponse fetchRepo() {
        return gitHubClient.fetchRepo("sanyarnd", "tinkoff-java-course-2022");
    }

    @GetMapping("/so")
    public StackOverflowResponse fetchQuestion() {
        return stackOverflowClient.fetchQuestion(75837463);
    }
}
