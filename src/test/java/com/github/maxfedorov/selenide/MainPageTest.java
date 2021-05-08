package com.github.maxfedorov.selenide;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class MainPageTest extends TestBase {

    @Test
    void openPage() {
        open("https://github.com/");
        new MainPage().search("selenide");

    }

}
