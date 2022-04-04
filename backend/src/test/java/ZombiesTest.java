import com.supsi.backend.model.zombies.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZombiesTest {

    @Test
    public void takeDamageTest() {
        NormalZombie nz = new NormalZombie();
        TankZombie tz = new TankZombie();
        RunnerZombie rz = new RunnerZombie();

        assertEquals(80, nz.takeDamage(20));
        assertEquals(180, tz.takeDamage(20));
        assertEquals(30, rz.takeDamage(20));
    }
}
