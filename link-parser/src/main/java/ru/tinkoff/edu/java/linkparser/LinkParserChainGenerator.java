package ru.tinkoff.edu.java.linkparser;

import java.util.Collection;

public class LinkParserChainGenerator {
    static LinkParser generate(Collection<LinkParser> parsers) {
        LinkParser current = null, head = null;
        for (LinkParser parser : parsers) {
            if (current == null) {
                current = parser;
                head = parser;
                continue;
            }
            current.nextParser = parser;
            current = parser;
        }
        return head;
    }
}
