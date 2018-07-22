package de.konstantindiener.news;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Topic {

    private String name;

    List<NewsSnippet> newsSnippets = new ArrayList<>();

    public Topic(String name) {
        this.name = name;
    }

    public NewsSnippetBuilder newNewsSnippet(String title) {
        return new NewsSnippetBuilder(this, title);
    }

    public String getName() {
        return name;
    }

    public List<NewsSnippet> getNewsSnippets() {
        return unmodifiableList(newsSnippets);
    }
}