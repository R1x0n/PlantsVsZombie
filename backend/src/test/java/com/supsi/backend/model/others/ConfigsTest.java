package com.supsi.backend.model.others;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class ConfigsTest {

    Configs instance = Configs.getInstance();

    private String getConfigProperty(String property) {
        String[] line = new String[2];
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/configs.properties"));
            do {
                line = br.readLine().split(" = ");
            } while (!line[0].equals(property));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line[1];
    }

    @Test
    public void getInstanceTest() {
        Configs instance2 = Configs.getInstance();
        assertEquals(instance2, instance);
    }

    @Test
    public void getPointsPerSunTest() {
        assertEquals(Integer.parseInt(getConfigProperty("pointsPerSun")), instance.getPointsPerSun());
    }

    @Test
    public void setPointsPerSunTest() {
        instance.setPointsPerSun(10);
        assertEquals(10, instance.getPointsPerSun());
    }

    @Test
    public void setPointsPerSunExceptionTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> instance.setPointsPerSun(-1));
        String expectedMessage = "Points per sun must be positive and non-zero";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void getInitialPointsTest() {
        assertEquals(Integer.parseInt(getConfigProperty("initialPoints")), instance.getInitialPoints());
    }

    @Test
    public void setInitialPointsTest() {
        instance.setInitialPoints(10);
        assertEquals(10, instance.getInitialPoints());
    }

    @Test
    public void setInitialPointsExceptionTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> instance.setInitialPoints(-1));
        String expectedMessage = "Initial points must be positive or zero";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void getSunGenerationTimeTest() {
        assertEquals(Integer.parseInt(getConfigProperty("sunGenerationTimeInMilliseconds")), instance.getSunGenerationTimeInMilliseconds());
    }

    @Test
    public void setSunGenerationTimeTest() {
        instance.setSunGenerationTimeInMilliseconds(10);
        assertEquals(10, instance.getSunGenerationTimeInMilliseconds());
    }

    @Test
    public void setSunGenerationTimeExceptionTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> instance.setSunGenerationTimeInMilliseconds(-1));
        String expectedMessage = "Sun generation time must be positive and non-zero";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void getProjectileDamageTest() {
        assertEquals(Integer.parseInt(getConfigProperty("projectileDamage")), instance.getProjectileDamage());
    }

    @Test
    public void setProjectileDamageTest() {
        instance.setProjectileDamage(10);
        assertEquals(10, instance.getProjectileDamage());
    }

    @Test
    public void setProjectileDamageExceptionTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> instance.setProjectileDamage(-1));
        String expectedMessage = "Projectile damage must be positive and non-zero";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void getSunflowerCostTest() {
        assertEquals(Integer.parseInt(getConfigProperty("sunflowerCost")), instance.getSunflowerCost());
    }

    @Test
    public void setSunflowerCostTest() {
        instance.setSunflowerCost(10);
        assertEquals(10, instance.getSunflowerCost());
    }

    @Test
    public void setSunflowerCostExceptionTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> instance.setSunflowerCost(-1));
        String expectedMessage = "Sunflower cost must be positive and non-zero";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void getAttackPlantCostTest() {
        assertEquals(Integer.parseInt(getConfigProperty("attackPlantCost")), instance.getAttackPlantCost());
    }

    @Test
    public void setAttackPlantCostTest() {
        instance.setAttackPlantCost(10);
        assertEquals(10, instance.getAttackPlantCost());
    }

    @Test
    public void setAttackPlantCostExceptionTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> instance.setAttackPlantCost(-1));
        String expectedMessage = "Attack plant cost must be positive and non-zero";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void getDefensePlantCostTest() {
        assertEquals(Integer.parseInt(getConfigProperty("defensePlantCost")), instance.getDefensePlantCost());
    }

    @Test
    public void setDefensePlantCostTest() {
        instance.setDefensePlantCost(10);
        assertEquals(10, instance.getDefensePlantCost());
    }

    @Test
    public void setDefensePlantCostExceptionTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> instance.setDefensePlantCost(-1));
        String expectedMessage = "Defense plant cost must be positive and non-zero";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void getSunGenerationTimeInMillisecondsTest() {
        assertEquals(Integer.parseInt(getConfigProperty("sunGenerationTimeInMilliseconds")), instance.getSunGenerationTimeInMilliseconds());
    }

    @Test
    public void setSunGenerationTimeInMillisecondsTest() {
        instance.setSunGenerationTimeInMilliseconds(10);
        assertEquals(10, instance.getSunGenerationTimeInMilliseconds());
    }

    @Test
    public void setSunGenerationTimeInMillisecondsExceptionTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> instance.setSunGenerationTimeInMilliseconds(-1));
        String expectedMessage = "Sun generation time must be positive and non-zero";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void setSunDespawnTimeInMilliseconds() {
        instance.setSunDespawnTimeInMilliseconds(10);
        assertEquals(10, instance.getSunDespawnTimeInMilliseconds());
    }

    @Test
    public void setSunDespawnTimeInMillisecondsExceptionTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> instance.setSunDespawnTimeInMilliseconds(-1));
        String expectedMessage = "Sun Despawn Time must be greater than 0";
        assertEquals(expectedMessage, exception.getMessage());
    }
}
