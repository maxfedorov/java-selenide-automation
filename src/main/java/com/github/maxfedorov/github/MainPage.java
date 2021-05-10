package com.github.maxfedorov.github;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

public class MainPage {
    public void search(String text) {
        $(".header-search-input").setValue(text).pressEnter();
    }

    public void signUp(String mail) {
        $(id("user_email")).setValue(mail);
        $("[type='submit']").click();
    }

}
