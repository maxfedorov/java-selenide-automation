package com.github.maxfedorov.github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class SearchResultsPageTest extends TestBase {
    SearchResultsPage searchResultsPage;

    @BeforeEach
    void before() {
        open("https://github.com/search?q=selenide");
        searchResultsPage = new SearchResultsPage();
    }

    @Test
    void openRepo() {
        searchResultsPage.openSearchResult("selenide/selenide");
        new RepositoryPage().getReadMe().shouldHave(text("Selenide = UI Testing Framework powered by Selenium WebDriver"));
    }

    @Test
    void selectCommitsTab() {
        searchResultsPage.selectSideTab("Commits");
        searchResultsPage.getCommitButton().shouldBe(visible);
    }

}
