import com.supsi.backend.model.plants.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlantsTest {

    @Test
    public void takeDamageTest() {
        Sunflower sf = new Sunflower();
        sf.takeDamage(20);
        AttackPlant ap = new AttackPlant();
        ap.takeDamage(20);
        DefensePlant dp = new DefensePlant();
        dp.takeDamage(20);

        assertEquals(80, sf.getHealth());
        assertEquals(80, ap.getHealth());
        assertEquals(180, dp.getHealth());
    }
}
