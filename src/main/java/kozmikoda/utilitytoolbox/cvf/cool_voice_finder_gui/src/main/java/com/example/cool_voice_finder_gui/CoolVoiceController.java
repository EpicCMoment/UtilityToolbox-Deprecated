package com.example.cool_voice_finder_gui;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;


public class CoolVoiceController {

    public File selectFile() {
        // File Dialog Part
        FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
        dialog.setFile("*.wav");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);

        // Get sound file's location
        File file = new File(dialog.getDirectory(), dialog.getFile());
        dialog.dispose();


        return file;
    }

    public String startCVF(File file) {

        // PREPROCESS
        // copying selected .wav file
        Path source = Paths.get(file.toString());
        Path newDir = Paths.get(System.getProperty("user.dir"));

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


        // RUN SCRIPT
        Process process;
        try {
            process = Runtime.getRuntime().exec(new String[]{"baban.exe"});
            // Waiting for the process to be finished
            process.waitFor();

        }catch(Exception e) {
            System.out.println("Exception Raised" + e.toString());
        }


        // GET OUTPUT
        // getting data from the out.txt that is created by our python script
        String data = "An error occurred.";
        try {
            Path txtPath = newDir.resolve("out.txt");
            File myObj = new File(txtPath.toString());
            Scanner myReader = new Scanner(myObj);

            data = myReader.nextLine();
            myReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return data;
    }
}
