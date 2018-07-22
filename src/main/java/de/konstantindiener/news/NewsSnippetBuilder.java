package de.konstantindiener.news;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NewsSnippetBuilder {

    private final NewsSnippet objectUnderConstruction;

    private final Topic topic;

    NewsSnippetBuilder(Topic topic, String title) {
        this.topic = topic;
        this.objectUnderConstruction = new NewsSnippet();
        this.objectUnderConstruction.title = title;
        this.objectUnderConstruction.validFrom = LocalDate.now();
        this.objectUnderConstruction.validTo = LocalDate.MAX;
    }

    public NewsSnippetBuilder containing(String contents) {
        this.objectUnderConstruction.content = contents;
        return this;
    }

    public NewsSnippetBuilder taggedBy(String... tags) {

        List<String> allNewTags = Stream.of(tags)
                .filter((String tag) -> !objectUnderConstruction.tags.contains(tag))
                .collect(Collectors.toList());
        objectUnderConstruction.tags.addAll(allNewTags);

        return this;
    }

    public DateRangeBuilder<NewsSnippetBuilder> validFrom(LocalDate asOfDate) {
        return new DateRangeBuilder<>(
                asOfDate,
                this,
                this::setDateRange);
    }

    private void setDateRange(LocalDate from, LocalDate to) {
        this.objectUnderConstruction.validFrom = from;
        this.objectUnderConstruction.validTo = to;
    }

    public Topic add() {
        this.objectUnderConstruction.topic = topic;
        topic.newsSnippets.add(this.objectUnderConstruction);

        return topic;
    }
}
