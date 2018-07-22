package de.konstantindiener.client;

import de.konstantindiener.news.Topic;
import org.junit.jupiter.api.Test;

class FluentDslTest {

    @Test
    void createNewsSnippet() {
        new Topic("Fluent Interface").newNewsSnippet("Domänenmodell").containing("aaa")
                .taggedBy("Topic", "News", "DSL")
                .add();
    }
}