package kozmikoda.utilitytoolbox.passwordcase;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GUIController {

    double offsetX, offsetY;

    @FXML
    private Scene mainLayout;

    @FXML
    private Pane titlebar;

    @FXML
    private Stage window;


    // bu titlebar ın onMousePressed eventi
    @FXML
    void dragWindow(MouseEvent event) {

                window.setX(event.getScreenX() - offsetX);
                window.setY(event.getScreenY() - offsetY);
    }

    // bu titlebar ın onMouseDragged eventi
    @FXML
    void setWindowOffset(MouseEvent event) {
                offsetX = event.getSceneX();
                offsetY = event.getSceneY();

    }

}
