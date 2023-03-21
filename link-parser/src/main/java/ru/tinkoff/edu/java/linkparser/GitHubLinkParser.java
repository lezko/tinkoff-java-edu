package ru.tinkoff.edu.java.linkparser;

public class GitHubLinkParser extends LinkParser {
    @Override
    public ParsingResult parse(String url) {
        if (url.startsWith("https://github.com")) {
            String s = url.substring(19, url.length() - 1);
            String[] arr = s.split("/");
            return new GitHubParsingResult(arr[0], arr[1]);
        }
        return nextParser.parse(url);
    }
}
