package ru.tinkoff.edu.java.linkparser.parser;

import ru.tinkoff.edu.java.linkparser.parsingresult.ParsingResult;

public abstract class LinkParser {
    public LinkParser nextParser = null;

    public abstract ParsingResult parse(String url);
}
