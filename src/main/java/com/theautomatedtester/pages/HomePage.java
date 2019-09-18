package com.theautomatedtester.pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    public static HomePage open() {
        Selenide.open("/");
        return new HomePage();
    }

    public void followingLink(String link) {
        // $(link).click();
        $(By.linkText(link)).click();
    }
}
