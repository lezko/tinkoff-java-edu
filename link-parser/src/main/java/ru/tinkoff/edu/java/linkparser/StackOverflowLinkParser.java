package ru.tinkoff.edu.java.linkparser;

public class StackOverflowLinkParser extends LinkParser {
    @Override
    public ParsingResult parse(String url) {
        if (url.startsWith("https://stackoverflow.com/questions/")) { // 36
            String s = url.substring(36, url.length() - 1);
            String[] arr = s.split("/");
            return new StackOverflowParsingResult(Integer.parseInt(arr[0]));
        }
        return nextParser.parse(url);
    }
}
