package com.theautomatedtester.pages;

import com.codeborne.selenide.Selenide;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;

@Slf4j
public class HomePage {

    public static HomePage open() {
        Selenide.open("/");
        log.info("Current URL - " + url());
        return new HomePage();
    }

    public void followingLink(String link) {
        // $(link).click();
        log.info("Name links to navigate - " + link);
        $(By.linkText(link)).click();
        log.info("Current URL after navigate - " + url());
    }
}
