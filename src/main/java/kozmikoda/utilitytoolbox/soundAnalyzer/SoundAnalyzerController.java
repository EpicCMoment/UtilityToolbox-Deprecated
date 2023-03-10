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

public class SoundAnalyzerController {

    // FXML variables
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
    private Stage stage;


    // Selecting File
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

            // save the file that is chose by the user
            File sound = fileChooser.showOpenDialog(stage);
            // Creating the sound analyzer object
            SoundAnalyzerStart analyzerObj = new SoundAnalyzerStart(sound, output, selectButton, analyzeBar, analyzeLabel);

            // Calling the preprocessing function
            analyzerObj.prepareFile();
            // Starting the thread
            analyzerObj.start();

            // Changing the visibilities of progress bar and analyzing label
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