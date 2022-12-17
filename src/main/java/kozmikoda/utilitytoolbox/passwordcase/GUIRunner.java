package kozmikoda.utilitytoolbox.passwordcase;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GUIRunner extends Application{


    public void start(Stage s) throws Exception{


        FXMLLoader fxml = new FXMLLoader(getClass().getResource("gui.fxml"));
        Stage window = fxml.load();

        Scene scene = window.getScene();
        scene.setFill(Color.TRANSPARENT);
        window.initStyle(StageStyle.TRANSPARENT);
        window.setScene(scene);
        window.show();

    }

    public static void main() {
        launch();
    }

}
