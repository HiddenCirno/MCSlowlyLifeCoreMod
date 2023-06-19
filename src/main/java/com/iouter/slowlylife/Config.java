package com.iouter.slowlylife;

import java.io.File;
import net.minecraftforge.common.config.Configuration;

public class Config {

    private static class Defaults {

    }

    private static class Categories {
    }

    public static void syncronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);
        configuration.load();
        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
