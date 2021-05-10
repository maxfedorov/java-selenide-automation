package com.github.maxfedorov.github;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

public class JoinPage {

    public void validate() {
        $(id("user_login")).shouldBe(visible);
        $(id("user_email")).shouldBe(visible);
        $(id("user_password")).shouldBe(visible);
    }

}
