package ru.tinkoff.edu.java.linkparser.parsingresult;

public class StackOverflowParsingResult extends ParsingResult {
    public int id;

    public StackOverflowParsingResult(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id: " + id;
    }
}
