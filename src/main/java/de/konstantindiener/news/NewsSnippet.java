package de.konstantindiener.news;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NewsSnippet {

    Topic topic;

    String title;

    String description;

    String content;

    LocalDate validFrom;

    LocalDate validTo;

    List<String> tags = new ArrayList<>();
}
