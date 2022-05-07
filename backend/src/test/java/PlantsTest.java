import com.supsi.backend.model.plants.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlantsTest {

    @Test
    public void takeDamageTest() {
        Sunflower sf = new Sunflower();
        AttackPlant ap = new AttackPlant();
        DefensePlant dp = new DefensePlant();

        assertEquals(80, sf.takeDamage(20));
        assertEquals(80, ap.takeDamage(20));
        assertEquals(180, dp.takeDamage(20));
    }
}
