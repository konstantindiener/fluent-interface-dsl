package de.konstantindiener.news;

import java.util.Calendar;
import java.util.Date;

public class NewsSnippetBuilder {

    private final NewsSnippet objectUnderConstruction;

    private final Topic topic;

    NewsSnippetBuilder(Topic topic, String title) {
        this.topic = topic;
        this.objectUnderConstruction = new NewsSnippet();
        this.objectUnderConstruction.title = title;
        this.objectUnderConstruction.validFrom = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.set(9999, 11, 31);
        this.objectUnderConstruction.validTo = calendar.getTime();
    }

    public NewsSnippetBuilder containing(String contents) {
        this.objectUnderConstruction.content = contents;
        return this;
    }

    public NewsSnippetBuilder taggedBy(String... tags) {
        for (String tag : tags) {
            if (!this.objectUnderConstruction.tags.contains(tag)) {
                this.objectUnderConstruction.tags.add(tag);
            }
        }
        return this;
    }

    public void add() {
        this.objectUnderConstruction.topic = topic;
        topic.newsSnippets.add(this.objectUnderConstruction);
    }
}
