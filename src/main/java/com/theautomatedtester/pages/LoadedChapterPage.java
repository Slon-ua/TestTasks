package com.theautomatedtester.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;

@Slf4j
public class LoadedChapterPage {

    public SelenideElement checkTextOnPage() {
        log.info("Return text from element #divontheleft ");
        return $("#divontheleft");
    }

    public void followingLink(String link) {
        log.info("Name links to navigate - " + link);
        $(By.linkText(link)).click();
        log.info("Current URL after navigate - " + url());
    }
}
