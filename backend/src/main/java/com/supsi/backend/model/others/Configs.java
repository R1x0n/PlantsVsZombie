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

    public int getProperty(String propertyName) {
        return Integer.parseInt(properties.getProperty(propertyName));
    }

    public int getProjectileDamage() {
        return getProperty("projectileDamage");
    }

    public int getPointsPerSun() {
        return getProperty("pointsPerSun");
    }

    public int getSunflowerCost() {
        return getProperty("sunflowerCost");
    }

    public int getAttackPlantCost() {
        return getProperty("attackPlantCost");
    }

    public int getDefensePlantCost() {
        return getProperty("defensePlantCost");
    }

    public int getInitialPoints() {
        return getProperty("initialPoints");
    }

    public int getSunGenerationTimeInMilliseconds() {
        return getProperty("sunGenerationTimeInMilliseconds");
    }

    public int getSunDespawnTimeInMilliseconds() {
        return getProperty("sunDespawnTimeInMilliseconds");
    }

    public void setSunDespawnTimeInMilliseconds(int time) {
        if (time <= 0)
            throw new IllegalArgumentException("Sun Despawn Time must be greater than 0");

        properties.setProperty("sunDespawnTimeInMilliseconds", String.valueOf(time));
    }
}
