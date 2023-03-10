package kozmikoda.utilitytoolbox.soundAnalyzer;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class SoundAnalyzeApplication extends Application {
    double offsetX, offsetY;
    @Override
    public void start(Stage stage) throws IOException {
        // Loading the fxml
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("gui.fxml"));

        // Creating the window
        Stage window = fxml.load();

        window.getScene().setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                offsetX = event.getSceneX();
                offsetY = event.getSceneY();
            }
        });

        window.getScene().setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - offsetX);
                stage.setY(event.getScreenY() - offsetY);
            }
        });

        //Creating the scene
        Scene scene = window.getScene();

        // Stage and scene options
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