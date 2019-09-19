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

    public void setHost() {
        Map myVars = singletonMap(ENV_VARIABLE_KEY, getProperty(ENV_VARIABLE_KEY));
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class, myVars, System.getProperties());
        Configuration.baseUrl = config.host();  //вызов конкретной проперти
    }

    public void setBrowser() {
        Map myVars1 = singletonMap(BRWS_VARIABLE_KEY, getProperty(BRWS_VARIABLE_KEY));
        ProjectConfig config1 = ConfigFactory.create(ProjectConfig.class, myVars1, System.getProperties());
        String browser = config1.brws();

        if (browser == "Firefox") {
            browserFirefox();
        } else if (browser == "Chrome") {
            browserChrome();
        }
    }

    public void browserChrome() {
        Configuration.browser = "Chrome";
        Configuration.holdBrowserOpen = false;
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
    }

    public void browserFirefox() {
        Configuration.browser = "Firefox";
    }
}

