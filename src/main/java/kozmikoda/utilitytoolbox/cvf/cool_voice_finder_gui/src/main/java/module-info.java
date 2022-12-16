module com.example.cool_voice_finder_gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;
    requires java.desktop;
    requires com.jfoenix;


    opens com.example.cool_voice_finder_gui to javafx.fxml;
    exports com.example.cool_voice_finder_gui;
}