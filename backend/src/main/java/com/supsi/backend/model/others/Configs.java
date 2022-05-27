package com.supsi.backend.model.others;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configs {

    private static Configs config;

    private static final Properties properties = new Properties();
    private String propertyName;

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

    public void setProjectileDamage(int projectileDamage) {
        if (projectileDamage <= 0)
            throw new IllegalArgumentException("Projectile damage must be positive and non-zero");

        properties.setProperty("projectileDamage", String.valueOf(projectileDamage));
    }

    public int getPointsPerSun() {
        return getProperty("pointsPerSun");
    }

    public void setPointsPerSun(int pointsPerSun) {
        if (pointsPerSun <= 0)
            throw new IllegalArgumentException("Points per sun must be positive and non-zero");

        properties.setProperty("pointsPerSun", String.valueOf(pointsPerSun));
    }

    public int getSunflowerCost() {
        return getProperty("sunflowerCost");
    }

    public void setSunflowerCost(int sunflowerCost) {
        if (sunflowerCost <= 0)
            throw new IllegalArgumentException("Sunflower cost must be positive and non-zero");

        properties.setProperty("sunflowerCost", String.valueOf(sunflowerCost));
    }

    public int getAttackPlantCost() {
        return getProperty("attackPlantCost");
    }

    public void setAttackPlantCost(int attackPlantCost) {
        if (attackPlantCost <= 0)
            throw new IllegalArgumentException("Attack plant cost must be positive and non-zero");

        properties.setProperty("attackPlantCost", String.valueOf(attackPlantCost));
    }

    public int getDefensePlantCost() {
        return getProperty("defensePlantCost");
    }

    public void setDefensePlantCost(int defensePlantCost) {
        if (defensePlantCost <= 0)
            throw new IllegalArgumentException("Defense plant cost must be positive and non-zero");

        properties.setProperty("defensePlantCost", String.valueOf(defensePlantCost));
    }

    public int getInitialPoints() {
        return getProperty("initialPoints");
    }

    public void setInitialPoints(int initialPoints) {
        if (initialPoints < 0)
            throw new IllegalArgumentException("Initial points must be positive or zero");

        properties.setProperty("initialPoints", String.valueOf(initialPoints));
    }

    public int getSunGenerationTimeInMilliseconds() {
        return getProperty("sunGenerationTimeInMilliseconds");
    }

    public void setSunGenerationTimeInMilliseconds(int sunGenerationTimeInMilliseconds) {
        if (sunGenerationTimeInMilliseconds <= 0)
            throw new IllegalArgumentException("Sun generation time must be positive and non-zero");

        properties.setProperty("sunGenerationTimeInMilliseconds", String.valueOf(sunGenerationTimeInMilliseconds));
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
