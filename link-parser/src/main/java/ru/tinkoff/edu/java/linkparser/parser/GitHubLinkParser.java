package ru.tinkoff.edu.java.linkparser.parser;

import ru.tinkoff.edu.java.linkparser.parsingresult.GitHubParsingResult;
import ru.tinkoff.edu.java.linkparser.parsingresult.ParsingResult;

public class GitHubLinkParser extends LinkParser {

    private final String LINK_PREFIX = "https://github.com/";
    private final int USER_STR_IDX = 0;
    private final int REPO_STR_IDX = 1;
    private final int VALID_ITEMS_COUNT = 2;

    @Override
    public ParsingResult parse(String url) {
        if (url.startsWith(LINK_PREFIX)) {
            String s = url.substring(LINK_PREFIX.length());
            String[] arr = s.split("/");
            if (arr.length == VALID_ITEMS_COUNT) {
                return new GitHubParsingResult(arr[USER_STR_IDX], arr[REPO_STR_IDX]);
            }
        }
        return nextParser.parse(url);
    }
}
