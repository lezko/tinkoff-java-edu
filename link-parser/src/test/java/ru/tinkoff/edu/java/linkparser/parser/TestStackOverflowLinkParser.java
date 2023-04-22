package ru.tinkoff.edu.java.linkparser.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.tinkoff.edu.java.linkparser.LinkParserChainGenerator;
import ru.tinkoff.edu.java.linkparser.parsingresult.ParsingResult;
import ru.tinkoff.edu.java.linkparser.parsingresult.StackOverflowParsingResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestStackOverflowLinkParser {
    private LinkParser parser;
    @BeforeEach
    public void setup() {
        parser = LinkParserChainGenerator.generate(List.of(
            new StackOverflowLinkParser(),
            new DefaultLinkParser()
        ));
    }

    @Test
    void invalid1() {
        String url = "https://stackoverflow.com/jobs/companies/warner-bros-discovery";
        ParsingResult result = parser.parse(url);
        assertNull(result);
    }

    @Test
    void invalid2() {
        String url = "https://stackoverflow.com/tags";
        ParsingResult result = parser.parse(url);
        assertNull(result);
    }

    @Test
    void valid() {
        String url = "https://stackoverflow.com/questions/75934265/how-to-type-onchange-in-react-select";
        ParsingResult result = parser.parse(url);
        assertNotNull(result);
        StackOverflowParsingResult ghResult = (StackOverflowParsingResult) result;
        assertEquals(new StackOverflowParsingResult(75934265), ghResult);
    }
}
