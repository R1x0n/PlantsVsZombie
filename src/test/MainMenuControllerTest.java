import com.ginsberg.junit.exit.ExpectSystemExitWithStatus;
import com.supsi.pvz.MainMenuController;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import org.junit.jupiter.api.Test;

class MainMenuControllerTest {

    MainMenuController mmc = new MainMenuController();
    MouseEvent simulatedMouseEvent = new MouseEvent(MouseEvent.MOUSE_CLICKED, 0,
            0, 0, 0, MouseButton.PRIMARY, 1, true, true, true, true,
            true, true, true, true, true, true, null);

    @Test
    @ExpectSystemExitWithStatus(0)
    public void exitGameTest() {
        mmc.exitGame(simulatedMouseEvent);
    }
}