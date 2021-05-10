package com.github.maxfedorov.github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class RepositoryPageTest extends TestBase {
    RepositoryPage repositoryPage;

    @BeforeEach
    void before() {
        open("https://github.com/selenide/selenide");
        repositoryPage = new RepositoryPage();
    }

    @Test
    void openIssues() {
        repositoryPage.openTab("Issues");
        repositoryPage.getIssues().shouldHave(sizeGreaterThan(0));
    }

    @Test
    void openFileWithCode() {
        repositoryPage.openFileOrFolder("gradle");
        repositoryPage.openFileOrFolder("wrapper");
        repositoryPage.openFileOrFolder("gradle-wrapper.properties");
        repositoryPage.getFileBody().shouldHave(text("distributionBase=GRADLE_USER_HOME"));
    }

}
