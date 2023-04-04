package ru.tinkoff.edu.java.linkparser.parsingresult;

public class GitHubParsingResult extends ParsingResult {
    public String user;
    public String repo;

    public GitHubParsingResult(String user, String repo) {
        this.user = user;
        this.repo = repo;
    }

    @Override
    public int hashCode() {
        return (user + repo).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return getClass().equals(obj.getClass()) && hashCode() == obj.hashCode();
    }

    @Override
    public String toString() {
        return "user: " + user + ", repo: " + repo;
    }
}
