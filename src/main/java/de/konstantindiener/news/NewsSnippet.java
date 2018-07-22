package de.konstantindiener.news;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class NewsSnippet {

    Topic topic;

    String title;

    String content;

    LocalDate validFrom;

    LocalDate validTo;

    List<String> tags = new ArrayList<>();

    public Topic getTopic() {
        return topic;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public List<String> getTags() {
        return unmodifiableList(tags);
    }
}
