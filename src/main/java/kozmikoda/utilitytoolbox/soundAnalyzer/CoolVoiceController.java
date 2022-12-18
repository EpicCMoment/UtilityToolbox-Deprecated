package kozmikoda.utilitytoolbox.soundAnalyzer;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;


public class CoolVoiceController extends Thread {
    Path source;
    Path newDir;
    TextField text;
    JFXButton selectButton;
    ProgressIndicator analyzeBar;
    Label analyzeLabel;


    public CoolVoiceController(File file, TextField text, JFXButton selectButton, ProgressIndicator analyzeBar, Label analyzeLabel) {
        this.source = Paths.get(file.toString());
        this.newDir = Paths.get(System.getProperty("user.dir"));
        this.text = text;
        this.selectButton = selectButton;
        this.analyzeBar = analyzeBar;
        this.analyzeLabel = analyzeLabel;
    }


    public void run() {
        Process process;
        try {
            process = Runtime.getRuntime().exec(new String[]{"soundAnalyzer.exe"});
            // Waiting for the process to be finished
            process.waitFor();

        }catch(Exception e) {
            System.out.println("Exception Raised" + e.toString());
        }

        String data = "An error occurred.";
        try {
            Path txtPath = this.newDir.resolve("out.txt");
            File myObj = new File(txtPath.toString());
            Scanner myReader = new Scanner(myObj);

            data = myReader.nextLine();
            myReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.analyzeBar.setVisible(false);
        this.analyzeLabel.setVisible(false);
        this.text.setVisible(true);
        this.text.setText(data);
        this.selectButton.setDisable(false);


    }

    public void startCVF() {

        // PREPROCESS
        // copying selected .wav file
        try {
            Files.copy(source, newDir.resolve(source.getFileName()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // rename the copied file to test.wav
        Path newPath = source.getFileName();
        try {
            // rename a file in the same directory
            Files.move(newPath, newPath.resolveSibling("test.wav"), StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }


        // GET OUTPUT
        // getting data from the out.txt that is created by our python script

    }
}
