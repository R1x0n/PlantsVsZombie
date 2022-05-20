package com.supsi.backend.model.others;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void getInitialPointsTest() {
        assertEquals(Integer.parseInt(getConfigProperty("initialPoints")), instance.getInitialPoints());
    }

    @Test
    public void getSunGenerationTimeTest() {
        assertEquals(Integer.parseInt(getConfigProperty("sunGenerationTimeInMilliseconds")), instance.getSunGenerationTimeInMilliseconds());
    }
}
