package ru.tinkoff.edu.java.linkparser;

public abstract class LinkParser {
    public LinkParser nextParser = null;

    public abstract ParsingResult parse(String url);
}
