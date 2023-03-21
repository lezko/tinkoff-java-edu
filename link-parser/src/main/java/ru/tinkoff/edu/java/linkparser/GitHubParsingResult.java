package ru.tinkoff.edu.java.linkparser;

public class GitHubParsingResult extends ParsingResult {
    public String user;
    public String repo;

    public GitHubParsingResult(String user, String repo) {
        this.user = user;
        this.repo = repo;
    }

    @Override
    public String toString() {
        return "user: " + user + ", repo: " + repo;
    }
}
