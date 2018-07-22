package de.konstantindiener.news;

import java.util.ArrayList;
import java.util.List;

public class Topic {

    List<NewsSnippet> newsSnippets = new ArrayList<NewsSnippet>();
    private String name;

    public Topic(String name) {
        this.name = name;
    }

    public NewsSnippetBuilder newNewsSnippet(String title) {
        return new NewsSnippetBuilder(this, title);
    }
}