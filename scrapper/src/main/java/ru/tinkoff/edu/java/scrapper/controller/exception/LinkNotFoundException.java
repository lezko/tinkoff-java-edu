package ru.tinkoff.edu.java.scrapper.controller.exception;

public class LinkNotFoundException extends RuntimeException {
    public LinkNotFoundException() {
        super("Link not found");
    }
}
