package com.theautomatedtester.pages.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.impl.Html;
import com.theautomatedtester.pages.LoadedChapterPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertTrue;

public class HomePageTest extends BaseUITest {

    @Test
    public void userCanGoToChapter1(){
        com.theautomatedtester.pages.HomePage
                .open()
                .followingLink("Chapter1");

        assertTrue(Html.text.contains(url(), "http://book.theautomatedtester.co.uk/chapter1"));
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!" + url());

        LoadedChapterPage loadedChapterPage = new LoadedChapterPage();

        loadedChapterPage
                .checkTextOnPage().shouldHave(Condition.text("Assert that this text is on the page"));

        loadedChapterPage
                .followingLink("Home Page");

        assertTrue(Html.text.contains(url(), "http://book.theautomatedtester.co.uk"));
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!" + url());
    }
}
