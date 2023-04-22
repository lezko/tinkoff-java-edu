package ru.tinkoff.edu.java.bot.service.exception;

public class TgChatNotFoundException extends RuntimeException {
    public TgChatNotFoundException() {
        super("Tg chat not found");
    }
}
