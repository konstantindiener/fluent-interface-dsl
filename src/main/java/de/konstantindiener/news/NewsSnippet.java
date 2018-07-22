package de.konstantindiener.news;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsSnippet {

    Topic topic;

    String title;

    String description;
    String content;

    Date validFrom;

    Date validTo;

    List<String> tags = new ArrayList<String>();
}
