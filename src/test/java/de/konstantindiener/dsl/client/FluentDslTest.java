package de.konstantindiener.dsl.client;

import de.konstantindiener.dsl.news.NewsSnippet;
import de.konstantindiener.dsl.news.Topic;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static de.konstantindiener.dsl.date.DateConstants.infinity;
import static de.konstantindiener.dsl.date.DateConstants.today;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FluentDslTest {

    private Topic fluentInterfaceTopic = new Topic("Fluent Interface");

    @Test
    void createNewsSnippets() {
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

    private void verifyNewsSnippet(NewsSnippet newsSnippet, String title, String content, String[] tags) {
        assertThat(newsSnippet.getTitle()).isEqualTo(title);
        assertThat(newsSnippet.getContent()).isEqualTo(content);
        assertThat(newsSnippet.getTags()).contains(tags);
    }

    @Test
    void addNewsSnippetsWithDateRange() {
        LocalDate now = LocalDate.now();

        fluentInterfaceTopic
                .newNewsSnippet("SimpleSnippet")
                    .containing("An arbitrary content")
                    .taggedBy("Topic", "News", "DSL")
                    .validFrom(today()).to(now.plusWeeks(2))
                    .add()
                .newNewsSnippet("Another simple snippet")
                    .containing("Content")
                    .taggedBy("Topic", "News", "DSL")
                    .validFrom(now.plusDays(2)).to(infinity())
                    .add();

        List<NewsSnippet> newsSnippets = fluentInterfaceTopic.getNewsSnippets();
        verifyNewsSnippetsDateRange(newsSnippets.get(0), now, now.plusDays(14));
        verifyNewsSnippetsDateRange(newsSnippets.get(1), now.plusDays(2), LocalDate.MAX);
    }

    private void verifyNewsSnippetsDateRange(NewsSnippet newsSnippet,
                                             LocalDate expectedFromDate,
                                             LocalDate expectedToDate) {
        assertThat(newsSnippet.getValidFrom()).isEqualTo(expectedFromDate);
        assertThat(newsSnippet.getValidTo()).isEqualTo(expectedToDate);
    }

    @Test
    void failOnAddindNewsSnippetDirectly() {

        assertThrows(
                UnsupportedOperationException.class,
                () -> fluentInterfaceTopic.getNewsSnippets().add(null));
    }

    @Test
    void failOnAddingTagsDirectly() {

        fluentInterfaceTopic
                .newNewsSnippet("SimpleSnippet")
                .containing("An arbitrary content")
                .taggedBy("Topic", "News", "DSL")
                .add();

        final NewsSnippet newsSnippet = fluentInterfaceTopic.getNewsSnippets().get(0);

        assertThrows(
                UnsupportedOperationException.class,
                () -> newsSnippet.getTags().add("test")
        );
    }
}