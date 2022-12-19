package kozmikoda.utilitytoolbox.passwordcase;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class GUIController {


    double offsetX, offsetY;

    private Stage stage;
    private Scene scene;


    @FXML
    void dragWindow(MouseEvent event) {

        Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
                //window.setX(event.getScreenX() - offsetX);
                //window.setY(event.getScreenY() - offsetY);
    }


    public void setWindowOffset(MouseEvent event) {
                offsetX = event.getSceneX();
                offsetY = event.getSceneY();

    }



    @FXML
    private void changeToScene2(ActionEvent event) throws IOException{
        scene = ((Stage)FXMLLoader.load(getClass().getResource("scene2.fxml"))).getScene();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void changeToScene1(ActionEvent event) throws IOException {
        scene = ((Stage)FXMLLoader.load(getClass().getResource("gui.fxml"))).getScene();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();

    }

}
