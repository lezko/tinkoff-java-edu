package ru.tinkoff.edu.java.linkparser.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.tinkoff.edu.java.linkparser.LinkParserChainGenerator;
import ru.tinkoff.edu.java.linkparser.parsingresult.GitHubParsingResult;
import ru.tinkoff.edu.java.linkparser.parsingresult.ParsingResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestGitHubLinkParser {

    private LinkParser parser;
    @BeforeEach
    public void setup() {
        parser = LinkParserChainGenerator.generate(List.of(
            new GitHubLinkParser(),
            new DefaultLinkParser()
        ));
    }

    @Test
    void invalid1() {
        String url = "https://github.com/trending";
        ParsingResult result = parser.parse(url);
        assertNull(result);
    }

    @Test
    void invalid2() {
        String url = "https://github.com/explore";
        ParsingResult result = parser.parse(url);
        assertNull(result);
    }

    @Test
    void valid() {
        String url = "https://github.com/lezko/tanks-game";
        ParsingResult result = parser.parse(url);
        assertNotNull(result);
        GitHubParsingResult ghResult = (GitHubParsingResult) result;
        assertEquals(new GitHubParsingResult("lezko", "tanks-game"), ghResult);
    }
}
