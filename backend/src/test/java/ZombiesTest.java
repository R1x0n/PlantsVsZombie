import com.supsi.backend.model.zombies.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZombiesTest {

    @Test
    public void takeDamageTest() {
        NormalZombie nz = new NormalZombie();
        nz.takeDamage(20);
        TankZombie tz = new TankZombie();
        tz.takeDamage(20);
        RunnerZombie rz = new RunnerZombie();
        rz.takeDamage(20);

        assertEquals(80, nz.getHealth());
        assertEquals(180, tz.getHealth());
        assertEquals(30, rz.getHealth());
    }
}
