package ru.tinkoff.edu.java.scrapper.controller.exception;

public class TgChatNotFoundException extends RuntimeException {
    public TgChatNotFoundException() {
        super("Tg chat not found");
    }
}
