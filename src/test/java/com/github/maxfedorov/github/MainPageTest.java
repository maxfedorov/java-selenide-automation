package com.github.maxfedorov.github;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class MainPageTest extends TestBase {
    private MainPage mainPage;

    @BeforeEach
    void before() {
        open("https://github.com/");
        mainPage = new MainPage();
    }

    @Test
    void searchRepo() {
        mainPage.search("selenide");
        SearchResultsPage result = new SearchResultsPage();
        SelenideElement resultLink = result.getSearchResultLinkByNumber(1);
        result.getSearchResultsHeader().should(matchText(".* repository results"));
        resultLink.shouldHave(text("selenide/selenide"));
        resultLink.shouldHave(href("/selenide/selenide"));
    }

    @Test
    void signUp() {
        mainPage.signUp("test@e.mail");
        new JoinPage().validate();
    }

}
