package com.supsi.backend.model.others;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configs {

    private static Configs config;

    private static final Properties properties = new Properties();

    private Configs() {
        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("configs.properties")) {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Configs getInstance() {
        if(config == null) {
           config = new Configs();
        }
        return config;
    }

    public Integer getPointsPerSun() {
        return Integer.parseInt(properties.getProperty("pointsPerSun"));
    }
}
