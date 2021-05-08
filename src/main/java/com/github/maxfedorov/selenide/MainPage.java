package com.github.maxfedorov.selenide;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public void search(String text) {
        $(".header-search-input").setValue(text).pressEnter();
    }
}
