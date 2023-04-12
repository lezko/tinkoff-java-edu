package ru.tinkoff.edu.java.bot.service.exception;

public class LinkNotFoundException extends RuntimeException {
    public LinkNotFoundException() {
        super("Link not found");
    }
}
