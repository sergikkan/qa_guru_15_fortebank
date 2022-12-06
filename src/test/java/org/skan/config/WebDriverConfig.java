package org.skan.config;

import org.aeonbits.owner.Config;

import java.net.URL;

    @Config.Sources({
            "classpath:${env}.properties"
    })

    public interface WebDriverConfig extends Config {

        @Key("baseUrl")
        @DefaultValue("https://market.forte.kz")
        String baseUrl();

        @Key("browser")
        @DefaultValue("CHROME")
        String browser();

        @Key("browserSize")
        @DefaultValue("1920x1080")
        String browserSize();

        @Key("browserVersion")
        @DefaultValue("100")
        String browserVersion();
        @Key("remote")
        String remote();

    }

