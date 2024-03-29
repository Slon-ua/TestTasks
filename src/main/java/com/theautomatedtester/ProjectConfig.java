package com.theautomatedtester;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config.properties"})
public interface ProjectConfig extends Config {

    String defaultHost();

    String defaultBrowser();

    @DefaultValue("dev")
    String env();

    @DefaultValue("Firefox")
    String brws();

    @Key("${env}.host")
    String host();

    @Key("${brws}.browser")
    String browser();
}
