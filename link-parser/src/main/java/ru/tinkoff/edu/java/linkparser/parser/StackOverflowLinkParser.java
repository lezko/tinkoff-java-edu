package ru.tinkoff.edu.java.linkparser.parser;

import ru.tinkoff.edu.java.linkparser.parsingresult.ParsingResult;
import ru.tinkoff.edu.java.linkparser.parsingresult.StackOverflowParsingResult;

public class StackOverflowLinkParser extends LinkParser {

    private final String LINK_PREFIX = "https://stackoverflow.com/questions/";
    private final int QUESTION_ID_IDX = 0;

    @Override
    public ParsingResult parse(String url) {
        if (url.startsWith(LINK_PREFIX)) { // 36
            String s = url.substring(LINK_PREFIX.length(), url.length() - 1);
            String[] arr = s.split("/");
            return new StackOverflowParsingResult(Integer.parseInt(arr[QUESTION_ID_IDX]));
        }
        return nextParser.parse(url);
    }
}
