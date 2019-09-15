package com.theautomatedtester.pages.test;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public class BaseUITest {
    @BeforeSuite
    public void setUp() {
        Configuration.baseUrl = "http://book.theautomatedtester.co.uk/";
        //  Configuration.browserSize = "1366X768";
        Configuration.browser = "Firefox";

    }
}