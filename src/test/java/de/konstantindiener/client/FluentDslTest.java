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
                .containing("An arbitrary description")
                .taggedBy("Topic", "News", "DSL")
                .add()
                .newNewsSnippet("Another simple snippet")
                .containing("A description")
                .taggedBy("Topic", "News", "DSL")
                .add();

        List<NewsSnippet> newsSnippets = fluentInterfaceTopic.getNewsSnippets();
        assertThat(newsSnippets).hasSize(2);

        
    }

    @Test
    void failOnAddindNewsSnippetDirectly() {

        assertThrows(
                UnsupportedOperationException.class,
                () -> fluentInterfaceTopic.getNewsSnippets().add(null));
    }
}