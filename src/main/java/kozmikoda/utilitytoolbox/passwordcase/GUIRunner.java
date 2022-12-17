package kozmikoda.utilitytoolbox.passwordcase;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import kozmikoda.utilitytoolbox.cvf.HelloApplication;

public class GUIRunner extends Application{


    public void start(Stage s) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("gui.fxml"));

        Stage mainWindow = loader.load();



        Scene scene = mainWindow.getScene();
        scene.setFill(Color.TRANSPARENT);

        mainWindow.initStyle(StageStyle.TRANSPARENT);
        mainWindow.setTitle("Cool Voice Finder");
        mainWindow.setScene(scene);
        mainWindow.show();

    }

    public static void main() {
        launch();
    }

}
