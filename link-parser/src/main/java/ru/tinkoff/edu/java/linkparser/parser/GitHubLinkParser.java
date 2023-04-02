package ru.tinkoff.edu.java.linkparser.parser;

import ru.tinkoff.edu.java.linkparser.parsingresult.GitHubParsingResult;
import ru.tinkoff.edu.java.linkparser.parsingresult.ParsingResult;

public class GitHubLinkParser extends LinkParser {
    @Override
    public ParsingResult parse(String url) {
        if (url.startsWith("https://github.com")) {
            String[] arr = url.split("/");
            if (arr.length == 5) {
                return new GitHubParsingResult(arr[3], arr[4]);
            }
        }
        return nextParser.parse(url);
    }
}
