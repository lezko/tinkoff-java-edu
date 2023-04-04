package ru.tinkoff.edu.java.scrapper.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import ru.tinkoff.edu.java.scrapper.controller.exception.LinkNotFoundException;
import ru.tinkoff.edu.java.scrapper.controller.exception.TgChatNotFoundException;
import ru.tinkoff.edu.java.scrapper.dto.request.AddLinkRequest;
import ru.tinkoff.edu.java.scrapper.dto.request.RemoveLinkRequest;
import ru.tinkoff.edu.java.scrapper.dto.response.LinkResponse;
import ru.tinkoff.edu.java.scrapper.dto.response.ListLinksResponse;

@RestController
public class ScrapperController {
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
        return new LinkResponse();
    }

    @DeleteMapping("/links")
    public LinkResponse deleteLink(@Valid @RequestBody RemoveLinkRequest req, @Valid @RequestHeader("Tg-Chat-Id") long id) {
//        return new LinkResponse();
        throw new LinkNotFoundException();
    }
}
