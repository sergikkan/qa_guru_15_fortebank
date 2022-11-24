package org.skan.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.skan.helpers.Attach;
import org.skan.pages.ForteMarketPage;

public class BaseTest {

    ForteMarketPage forteMarket = new ForteMarketPage();
    @BeforeAll
    static void setUp(){
        String browserName = System.getProperty("browser", "chrome");
        String browserVersion = System.getProperty("browser_version", "99");
        String browserSize = System.getProperty("browser_size", "1920x1080");
        String remoteUrl = System.getProperty("remote");

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl="https://market.forte.kz";
        Configuration.timeout = 10000;

        Configuration.browser= browserName;
        Configuration.browserVersion= browserVersion;
        Configuration.browserSize = browserSize;
        if(remoteUrl!= null ){
            Configuration.remote = remoteUrl;
        }
    }

    @AfterEach
    void addAttachments(){
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
