package de.konstantindiener.client;

import de.konstantindiener.news.NewsSnippet;
import de.konstantindiener.news.Topic;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FluentDslTest {

    private Topic fluentInterfaceTopic = new Topic("Fluent Interface");

    @Test
    void createNewsSnippet() {
        fluentInterfaceTopic
                .newNewsSnippet("SimpleSnippet")
                    .containing("An arbitrary content")
                    .taggedBy("Topic", "News", "DSL")
                    .add()
                .newNewsSnippet("Another simple snippet")
                    .containing("Content")
                    .taggedBy("Topic", "News", "DSL")
                    .add();

        List<NewsSnippet> newsSnippets = fluentInterfaceTopic.getNewsSnippets();
        assertThat(newsSnippets).hasSize(2);

        verifyNewsSnippet(newsSnippets.get(0),
                "SimpleSnippet",
                "An arbitrary content",
                new String[]{"Topic", "News", "DSL"});

        verifyNewsSnippet(newsSnippets.get(1),
                "Another simple snippet",
                "Content",
                new String[]{"Topic", "News", "DSL"});
    }

    private void verifyNewsSnippet(NewsSnippet newsSnippet2, String s, String content, String[] tags) {
        assertThat(newsSnippet2.getTitle()).isEqualTo(s);
        assertThat(newsSnippet2.getContent()).isEqualTo(content);
        assertThat(newsSnippet2.getTags()).contains(tags);
    }

    @Test
    void failOnAddindNewsSnippetDirectly() {

        assertThrows(
                UnsupportedOperationException.class,
                () -> fluentInterfaceTopic.getNewsSnippets().add(null));
    }
}