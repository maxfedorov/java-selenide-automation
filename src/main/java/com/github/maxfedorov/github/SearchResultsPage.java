package com.github.maxfedorov.github;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {
    public SelenideElement getSearchResultsHeader() {
        return $(".codesearch-results h3");
    }

    public SelenideElement getSearchResultLinkByNumber(int i) {
        return $$("ul.repo-list li.repo-list-item .f4 a").get(i - 1);
    }

    public void openSearchResult(String name) {
        $$("ul.repo-list li.repo-list-item .f4 a").filterBy(text(name)).first().click();
    }

    public void selectSideTab(String name) {
        $$("a.menu-item")
                .filterBy(text(name))
                .first()
                .click();
    }

    public SelenideElement getCommitButton() {
        return $(".commit-links-group");
    }

}
