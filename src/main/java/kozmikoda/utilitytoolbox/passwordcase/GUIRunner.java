package kozmikoda.utilitytoolbox.passwordcase;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GUIRunner extends Application{

    Stage window;
    Scene mainScene;

    FXMLLoader fxml;


    public void start(Stage s) throws Exception{


        fxml = new FXMLLoader(getClass().getResource("gui.fxml"));
        window = fxml.load();

        window.initStyle(StageStyle.TRANSPARENT);

        mainScene = window.getScene();
        mainScene.setFill(Color.TRANSPARENT);

        window.setScene(mainScene);
        window.show();

    }

    public static void main() {
        launch();
    }

}
