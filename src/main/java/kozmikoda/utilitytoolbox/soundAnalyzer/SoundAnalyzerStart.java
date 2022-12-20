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


public class SoundAnalyzerStart extends Thread {
    Path source;
    Path newDir;
    TextField output;
    JFXButton selectButton;
    ProgressIndicator analyzeBar;
    Label analyzeLabel;

    public SoundAnalyzerStart(File file, TextField output, JFXButton selectButton, ProgressIndicator analyzeBar, Label analyzeLabel) {
        source = Paths.get(file.toString());
        newDir = Paths.get(System.getProperty("user.dir"));
        this.output = output;
        this.selectButton = selectButton;
        this.analyzeBar = analyzeBar;
        this.analyzeLabel = analyzeLabel;
    }

    public void run() {
        Process process;
        String data = "Weird unknown error occurred. Please try again.";
        try {
            // Getting the exe path from resources file
            File exePath = new File(newDir.toString() + "\\src\\main\\resources\\kozmikoda\\utilitytoolbox\\soundAnalyzer\\");
            System.out.println(exePath);

            // Creating the process for execute the soundAnalyzer.exe
            process = Runtime.getRuntime().exec(new String[]{exePath.toString() + "\\soundAnalyzer.exe"}, null, exePath);
            process.info();
            // Waiting for the process to be finished
            process.waitFor();

        }catch(Exception e) {
            output.setText(data);
            e.printStackTrace();

        }

        // Reading the output from out.txt that is created by executable
        try {
            Path txtPath = newDir.resolve("src\\main\\resources\\kozmikoda\\utilitytoolbox\\soundAnalyzer\\out.txt");
            File myObj = new File(txtPath.toString());
            Scanner myReader = new Scanner(myObj);

            data = myReader.nextLine();
            myReader.close();

        } catch (FileNotFoundException ignored) {

        }

        // Change elements visibilities and texts after the operation
        analyzeBar.setVisible(false);
        analyzeLabel.setVisible(false);
        output.setVisible(true);
        output.setText(data);
        selectButton.setDisable(false);

    }

    public void prepareFile() {
        // PREPROCESS
        // copying selected .wav file
        Path soundPath = newDir.resolve(Paths.get("src\\main\\resources\\kozmikoda\\utilitytoolbox\\soundAnalyzer\\" + source.getFileName().toString()));
        try {
            Files.copy(source, soundPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // rename the copied file to test.wav
        try {
            // rename a file in the same directory
            Files.move(soundPath, soundPath.resolveSibling("test.wav"), StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
