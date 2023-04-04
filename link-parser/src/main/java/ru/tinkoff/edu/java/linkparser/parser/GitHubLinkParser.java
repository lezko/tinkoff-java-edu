package ru.tinkoff.edu.java.linkparser.parser;

import ru.tinkoff.edu.java.linkparser.parsingresult.GitHubParsingResult;
import ru.tinkoff.edu.java.linkparser.parsingresult.ParsingResult;

public class GitHubLinkParser extends LinkParser {

    private final String LINK_PREFIX = "https://github.com/";
    private final int USER_STR_IDX = 0;
    private final int REPO_STR_IDX = 1;

    @Override
    public ParsingResult parse(String url) {
        if (url.startsWith(LINK_PREFIX)) {
            String s = url.substring(LINK_PREFIX.length(), url.length() - 1);
            String[] arr = s.split("/");
            return new GitHubParsingResult(arr[USER_STR_IDX], arr[REPO_STR_IDX]);
        }
        return nextParser.parse(url);
    }
}
