package ru.tinkoff.edu.java.linkparser;

import java.util.Arrays;

public class Main {
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
