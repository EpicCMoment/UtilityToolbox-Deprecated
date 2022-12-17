package kozmikoda.utilitytoolbox.passwordcase;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GUIRunner extends Application{


    public void start(Stage window) throws Exception{

        FXMLLoader mainLayout = new FXMLLoader(getClass().getResource("gui.fxml"));
        Scene scene = new Scene(mainLayout.load(), 350, 500);

        scene.setFill(Color.TRANSPARENT);
        window.initStyle(StageStyle.TRANSPARENT);
        window.setScene(scene);
        window.show();

    }

    public static void main() {
        launch();
    }

}
