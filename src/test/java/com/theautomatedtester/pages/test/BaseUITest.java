package com.theautomatedtester.pages.test;

import com.codeborne.selenide.Configuration;
import com.theautomatedtester.ProjectConfig;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeSuite;

import java.util.Map;

import static java.lang.System.getProperty;
import static java.util.Collections.singletonMap;

public class BaseUITest {

    private static final String ENV_VARIABLE_KEY = "env";
    private static final String BRWS_VARIABLE_KEY = "brws";

    @BeforeSuite
    public void setUp() {
        setHost();
        setBrowser();
    }

    private void setHost() {
        try {
            Map myVars = singletonMap(ENV_VARIABLE_KEY, getProperty(ENV_VARIABLE_KEY));
            ProjectConfig config = ConfigFactory.create(ProjectConfig.class, myVars, System.getProperties());
            Configuration.baseUrl = config.host();
        } catch (IllegalArgumentException e) {
            Configuration.baseUrl = ConfigFactory.create(ProjectConfig.class).defaultHost();
        }
    }

    private void setBrowser() {
        try {
            Map myVars = singletonMap(BRWS_VARIABLE_KEY, getProperty(BRWS_VARIABLE_KEY));
            ProjectConfig config = ConfigFactory.create(ProjectConfig.class, myVars, System.getProperties());
            String browser = config.browser();
            selectBrowser(browser);
        } catch (IllegalArgumentException e) {
            Configuration.browser = ConfigFactory.create(ProjectConfig.class).defaultBrowser();
        }
    }

    private void selectBrowser(String browser) {
        Configuration.browser = browser;
        Configuration.holdBrowserOpen = false;
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
    }
}

