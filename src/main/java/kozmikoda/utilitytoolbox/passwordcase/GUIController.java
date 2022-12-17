package kozmikoda.utilitytoolbox.passwordcase;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GUIController {

    double windowX, windowY;
    @FXML
    private AnchorPane mainBackground;

    @FXML
    private Scene mainScene;

    @FXML
    private Stage window;

    @FXML
    void dragWindow(MouseEvent event) {
        windowX = window.getX() - event.getScreenX();
        windowY = window.getY() - event.getScreenY();
    }

    @FXML
    void setWindowLocation(MouseEvent event) {
        window.setX(event.getScreenX() + windowX);
        window.setY(event.getScreenY() + windowY);
    }

}
