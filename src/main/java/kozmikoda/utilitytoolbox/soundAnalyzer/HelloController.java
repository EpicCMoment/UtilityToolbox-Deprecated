package kozmikoda.utilitytoolbox.soundAnalyzer;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

public class HelloController {
    double offsetX, offsetY;

    @FXML
    private ProgressIndicator analyzeBar;
    @FXML
    private Label analyzeLabel;
    @FXML
    private TextField output;
    @FXML
    private JFXButton selectButton;

    @FXML
    private Scene mainLayout;

    @FXML
    private Pane titlebar;

    @FXML
    private Stage window;
    FileChooser fileChooser = new FileChooser();
    Stage stage;

    @FXML
    void dragWindow (MouseEvent event) {

        window.setX(event.getScreenX() - offsetX);
        window.setY(event.getScreenY() - offsetY);
    }

    @FXML
    void setWindowOffset (MouseEvent event) {
        offsetX = event.getSceneX();
        offsetY = event.getSceneY();

    }

    @FXML
    protected void selectFileButton(ActionEvent event) {
        selectButton.setDisable(true);
        output.setVisible(false);
        output.setText(" ");
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

        // ADD INITIAL DIRECTORY TO EXAMPLE SOUND FILE DIRECTORY
        // fileChooser.setInitialDirectory(new File("C:\\Users\\sertac\\Desktop\\ayb-ceng463-machine-learning-project-fall-2022"));
        try {
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Wav Files", "*.wav")
            );

            File sound = fileChooser.showOpenDialog(stage);
            CoolVoiceController fileObj = new CoolVoiceController(sound, output, selectButton, analyzeBar, analyzeLabel);
            fileObj.startCVF();
            fileObj.start();
            analyzeBar.setVisible(true);
            analyzeLabel.setVisible(true);

        } catch (NullPointerException e) {
            output.setVisible(true);
            output.setText("You did not select a file!");
            selectButton.setDisable(false);
        }

        // output.setText(data);

    }

    @FXML
    protected void closeButton(ActionEvent event) {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();

    }

}