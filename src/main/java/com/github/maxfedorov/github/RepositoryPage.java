package com.github.maxfedorov.github;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RepositoryPage {

    public SelenideElement getReadMe() {
        return $(".markdown-body");
    }

    public void openTab(String name) {
        $$("ul.UnderlineNav-body li a span")
                .filterBy(attribute("data-content", name))
                .first()
                .parent()
                .click();
    }

    public void openFileOrFolder(String name) {
        $$("div.Box-row a")
                .filterBy(text(name))
                .first()
                .click();
    }

    public ElementsCollection getIssues() {
        return $$("div[aria-label='Issues'] .js-navigation-item.js-issue-row");
    }

    public SelenideElement getFileBody() {
        return $("div[itemprop='text'] tbody");
    }
}
