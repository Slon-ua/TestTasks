package com.theautomatedtester.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoadedChapterPage {

    public SelenideElement checkTextOnPage(){
        return $("#divontheleft");
    }

    public void followingLink(String link){
        $(By.linkText(link)).click();
    }
}
