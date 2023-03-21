package ru.tinkoff.edu.java.linkparser;

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
