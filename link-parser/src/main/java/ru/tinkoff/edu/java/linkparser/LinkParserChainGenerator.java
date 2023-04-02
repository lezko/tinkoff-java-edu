package ru.tinkoff.edu.java.linkparser;

import ru.tinkoff.edu.java.linkparser.parser.DefaultLinkParser;
import ru.tinkoff.edu.java.linkparser.parser.GitHubLinkParser;
import ru.tinkoff.edu.java.linkparser.parser.LinkParser;
import ru.tinkoff.edu.java.linkparser.parser.StackOverflowLinkParser;

import java.util.Arrays;
import java.util.Collection;

public class LinkParserChainGenerator {
    static LinkParser generate(Collection<LinkParser> parsers) {
        LinkParser prev = null, head = null;
        for (LinkParser parser : parsers) {
            if (prev == null) {
                prev = parser;
                head = parser;
                continue;
            }
            prev.nextParser = parser;
            prev = parser;
        }
        return head;
    }

    // usage example
    public static void main(String[] args) {
        LinkParser parser = LinkParserChainGenerator.generate(Arrays.asList(
            new GitHubLinkParser(), new StackOverflowLinkParser(), new DefaultLinkParser()
        ));

        String[] urls = new String[] {
            "https://github.com/sanyarnd/tinkoff-java-course-2022/",
            "https://stackoverflow.com/questions/1642028/what-is-the-operator-in-c",
            "https://stackoverflow.com/search?q=unsupported%20link"
        };

        for (String url : urls) {
            System.out.println(parser.parse(url));
        }
    }
}
