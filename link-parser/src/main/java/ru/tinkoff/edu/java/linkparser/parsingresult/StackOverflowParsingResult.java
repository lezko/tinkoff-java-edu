package ru.tinkoff.edu.java.linkparser.parsingresult;

public class StackOverflowParsingResult extends ParsingResult {
    public int id;

    public StackOverflowParsingResult(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        return getClass().equals(obj.getClass()) && hashCode() == hashCode();
    }

    @Override
    public String toString() {
        return "id: " + id;
    }
}
