package kozmikoda.utilitytoolbox.soundAnalyzer;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("CVFxml.fxml"));

        // FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CVFxml.fxml"));

        Stage window = fxml.load();



        Scene scene = window.getScene();
        scene.setFill(Color.TRANSPARENT);

        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("Cool Voice Finder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}