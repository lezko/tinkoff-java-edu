package ru.tinkoff.edu.java.linkparser.parser;

import ru.tinkoff.edu.java.linkparser.parsingresult.ParsingResult;
import ru.tinkoff.edu.java.linkparser.parsingresult.StackOverflowParsingResult;

public class StackOverflowLinkParser extends LinkParser {
    @Override
    public ParsingResult parse(String url) {
        if (url.startsWith("https://stackoverflow.com/questions/")) {
            String[] arr = url.split("/");
            if (arr.length == 6) {
                return new StackOverflowParsingResult(Integer.parseInt(arr[4]));
            }
        }
        return nextParser.parse(url);
    }
}
